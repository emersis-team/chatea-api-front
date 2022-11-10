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
		log.error("Token del cliente: "+token);
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		request.runGet(this.url+"/api/admin/users");

		JSONObject response = request.getJson();
		log.error(response.keySet().toString());
		JSONArray apiUsers = response.getJSONArray("users");

		List<Usuario> usuarios = new ArrayList<>();

		for(int i=0;i<apiUsers.length();++i) {
			JSONObject apiGroups = apiUsers.getJSONObject(i);
			Usuario u = new Usuario(apiGroups);

			usuarios.add(u);
		}

		return usuarios;
	}

	public Long createContacts(Long userId, String token, StringEntity params) throws IOException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		request.runPut(this.url+"/api/users/"+userId, params);

		JSONObject response = request.getJson();
		return response.getJSONObject("user").getLong("id");
	}
}

