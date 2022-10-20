package ar.mil.cideso.Utils;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class UtilsHttp {
	private int statusCode;
	private String responseJsonString;
	private JSONObject responseJson;
	private String userId;
	private String userName;
	private String token = "";

	public UtilsHttp() { }

	public UtilsHttp(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	public void runGet(String url) throws IOException {
		CloseableHttpClient http = HttpClients.createDefault();
		HttpPost request = new HttpPost(url);
		CloseableHttpResponse response = http.execute(request);

		if(!token.isEmpty())
			request.setHeader("Authorization", this.token);

		this.statusCode = response.getStatusLine().getStatusCode();

		if(response.getStatusLine().getStatusCode() != HttpStatus.OK.value())
			throw new IOException("asdf");

		http.close();
		this.responseJsonString = EntityUtils.toString(response.getEntity());
	}

	public void runPost(String url, HttpEntity params) throws IOException {
		CloseableHttpClient http = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);

		if(!token.isEmpty())
			request.setHeader("Authorization", this.token);
		request.addHeader("content-type", "application/json");
		request.setEntity(params);

		CloseableHttpResponse response = http.execute(request);

		this.responseJsonString = EntityUtils.toString(response.getEntity());
		this.responseJson = new JSONObject(responseJsonString);
		this.statusCode = response.getStatusLine().getStatusCode();

		if(response.getStatusLine().getStatusCode() != HttpStatus.OK.value())
			throw new IOException("asdf");

		http.close();
	}

	public void runPost(String url, StringEntity params) throws IOException {
		try {
			CloseableHttpClient http = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(url);

			if(!token.isEmpty())
				request.setHeader("Authorization", this.token);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);

			CloseableHttpResponse response = http.execute(request);

			this.responseJsonString = EntityUtils.toString(response.getEntity());
			this.responseJson = new JSONObject(responseJsonString);
			this.statusCode = response.getStatusLine().getStatusCode();

			if(response.getStatusLine().getStatusCode() != HttpStatus.OK.value())
				throw new IOException("Could not call to the server");

			http.close();
		} catch(IOException e) {
			e.printStackTrace();
			throw new IOException("");
		}
	}

	public void generateToken() {
		if(this.userId == null || userId.isEmpty())
			return;
		
		if(this.userName == null || userName.isEmpty())
			return;

		try {
    	Algorithm algorithm = Algorithm.HMAC512("CIDESO");
			HashMap<String, String> payload = new HashMap<>();
			payload.put("user_id", this.userId);
			payload.put("user_name", this.userName);
    	this.token = "Bearer " + JWT.create()
        	.withIssuer(payload.toString())
        	.sign(algorithm);
		} catch (JWTCreationException e){
			System.out.println(e);
		}
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public JSONObject getJson() {
		return this.responseJson;
	}

	public String getString() {
		return this.responseJsonString;
	}
}

