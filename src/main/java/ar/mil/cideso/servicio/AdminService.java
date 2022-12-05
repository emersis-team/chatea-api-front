package ar.mil.cideso.servicio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import ar.mil.cideso.modelo.Groups;
import ar.mil.cideso.modelo.Usuario;

@Service
public class AdminService {

	private static final Logger log = LogManager.getLogger(AdminService.class);
	@Value( "${server.url}" )
	private String url;
	public AdminService() {}

	/*
	 * Modifico un usuario y lo hago admin
	 * */
	public Long createAdmin(Long userId, String token) throws IOException, UnsupportedEncodingException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		String payload = "{ \"admin\": 1}";
		StringEntity params = new StringEntity(payload);

		request.runPut(this.url+"/api/admin/user/"+userId, params);

		JSONObject response = request.getJson();

		return response.getJSONObject("user").getLong("id");
	}

	public Usuario getUser(Long userId, String token) throws IOException, UnsupportedEncodingException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		request.runGet(this.url+"/api/admin/user/"+userId);
		JSONObject response = request.getJson();
		log.error(response.toString());

		return new Usuario(response);
	}

	public Long createGroup(String name, String token) throws IOException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		String payload = String.format(
			"{ \"name\": \"%s\" }",//, \"direccion\": \"%s\", \"contact\": \"%s\"}",
			name
		);
		StringEntity params = new StringEntity(payload);

		request.runPost(this.url+"/api/admin/groups", params);

		log.error(request.getString());
		JSONObject response = request.getJson();

		return response.getJSONObject("group").getLong("id");
	}

	public List<Groups> getGroups(String token) throws IOException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		request.runGet(this.url+"/api/admin/groups");

		log.error(request.getString());
		JSONObject response = request.getJson();
		JSONArray apiGroups = response.getJSONArray("groups");

		List<Groups> groups = new ArrayList<>();

		for(int i=0;i<apiGroups.length();++i) {
			JSONObject apiGroup = apiGroups.getJSONObject(i);
			Groups g = new Groups(apiGroup);
			groups.add(g);
		}

		return groups;
	}

	public Groups findGroup(Long groupId, String token) throws IOException {
		UtilsHttp request = new UtilsHttp(token);

		request.runGet(this.url+"/api/admin/groups/"+groupId);

		JSONObject response = request.getJson();

		return new Groups(response);
	}
}

