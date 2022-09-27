package ar.mil.cideso.controller;

import java.io.IOException;
import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.mil.cideso.modelo.Usuario;
import ar.mil.cideso.servicio.LoginService;

@Controller
public class LoginController {

	@Value( "${server.url}" )
	private String url;
	@Autowired
	LoginService loginService;

	@PostMapping("/api/auth/login")
	public ResponseEntity<Usuario> login(@Valid @RequestBody Usuario userCredentials) throws ClientProtocolException, IOException {
		
		Usuario user = new Usuario();

		try {
			JSONObject userInfo = loginService.getUserInfo(userCredentials);
			//Long userId = userInfo.getLong("id");
			user.setId(0L);
			user.setEmail(userCredentials.getEmail());

			JSONArray apps = userInfo.getJSONArray("Aplicaciones");

			for (int i=0; i<apps.length(); ++i) {
				JSONObject app = apps.getJSONObject(i);
				if(loginService.findChatEAApp(app))
					return new ResponseEntity<Usuario>(user, HttpStatus.OK);
			}

			return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);

		} catch(IllegalStateException e) {
			e.printStackTrace();
    	return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(JSONException e) {
			e.printStackTrace();
    	return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

////	    if(respuesta != null && respuesta.getId() != null) {	  
////	    	Authentication authentication = new UsernamePasswordAuthenticationToken(entidad.getEmail(), entidad.getPassword(),
////	    				AuthorityUtils.createAuthorityList("Usuario"));
////        	SecurityContextHolder.getContext().setAuthentication(authentication);
//
//	    	return new ResponseEntity<Usuario>(respuesta, HttpStatus.OK);
	}
}
