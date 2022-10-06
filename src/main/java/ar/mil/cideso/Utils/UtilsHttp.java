package ar.mil.cideso.Utils;


import java.io.IOException;

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

public class UtilsHttp {
	private int statusCode;
	private String responseJsonString;
	private JSONObject responseJson;

	public void httpGetRequest(String url) throws IOException {
		CloseableHttpClient http = HttpClients.createDefault();
		HttpPost request = new HttpPost(url);
		CloseableHttpResponse response = http.execute(request);

		this.statusCode = response.getStatusLine().getStatusCode();

		if(response.getStatusLine().getStatusCode() != HttpStatus.OK.value())
			throw new IOException("asdf");

		http.close();
		this.responseJsonString = EntityUtils.toString(response.getEntity());
	}

	public void httpPostRequest(String url, HttpEntity params) throws IOException {
		CloseableHttpClient http = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);

		//httpPost.setHeader("Authorization", token);
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

	public void httpPostRequest(String url, StringEntity params) throws IOException {
		try {
			CloseableHttpClient http = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(url);

			//httpPost.setHeader("Authorization", token);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);

			CloseableHttpResponse response = http.execute(request);

			this.responseJsonString = EntityUtils.toString(response.getEntity());
			this.responseJson = new JSONObject(responseJsonString);
			this.statusCode = response.getStatusLine().getStatusCode();

			if(response.getStatusLine().getStatusCode() != HttpStatus.OK.value())
				throw new IOException("asdf");

			http.close();
		} catch(IOException e) {
			e.printStackTrace();
			throw new IOException("");
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

