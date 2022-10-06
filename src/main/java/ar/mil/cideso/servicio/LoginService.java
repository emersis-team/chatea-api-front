package ar.mil.cideso.servicio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.Utils.UtilsHttp;

@Service
public class LoginService {

	private String ApiKey = "C1De5o202i";
	private String CHAT_EA_ID = "4ec9bd54-0e5f-4652-afff-5b57acbde8cc";
	private String CHAT_EA_NAME = "ChatEA-Web";
	private CloseableHttpClient http;

	/**
	 * Obtiene la lista de aplicaciones del usuario del portal
	 */
	public JSONObject getAppList(Usuario userCredentials) throws IllegalStateException {
		try {
			HttpPost request = new HttpPost("http://cideso.com.ar/api/ApiCredenciales/APPs");
			String credentials = String.format(
				"{\"ApiKey\": \"%s\",\"Usuario\": \"%s\",\"Password\": \"%s\"}",
				ApiKey,	userCredentials.getEmail(), userCredentials.getPassword()
			);
			StringEntity params = new StringEntity(credentials);

			request.addHeader("content-type", "application/json");
			request.setEntity(params);

			CloseableHttpResponse response = this.http.execute(request);

			String responseJsonString = EntityUtils.toString(response.getEntity());
			JSONObject responseJson = new JSONObject(responseJsonString);

			if(response.getStatusLine().getStatusCode() != 200)
				throw new IllegalStateException("Error of credentials");

			this.http.close();
			return responseJson;
		} catch(JSONException | IOException e) {
			e.printStackTrace();
			throw new IllegalStateException("cant validate user");
		}
	}

	public Optional<JSONObject> getUser() throws UnsupportedEncodingException, IOException {
		String credentials = String.format("");
		StringEntity params = new StringEntity(credentials);
		UtilsHttp request = new UtilsHttp();
		request.httpPostRequest("api", params);
		JSONObject response = request.getJson();

		return Optional.ofNullable(response);
	}

	public Optional<Long> createUser() throws UnsupportedEncodingException, IOException {
		String credentials = String.format("");
		StringEntity params = new StringEntity(credentials);
		UtilsHttp request = new UtilsHttp();
		request.httpPostRequest("api", params);
		JSONObject response = request.getJson();

		return Optional.of(response.getLong(""));
	}

	public boolean findChatEAApp(JSONObject app) {
		return app.getString("Nombre").equals(CHAT_EA_NAME) && app.getString("id").equals(CHAT_EA_ID);
	}
}

