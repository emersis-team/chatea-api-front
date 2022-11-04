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

import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.servicio.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/new-admin/{user_id}")
	public ResponseEntity<Usuario> createLocation(
			@Valid @RequestBody Usuario user,
			@PathVariable(value = "user_id") Long id
	) {
		try {
			adminService.createAdmin(user.getId(), user.getEmail(), id);

			return new ResponseEntity<Usuario>(HttpStatus.OK);
		} catch(IOException e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/contactos")
	public ResponseEntity<Usuario> createLocation() {
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}

	@GetMapping("/contactos/{user_id}")
	public ResponseEntity<List<Usuario>> getLocations(
			@Valid @RequestBody Usuario u,
			@PathVariable(value = "user_id") Long id
	) {
		return new ResponseEntity<List<Usuario>>(HttpStatus.OK);
	}
}
