package ar.mil.cideso.servicio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.apache.http.entity.StringEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.Enums.ApiBackUri;
import ar.mil.cideso.Exception.NotExistException;
import ar.mil.cideso.Exception.NotPermissionException;
import ar.mil.cideso.Utils.UtilsHttp;

@Service
public class LoginService {

	private static final Logger log = LogManager.getLogger(LoginService.class);
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
	public Usuario validateUser(Usuario userCredentials) throws NotExistException, NotPermissionException {
		Usuario user = new Usuario();

		Optional<JSONObject> userResponse = Optional.empty();

		try {
			userResponse = this.getUser(userCredentials.getEmail());
		} catch(IOException e) {
			throw new NotPermissionException("could not validate the user");
		}
		Long userId = userResponse.map(u -> u.getJSONObject("user").getLong("id"))
			.orElseThrow(NotExistException::new);
		String dni = userResponse.map(u -> u.getJSONObject("user").getString("dni"))
			.orElseThrow(NotExistException::new);
		String userName = userResponse.map(u -> u.getJSONObject("user").getString("name"))
			.orElseThrow(NotExistException::new);
		String lastname = userResponse.map(u -> u.getJSONObject("user").getString("surname"))
			.orElseThrow(NotExistException::new);
		String grade = userResponse.map(u -> u.getJSONObject("user").getString("grade"))
			.orElseThrow(NotExistException::new);
		Long organization = userResponse.map(u -> u.getJSONObject("user").getLong("location_id"))
			.orElseThrow(NotExistException::new);

		UtilsHttp h = new UtilsHttp(userId.toString(), userName);
		h.generateToken();

		log.error("Id user: "+userId);

		user.setId(userId);
		user.setEmail(userCredentials.getEmail());
		user.setName(userName);
		user.setLastname(lastname);
		user.setDni(dni);
		user.setGrade(grade);
		user.setOrganization(organization.toString());

		user.setIsAdmin(
				userResponse.map(j -> j.getJSONObject("user"))
				.map(u -> u.getInt("admin"))
				.orElseThrow(NotExistException::new).equals(1)
		);

		user.setToken(h.getToken());

		return user;
	}

	/**
	 * Obtiene la lista de aplicaciones visible por el usuario del portal
	 */
	public JSONObject getAppList(Usuario userCredentials) throws NotPermissionException {
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
			if(responseJson.getString("Result").equals("210"))
				throw new NotPermissionException("wrong passwrod or user");

			return responseJson;
		} catch(JSONException | IOException e) {
			e.printStackTrace();
			throw new NotPermissionException("cant validate user");
		}
	}

	/**
	 * Chequea que exista la aplicacion de `ChatEaWeb` en el json
	 */
	private boolean findChatEAApp(JSONObject app) {
		return app.getString("Nombre").equals(CHAT_EA_NAME) && app.getString("id").equals(CHAT_EA_ID);
	}

	private Optional<JSONObject> getUser(String userName)
			throws UnsupportedEncodingException, NotExistException, IOException {
		UtilsHttp request = new UtilsHttp(userName);
		request.generateToken();

		JSONObject response = null;

		try {
			request.runGet(url+ApiBackUri._user);

			response = request.getJson();

			response
				.getJSONObject("user")
				.append("token", request.getToken());

			log.error(request.getString());
			return Optional.ofNullable(response);
		} catch(IOException e) {
			if(request.getStatusCode() == HttpStatus.NOT_FOUND.value())
				throw new NotExistException();
			throw new IOException();
		}
	}

	public JSONObject createUser(String name, String payload)
			throws UnsupportedEncodingException, IOException {
		StringEntity params = new StringEntity(payload);
		UtilsHttp request = new UtilsHttp(name);

		request.generateToken();
		request.runPost(url+ApiBackUri._userAdmin, params);

		JSONObject response = request.getJson();

		JSONObject user = response.getJSONObject("user");
		user.append("token", request.getToken());

		return user;
	}
}

