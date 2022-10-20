package ar.mil.cideso.servicio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.Exception.NotExistException;
import ar.mil.cideso.Exception.NotPermissionException;
import ar.mil.cideso.Utils.UtilsHttp;

@Service
public class LoginService {

	@Value( "${server.url}" )
	private String url;
	@Value( "${server.urlPortal}" )
	private String urlPortal;//= "https://cideso.com.ar";
	@Value( "${server.apikey}" )
	private String ApiKey;// = "C1De5o202i";

	private String CHAT_EA_ID = "4ec9bd54-0e5f-4652-afff-5b57acbde8cc";
	private String CHAT_EA_NAME = "ChatEA-Web";

	public LoginService() {}

	/*
	 * Valida un `Usuario` con el estado mayor usando su email y password
	 * */
	public Usuario validateUser(Usuario userCredentials) throws IOException, NotExistException, NotPermissionException {
		Usuario user = new Usuario();

		JSONObject appList = this.getAppList(userCredentials);
		JSONArray apps = appList.getJSONArray("Aplicaciones");

		Optional<JSONObject> userResponse = Optional.empty();
		try {
			for (int i=0; i<apps.length(); ++i) {
				JSONObject app = apps.getJSONObject(i);
				if(this.findChatEAApp(app))
					userResponse = this.getUser(user.getId());
			}
		} catch(IOException e) {
			throw new NotExistException();
		}

		if(!userResponse.isPresent())
			throw new NotPermissionException("El usuario no tiene permisos para acceder a chateaWeb");

		user.setId(userResponse.map(u -> u.getLong("id"))
			.orElseThrow(NotExistException::new)
		);

		user.setEmail(userCredentials.getEmail());

		user.setName(userResponse.map(u -> u.getString("id"))
			.orElseThrow(NotExistException::new)
		);

		return user;
	}

	/**
	 * Obtiene la lista de aplicaciones visible por el usuario del portal
	 */
	public JSONObject getAppList(Usuario userCredentials) throws IllegalStateException {
		try {

			String credentials = String.format(
				"{\"ApiKey\": \"%s\",\"Usuario\": \"%s\",\"Password\": \"%s\"}",
				ApiKey,	userCredentials.getEmail(), userCredentials.getPassword()
			);
			StringEntity params = new StringEntity(credentials);

			UtilsHttp request = new UtilsHttp();
			request.runPost(
				urlPortal+"/api/ApiCredenciales/APPs",
				params
			);

			JSONObject responseJson = request.getJson();

			if(request.getStatusCode() != HttpStatus.OK.value())
				throw new IllegalStateException("Error of credentials");

			return responseJson;
		} catch(JSONException | IOException e) {
			e.printStackTrace();
			throw new IllegalStateException("cant validate user");
		}
	}

	/**
	 * Chequea que exista la aplicacion de `ChatEaWeb` en el json
	 */
	private boolean findChatEAApp(JSONObject app) {
		return app.getString("Nombre").equals(CHAT_EA_NAME) &&
			app.getString("id").equals(CHAT_EA_ID);
	}

	private Optional<JSONObject> getUser(Long userId) throws UnsupportedEncodingException, IOException {
		UtilsHttp request = new UtilsHttp(userId.toString(), null);

		request.generateToken();
		request.runGet(url+"/user");

		JSONObject response = request.getJson();

		return Optional.ofNullable(response);
	}

	public Long createUser(String payload) throws UnsupportedEncodingException, IOException {
		StringEntity params = new StringEntity(payload);
		UtilsHttp request = new UtilsHttp();

		request.generateToken();
		request.runPost(url+"/user", params);

		JSONObject response = request.getJson();

		return response.getLong("id");
	}
}

