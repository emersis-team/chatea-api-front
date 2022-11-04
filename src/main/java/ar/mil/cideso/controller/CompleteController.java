package ar.mil.cideso.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.servicio.LoginService;

@Controller
public class CompleteController {
	@Autowired
	LoginService loginService;

	@PostMapping("/completion")
	public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario user) throws ClientProtocolException, IOException {

		String parameters = String.format(
			"{ \"user_name\": \"%s\", \"name\": \"%s\", \"surname\": \"%s\", \"dni\": \"%s\", \"grade\": \"%s\", \"location_id\": \"%s\"}",
			user.getEmail(),
			user.getName(),
			user.getLastname(),
			user.getDni(),
			user.getGrade(),
			1
		);

		Long id = loginService.createUser(user.getEmail(), parameters);
		user.setId(id);

		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
}

