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
import org.springframework.web.bind.annotation.RequestHeader;

import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.servicio.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/new-admin/{user_id}")
	public ResponseEntity<Usuario> createAdmin(
			@PathVariable(value = "user_id") Long id,
			@RequestHeader Map<String, String> headers
	) {
		try {
			String token = headers.get("authorization");
			adminService.createAdmin(id, token);

			return new ResponseEntity<Usuario>(HttpStatus.OK);
		} catch(IOException e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/user/{user_id}")
	public ResponseEntity<Usuario> getUser(
			@PathVariable(value = "user_id") Long id,
			@RequestHeader Map<String, String> headers
	) {
		try {
			String token = headers.get("authorization");
			Usuario u = adminService.getUser(id, token);

			return new ResponseEntity<Usuario>(u, HttpStatus.OK);
		} catch(IOException e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
