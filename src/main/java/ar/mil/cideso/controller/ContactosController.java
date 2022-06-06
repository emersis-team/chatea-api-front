package ar.mil.cideso.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.mil.cideso.modelo.Usuario;

@Controller
@RequestMapping(value = "/api")
public class ContactosController {
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getContactos() throws ClientProtocolException, IOException {
		
		List<Usuario> respuesta = new ArrayList<Usuario>();
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setEmail("Vale");
		respuesta.add(usuario);
		
		usuario = new Usuario();
		usuario.setId(2L);
		usuario.setEmail("Javi");
		respuesta.add(usuario);
		
		usuario = new Usuario();
		usuario.setId(3L);
		usuario.setEmail("Paul");
		respuesta.add(usuario);
		
		usuario = new Usuario();
		usuario.setId(4L);
		usuario.setEmail("Hernan");
		respuesta.add(usuario);
		
		usuario = new Usuario();
		usuario.setId(5L);
		usuario.setEmail("Gabriel");
		respuesta.add(usuario);
		
		usuario = new Usuario();
		usuario.setId(6L);
		usuario.setEmail("Brian");
		respuesta.add(usuario);
		
		usuario = new Usuario();
		usuario.setId(7L);
		usuario.setEmail("Ramiro");
		respuesta.add(usuario);
		
		usuario = new Usuario();
		usuario.setId(8L);
		usuario.setEmail("Rubén");
		respuesta.add(usuario);
		
		return new ResponseEntity<List<Usuario>>(respuesta, HttpStatus.OK);
	}
}
