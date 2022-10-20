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

	@PostMapping("/api/completion")
	public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario user) throws ClientProtocolException, IOException {

		String parameters = String.format(
			"{ \"name\": \"%s\", \"surname\": \"%s\", \"grade\": \"%s\" }",
			user.getName(),
			user.getLastname(),
			user.getGrade()
		);

		Long id = loginService.createUser(parameters);
		user.setId(id);

		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
}

