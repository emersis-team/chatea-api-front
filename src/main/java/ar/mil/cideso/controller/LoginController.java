package ar.mil.cideso.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.mil.cideso.modelo.Usuario;

@Controller
public class LoginController {

	@Value( "${server.url}" )
	private String url;
	
	@PostMapping("/api/v1/auth/login")
	public ResponseEntity<Usuario> login(@Valid @RequestBody Usuario entidad) throws ClientProtocolException, IOException {
		
		Usuario respuesta = new Usuario();
		respuesta.setEmail(entidad.getEmail());
		
		if(entidad.getPassword().equals("password")) {
			switch(entidad.getEmail()) {
				case "vale":
					respuesta.setId(1L);
					break;
				case "javi":
					respuesta.setId(2L);
					break;
				case "paul":
					respuesta.setId(3L);
					break;
				case "hernan":
					respuesta.setId(4L);
					break;
				case "gabriel":
					respuesta.setId(5L);
					break;
				case "brian":
					respuesta.setId(6L);
					break;
				case "ruben":
					respuesta.setId(7L);
					break;
				case "ramiro":
					respuesta.setId(8L);
					break;
			}			
		}

	    if(respuesta != null && respuesta.getId() != null) {	  
//	    	Authentication authentication = new UsernamePasswordAuthenticationToken(entidad.getEmail(), entidad.getPassword(),
//	    				AuthorityUtils.createAuthorityList("Usuario"));
//        	SecurityContextHolder.getContext().setAuthentication(authentication);

	    	return new ResponseEntity<Usuario>(respuesta, HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
	    }
	}
}
