package ar.mil.cideso.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.mil.cideso.Exception.NotExistException;
import ar.mil.cideso.Exception.NotPermissionException;
import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.servicio.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/auth/login")
	public ResponseEntity<Usuario> login(@Valid @RequestBody Usuario userCredentials) throws ClientProtocolException, IOException {
		try {
			Usuario user = loginService.validateUser(userCredentials);

			return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		} catch(NotExistException e) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		} catch(NotPermissionException e) {
			e.printStackTrace();
			return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
		} catch(JSONException e) {
			e.printStackTrace();
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

