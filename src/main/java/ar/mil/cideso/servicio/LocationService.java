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

	public Location findLocation(Long id, String token) throws IOException{
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		request.runGet(this.url+"/api/admin/locations/"+id);

		log.error(request.getString());
		JSONObject response = request.getJson();

		Location l = new Location(response);

		return l;
	}

	public List<Location> getLocations(String token) throws IOException{
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);
		request.runGet(this.url+"/api/admin/locations");

		log.error(request.getString());
		JSONObject response = request.getJson();
		JSONArray apiLocations = response.getJSONArray("locations");

		List<Location> locations = new ArrayList<>();

		for(int i=0;i<apiLocations.length();++i) {
			JSONObject apiLocation = apiLocations.getJSONObject(i);
			Location l = new Location(apiLocation);
			locations.add(l);
		}

		return locations;
	}

	public Long createLocation(String name, String token) throws UnsupportedEncodingException, IOException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(token);

		String credentials = String.format(
			"{ \"name\": \"%s\" }", name
		);
		StringEntity params = new StringEntity(credentials);
		request.runPost(this.url+"/api/admin/locations", params);

		JSONObject response = request.getJson();

		return response.getJSONObject("location").getLong("id");
	}
}

