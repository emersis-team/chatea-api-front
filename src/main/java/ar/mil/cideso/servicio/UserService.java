package ar.mil.cideso.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.StringEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ar.mil.cideso.Utils.UtilsHttp;
import ar.mil.cideso.modelo.Usuario;

@Service
public class UserService {

	private static final Logger log = LogManager.getLogger(UserService.class);

	@Value( "${server.url}" )
	private String url;
	public UserService() {}

	public Usuario findUsers(Long userId, String token) throws IOException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		request.runGet(this.url+"/api/users/"+userId);

		JSONObject response = request.getJson();

		return new Usuario(response.getJSONObject("usuario"));
	}

	public List<Usuario> getUsers(String token) throws IOException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		request.runGet(this.url+"/api/admin/users");

		JSONObject response = request.getJson();

		JSONArray apiUsers = response.getJSONArray("users");

		List<Usuario> usuarios = new ArrayList<>();

		for(int i=0;i<apiUsers.length();++i) {
			JSONObject apiUser = apiUsers.getJSONObject(i);

			JSONObject user = new JSONObject();
			user.put("user", apiUser);

			Usuario u = new Usuario(user);

			usuarios.add(u);
		}

		return usuarios;
	}

	public List<Usuario> getContacts(Long userId, String token) throws IOException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		request.runGet(this.url+"");

		JSONObject response = request.getJson();

		JSONArray apiUsers = response.getJSONArray("users");

		List<Usuario> usuarios = new ArrayList<>();

		for(int i=0;i<apiUsers.length();++i) {
			JSONObject apiUser = apiUsers.getJSONObject(i);

			JSONObject user = new JSONObject();
			user.put("user", apiUser);

			Usuario u = new Usuario(user);

			usuarios.add(u);
		}

		return usuarios;
	}

	public Long createContacts(Long userId, String token, StringEntity params) throws IOException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		request.runPut(this.url+"/api/admin/user/"+userId, params);

		JSONObject response = request.getJson();
		return response.getJSONObject("user").getLong("id");
	}
}

