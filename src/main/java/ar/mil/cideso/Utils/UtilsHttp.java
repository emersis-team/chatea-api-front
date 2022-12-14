package ar.mil.cideso.Utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
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

	public UtilsHttp(String userName) {
		this.userName = userName;
	}

	public UtilsHttp(String id, String userName) {
		this.userId = id;
		this.userName = userName;
	}

	public void runGet(String url) throws IOException {
		HttpGet request = new HttpGet(url);

		if(!this.token.isEmpty())
			request.setHeader(HttpHeaders.AUTHORIZATION, this.token);
		else
			log.warn("No token generated for "+url);

		this.processRequest(request, url);
	}

	public void runPut(String url, StringEntity params) throws IOException {
		HttpPut request = new HttpPut(url);

		if(!token.isEmpty())
			request.setHeader(HttpHeaders.AUTHORIZATION, this.token);
		else
			log.warn("No token generated for "+url);

		request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		request.setEntity(params);

		this.processRequest(request, url);
	}

	public void runPost(String url, HttpEntity params) throws IOException {
		HttpPost request = new HttpPost(url);

		if(!this.token.isEmpty())
			request.setHeader(HttpHeaders.AUTHORIZATION, this.token);
		else
			log.warn("No token generated for "+url);

		request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		request.setEntity(params);

		this.processRequest(request, url);
	}

	public void runPost(String url, StringEntity params) throws IOException {
		HttpPost request = new HttpPost(url);

		if(!token.isEmpty())
			request.setHeader(HttpHeaders.AUTHORIZATION, this.token);
		else
			log.warn("No token generated for "+url);

		request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		request.setEntity(params);

		this.processRequest(request, url);
	}

	/**
	 * execute some request and save the response and parse to json
	 * */
	private void processRequest(HttpUriRequest request, String url) throws IOException {
		CloseableHttpClient http = HttpClientBuilder.create().build();
		CloseableHttpResponse response = http.execute(request);

		this.statusCode = response.getStatusLine().getStatusCode();

		if(this.statusCode != HttpStatus.OK.value()) {
			this.responseJsonString = this.parseResponseToJson(response.getEntity()); 
			log.error(this.responseJsonString);
			throw new IOException("Error calling the server "+ url +". status code: " + this.statusCode);
		}

		/* 
		 * puede que no todos los request respondan con un json 
		 * asi que no mando un error si no puedo parsear el request
		 * TODO: que parseResponseToJson no lance error y parsee siempre el request
		 * */
		try {
			this.responseJsonString = this.parseResponseToJson(response.getEntity()); 
			this.responseJson = new JSONObject(responseJsonString);
			if(responseJson.has("error"))
				throw new IOException("error que no deberia ser un 200");

			http.close();
		} catch(ArrayIndexOutOfBoundsException e) {
			log.error("Array out "+EntityUtils.toString(response.getEntity()).split("\\{", 2)[0]); 
		} catch(JSONException e) {
			e.printStackTrace();
			log.warn("Error parsing response of "+url);
		}
	}

	private String parseResponseToJson(HttpEntity info) throws IOException {
		return "{"+EntityUtils.toString(info).split("\\{", 2)[1];
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

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

