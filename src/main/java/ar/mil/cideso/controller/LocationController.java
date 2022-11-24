package ar.mil.cideso.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import ar.mil.cideso.context.LocationContext;
import ar.mil.cideso.modelo.Location;
import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.servicio.LocationService;

@Controller
public class LocationController {

	@Autowired
	LocationService locationService;

	@PostMapping("/locations")
	public ResponseEntity<Location> createLocation(
		@RequestBody Location l,
		@RequestHeader Map<String, String> headers
	) {
		String token = headers.get("authorization");
		Location newLocation = new Location();
		try {
			
			Long id = locationService.createLocation(
				l.getName(),
				token
			);
			newLocation.setId(id);
			newLocation.setName(l.getName());

			return new ResponseEntity<Location>(newLocation, HttpStatus.OK);
		} catch(IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Location>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/locations")
	public ResponseEntity<List<Location>> getLocations(
		@RequestHeader Map<String, String> headers
	) {
		String token = headers.get("authorization");
		try {
			List<Location> locations = locationService.getLocations(token);

			return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
		} catch(IOException e) {
			e.printStackTrace();
			return new ResponseEntity<List<Location>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/locations/{id}")
	public ResponseEntity<Location> getLocation(
			@PathVariable(value = "id") Long id,
			@RequestBody Usuario u,
		@RequestHeader Map<String, String> headers
	) throws IOException { 
		String token = headers.get("authorization");
		Location l = locationService.findLocation(id, token);
		return new ResponseEntity<Location>(l, HttpStatus.OK);
	}
}

