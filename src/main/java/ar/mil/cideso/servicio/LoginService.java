package ar.mil.cideso.servicio;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import ar.mil.cideso.modelo.Usuario;

@Service
public class LoginService {

	private String ApiKey = "C1De5o202i";

	public JSONObject getUserInfo(Usuario userCredentials) throws IllegalStateException {
		try {
			CloseableHttpClient http = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost("https://cideso.com.ar/api/ApiCredenciales/APPs");

			String credentials = String.format(
					"{\"ApiKey\": \"%s\",\"Usuario\": \"%s\",\"Password\": \"%s\"}",
					ApiKey,	userCredentials.getEmail(), userCredentials.getPassword()
					);

			StringEntity params = new StringEntity(credentials);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);

			CloseableHttpResponse response = http.execute(request);

			String responseJsonString = EntityUtils.toString(response.getEntity());

			JSONObject responseJson = new JSONObject(responseJsonString);

			if(response.getStatusLine().getStatusCode() != 200)
				throw new IllegalStateException("Error of credentials");

			http.close();
			return responseJson;
		} catch(JSONException | IOException e) {
			e.printStackTrace();
			throw new IllegalStateException("cant validate user");
		}
	}

	public boolean findChatEAApp(JSONObject app) {

		app.keySet().stream().forEach(s -> System.out.println(s));
		return true;//name.equals("");
	}
}

