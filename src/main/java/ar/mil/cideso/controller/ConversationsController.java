package ar.mil.cideso.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import ar.mil.cideso.Utils.UtilsHttp;

@Controller
public class ConversationsController {

	@Value( "${server.url}" )
	private String url;
	
	@GetMapping("/conversations")
	public ResponseEntity<String> getConversaciones(
		@RequestHeader("authorization") String authorization
	) throws ClientProtocolException, IOException {
		
		UtilsHttp request = new UtilsHttp();
		try {
			request.setToken(authorization);
			request.runGet(
				url + "/api/conversations"
			);
			String responseString = request.getString();

			return new ResponseEntity<String>(responseString, HttpStatus.OK);	    		

		} catch(IOException e) {
			return new ResponseEntity<String>(HttpStatus.valueOf(request.getStatusCode()));
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{idUsuario}/conversations/{idConversacion}")
	public ResponseEntity<String> getChat(
		@RequestHeader("authorization") String authorization,
		@PathVariable(value = "idUsuario") Long idUsuario,
		@PathVariable(value = "idConversacion") Long idConversacion,
		@RequestParam String page
	) throws ClientProtocolException, IOException {
		UtilsHttp request = new UtilsHttp();
		request.setToken(authorization);
		try {
			request.runGet(
				url + "/api/conversations/" + idConversacion + "?page=" + page
			);
			String responseString = request.getString();

			return new ResponseEntity<String>(responseString, HttpStatus.OK);
		} catch(IOException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.valueOf(request.getStatusCode()));
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
