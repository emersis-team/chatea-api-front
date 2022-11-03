package ar.mil.cideso.servicio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ar.mil.cideso.Utils.UtilsHttp;

@Service
public class AdminService {

	private static final Logger log = LogManager.getLogger(AdminService.class);
	@Value( "${server.url}" )
	private String url;

	public AdminService() {}

	/*
	 * Modifico un usuario y lo hago admin
	 * */
	public Long createAdmin(Long id, String name, Long userId) throws IOException, UnsupportedEncodingException {
		UtilsHttp request = new UtilsHttp(id, name);
		request.generateToken();

		String payload = "{ \"admin\": 1}";
		StringEntity params = new StringEntity(payload);

		request.runPut(this.url+"/api/admin/user/"+userId, params);

		JSONObject response = request.getJson();

		return response.getJSONObject("user").getLong("id");
	}
}

