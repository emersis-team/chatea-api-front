package ar.mil.cideso.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.mil.cideso.modelo.Usuario;

@Controller
@RequestMapping(value = "/api")
public class LogoutController {

	@Value( "${server.url}" )
	private String url;
	
	@PostMapping("/v1/auth/logout")
	public ResponseEntity<String> logout(@RequestHeader("Authorization") String authorization) throws ClientProtocolException, IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost(url + "/api/v1/auth/logout");
	    
	    httpPost.setHeader("Authorization", authorization);

	    CloseableHttpResponse response = client.execute(httpPost);

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
