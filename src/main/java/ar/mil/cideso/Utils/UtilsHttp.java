package ar.mil.cideso.Utils;

import java.io.IOException;

import javax.swing.text.html.parser.Entity;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class UtilsHttp {

	private static final Logger log = LogManager.getLogger(UtilsHttp.class);
	private int statusCode;
	private String responseJsonString;
	private JSONObject responseJson;
	private JSONArray responseArray;
	private String userId = null;
	private String userName = null;
	private String token = "";

	public UtilsHttp() { }

	public UtilsHttp(Long userId, String userName) {
		this.userId = userId.toString();
		this.userName = userName;
	}

	public UtilsHttp(Long userId) {
		this.userId = userId.toString();
	}

	public UtilsHttp(String userName) {
		this.userName = userName;
	}

	public void runGet(String url) throws IOException {
		CloseableHttpClient http = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);

		if(!this.token.isEmpty())
			request.setHeader(HttpHeaders.AUTHORIZATION, this.token);
		else
			log.warn("No token generated for "+url);

		CloseableHttpResponse response = http.execute(request);

		this.statusCode = response.getStatusLine().getStatusCode();

		this.responseJsonString = this.splitResponseToJson(response.getEntity()); 

		if(response.getStatusLine().getStatusCode() != HttpStatus.OK.value()) {
			throw new IOException("Error call "+url+". status code: " + this.statusCode);
		}

		try {
			this.responseJson = new JSONObject(responseJsonString);
		} catch(JSONException _e) {
			this.responseArray = new JSONArray(responseJsonString);
		}

		http.close();
	}

	public void runPost(String url, HttpEntity params) throws IOException {
		CloseableHttpClient http = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);

		if(!this.token.isEmpty())
			request.setHeader(HttpHeaders.AUTHORIZATION, this.token);
		else
			log.warn("No token generated for "+url);

		request.addHeader("content-type", "application/json");
		request.setEntity(params);

		CloseableHttpResponse response = http.execute(request);

		this.statusCode = response.getStatusLine().getStatusCode();

		if(response.getStatusLine().getStatusCode() != HttpStatus.OK.value())
			throw new IOException("Error calling the server "+url+". status code: " + this.statusCode);

		this.responseJsonString = this.splitResponseToJson(response.getEntity()); 
		http.close();
	}

	public void runPost(String url, StringEntity params) throws IOException {
		CloseableHttpClient http = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);

		if(!token.isEmpty())
			request.setHeader(HttpHeaders.AUTHORIZATION, this.token);
		else
			log.warn("No token generated for "+url);

		request.addHeader("content-type", "application/json");
		request.setEntity(params);

		CloseableHttpResponse response = http.execute(request);

		this.statusCode = response.getStatusLine().getStatusCode();

		if(response.getStatusLine().getStatusCode() != HttpStatus.OK.value()) {
			throw new IOException("Error calling the server "+ url +". status code: " + this.statusCode);
		}

		try {
			this.responseJsonString = this.splitResponseToJson(response.getEntity()); 
			this.responseJson = new JSONObject(responseJsonString);

			http.close();
		} catch(JSONException e) {
			e.printStackTrace();
			log.error(url+" Exception");
			throw new IOException("");
		}
	}

	public void generateToken() {

		try {
    	Algorithm algorithm = Algorithm.HMAC512("CIDESO");
			Builder b = JWT.create();
				b.withClaim("user_name", this.userName);
				b.withClaim("user_id", this.userId);

    	this.token = "Bearer " + b.sign(algorithm);
		} catch (JWTCreationException e){
			log.error(e);
		}
	}

	private String splitResponseToJson(HttpEntity info) throws IOException {
		return "{"+EntityUtils.toString(info).split("\\{", 2)[1];
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public JSONObject getJson() {
		return this.responseJson;
	}

	public JSONArray getArray() {
		return this.responseArray;
	}

	public String getString() {
		return this.responseJsonString;
	}
}

