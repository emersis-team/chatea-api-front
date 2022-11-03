package ar.mil.cideso.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import ar.mil.cideso.context.LocationContext;
import ar.mil.cideso.modelo.Location;
import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.servicio.LocationService;

@Controller
public class LocationController {

	@Autowired
	LocationService locationService;

	@PostMapping("/api/locations")
	public ResponseEntity<Location> createLocation(@Valid @RequestBody LocationContext l) {

		try {
			Location newLocation = new Location();
			Long id = locationService.createLocation(
				l.getLocation().getName(),
				l.getUsuario().getId(),
				l.getUsuario().getName()
			);
			newLocation.setId(id);

			return new ResponseEntity<Location>(newLocation, HttpStatus.OK);
		} catch(IOException e) {
			return new ResponseEntity<Location>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/api/locations")
	public ResponseEntity<List<Location>> getLocations(
		@RequestParam("id") String id,
		@RequestParam("name") String name
	) {
		try {
			List<Location> locations = locationService.getLocations(Long.valueOf(id), name);

			return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
		} catch(IOException e) {
			e.printStackTrace();
			return new ResponseEntity<List<Location>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/api/locations/{id}")
	public ResponseEntity<Location> getLocations(
			@PathVariable(value = "id") Long id,
			@Valid @RequestBody Usuario u
	) throws IOException { 
		Location l = locationService.findLocation(id, u.getId(), u.getName());
		return new ResponseEntity<Location>(l, HttpStatus.OK);
	}
}

