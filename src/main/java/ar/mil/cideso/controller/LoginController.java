package ar.mil.cideso.controller;

import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Optional;

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
			JSONObject appList = loginService.getAppList(userCredentials);

			JSONArray apps = appList.getJSONArray("Aplicaciones");
			Long id = 0L;
			Optional<JSONObject> userResponse = Optional.empty();

			for (int i=0; i<apps.length(); ++i) {
				JSONObject app = apps.getJSONObject(i);
				if(loginService.findChatEAApp(app))
					userResponse = loginService.getUser();
			}

			id = userResponse.map(u -> u.getLong("id")).orElse(0L);

			if(id == 0L)
				id = loginService.createUser().orElseThrow(RuntimeException::new);

			user.setId(id);
			user.setEmail(userCredentials.getEmail());

			return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		} catch(IllegalFormatException e) {
			e.printStackTrace();
    	return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(JSONException|IOException e) {
			e.printStackTrace();
    	return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			//return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
	}
}

