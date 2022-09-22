package ar.mil.cideso.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.mil.cideso.config.JwtTokenUtil;

@Controller
@RequestMapping(value = "/api")
public class ConversationsController {

	@Value( "${server.url}" )
	private String url;
	
	@GetMapping("/{id}/conversations")
	public ResponseEntity<String> getConversaciones( @RequestHeader("Authorization") String authorization, @PathVariable(value = "id") Long id) throws ClientProtocolException, IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url + "/api/"+ id +"/conversations");

		JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

		System.out.println("******************////////////////////////////   TOKEN    //////////////////////////******************");
		System.out.println(jwtTokenUtil.generateToken(String.valueOf(id)));
		System.out.println("******************////////////////////////////   TOKEN    //////////////////////////******************");
		httpGet.setHeader("Authorization", jwtTokenUtil.generateToken(String.valueOf(id)));

	    CloseableHttpResponse response = client.execute(httpGet);
	    if(response.getStatusLine().getStatusCode() == 200) {
	    	try {
	    		HttpEntity entity = response.getEntity();
	    		String responseString = EntityUtils.toString(entity, "UTF-8");
	    		client.close();
	    		
	    		return new ResponseEntity<String>(responseString, HttpStatus.OK);	    		
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }else {
	    	return new ResponseEntity<String>(HttpStatus.valueOf(response.getStatusLine().getStatusCode()));
	    }
	}
	
	@GetMapping("/{idUsuario}/conversations/{idConversacion}")
	public ResponseEntity<String> getChat(@RequestHeader("Authorization") String authorization, @PathVariable(value = "idUsuario") Long idUsuario,
			@PathVariable(value = "idConversacion") Long idConversacion, @RequestParam String page) throws ClientProtocolException, IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url + "/api/"+ idUsuario +"/conversations/" + idConversacion + "?page=" + page);
		
//		httpGet.setHeader("Authorization", authorization);

	    CloseableHttpResponse response = client.execute(httpGet);
	    if(response.getStatusLine().getStatusCode() == 200) {
	    	try {
	    		HttpEntity entity = response.getEntity();
	    		String responseString = EntityUtils.toString(entity, "UTF-8");
	    		client.close();	    	
	    		
	    		return new ResponseEntity<String>(responseString, HttpStatus.OK);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	    	}	    	
	    }else {
	    	return new ResponseEntity<String>(HttpStatus.valueOf(response.getStatusLine().getStatusCode()));
	    }
	}
}
