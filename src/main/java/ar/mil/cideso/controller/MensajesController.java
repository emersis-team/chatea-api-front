package ar.mil.cideso.controller;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class MensajesController {

	@Value( "${server.url}" )
	private String url;
	
	@GetMapping("/v1/messages")
	public ResponseEntity<String> getMensajes(@RequestHeader("Authorization") String authorization) throws ClientProtocolException, IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url + "/api/v1/messages");
		
		httpGet.setHeader("Authorization", authorization);

	    CloseableHttpResponse response = client.execute(httpGet);
	    if(response.getStatusLine().getStatusCode() == 200) {
	    	HttpEntity entity = response.getEntity();
	    	String responseString = EntityUtils.toString(entity, "UTF-8");
	    	client.close();
	    	
	    	return new ResponseEntity<String>(responseString, HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	    }

	}
}
