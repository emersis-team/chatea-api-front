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
import ar.mil.cideso.modelo.Location;

@Service
public class LocationService {

	private static final Logger log = LogManager.getLogger(LocationService.class);

	@Value("${server.url}")
	String url;

	public LocationService() {}

	public Location findLocation(Long id, Long userId, String userName) throws IOException{
		UtilsHttp request = new UtilsHttp(userId, userName);
		request.generateToken();
		request.runGet(this.url+"/api/admin/locations/"+id);
		log.error(request.getString());
		JSONObject response = request.getJson();
		Location l = new Location(response);

		return l;
	}

	public List<Location> getLocations(Long userId, String userName) throws IOException{
		UtilsHttp request = new UtilsHttp(userId, userName);
		request.generateToken();
		request.runGet(this.url+"/api/admin/locations") f

		return locations;
	}

	public Long createLocation(String name, Long userId, String userName) throws UnsupportedEncodingException, IOException {
		UtilsHttp request = new UtilsHttp(userId, userName);
		request.generateToken();

		String credentials = String.format(
			"\"name\": \"%s\"", name
		);
		StringEntity params = new StringEntity(credentials);
		request.runPost(this.url+"/api/admin/locations", params);
		JSONObject response = request.getJson();

		return response.getLong("id");
	}
}

