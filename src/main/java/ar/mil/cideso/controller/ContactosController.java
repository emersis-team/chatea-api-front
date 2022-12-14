package ar.mil.cideso.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import ar.mil.cideso.context.ContactContext;
import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.servicio.UserService;

@Controller
public class ContactosController {
	
	@Autowired
	UserService userService;

	@PutMapping("/nuevosContactos/{user_id}")
	public ResponseEntity<String> addContacts(
		@PathVariable(value = "user_id") Long id,
		@RequestBody ContactContext contacts,
		@RequestHeader Map<String, String> headers
	) throws ClientProtocolException, IOException {
		String token = headers.get("authorization");

		String contactFormated = contacts.getContacts();
		String groupFormated = contacts.getGroups();

		String credentials = String.format(
			"{ \"contacts\": %s, \"groups\": %s }",
			contactFormated, groupFormated
		);
		System.out.println(credentials);
		StringEntity params = new StringEntity(credentials);

		userService.createContacts(id, token, params);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@GetMapping("/contactos/{user_id}")
	public ResponseEntity<String> getContacts(
		@PathVariable(value = "user_id") Long id,
		@RequestHeader Map<String, String> headers
		) throws IOException{ 
			String token = headers.get("authorization");
			userService.getContacts(id, token);
			return new ResponseEntity<String>("", HttpStatus.OK);
		}

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios(
		@RequestHeader Map<String, String> headers
	) throws IOException {
		String token = headers.get("authorization");
		return new ResponseEntity<List<Usuario>>(userService.getUsers(token), HttpStatus.OK);
	}
}
