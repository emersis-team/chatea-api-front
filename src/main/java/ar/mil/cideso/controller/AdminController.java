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

import ar.mil.cideso.context.LocationContext;
import ar.mil.cideso.modelo.Location;
import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.servicio.LocationService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/new-admin/{user_id}")
	public ResponseEntity<Usuario> createLocation(
			@Valid @RequestBody Usuario user
			@PathVariable(value = "user_id") Long id,
	) {
		adminService.createAdministrator(user.getId(), user.getEmail(), id);
	}

	@PostMapping("/contactos")
	public ResponseEntity<Usuario> createLocation(@Valid @RequestBody LocationContext l) {

	}

	@GetMapping("/contactos/{user_id}")
	public ResponseEntity<List<Location>> getLocations(
			@Valid @RequestBody Usuario u,
			@PathVariable(value = "user_id") Long id,
			) {

	}
}
