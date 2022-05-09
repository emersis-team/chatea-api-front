package ar.mil.cideso.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import ar.mil.cideso.modelo.Mensaje;

@Controller
@RequestMapping(value = "/api")
public class ChatController {

	@Value( "${server.url}" )
	private String url;
	
	private static final String DIRECTORY = "E:/Trabajo/CIDESO/chat ea/Files";
	
	@GetMapping("/v1/messages/{id}")
	public ResponseEntity<String> getChat(@RequestHeader("Authorization") String authorization, @PathVariable(value = "id") Long id) throws ClientProtocolException, IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url + "/api/v1/messages/" + id);
		
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
	
	@PostMapping("/v1/messages/textMessage")
	public ResponseEntity<String> postChat(@RequestHeader("Authorization") String authorization, @ModelAttribute Mensaje entidad) throws ClientProtocolException, IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url + "/api/v1/messages/textMessage");
		
		httpPost.setHeader("Authorization", authorization);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("message", entidad.getMessage()));
	    params.add(new BasicNameValuePair("receiver_id", entidad.getReceiver_id().toString()));
	    httpPost.setEntity(new UrlEncodedFormEntity(params));

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
	
	@PostMapping("/v1/messages/fileMessage")
	public ResponseEntity<String> postAdjunto(@RequestHeader("Authorization") String authorization, @ModelAttribute Mensaje entidad) throws ClientProtocolException, IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url + "/api/v1/messages/fileMessage");
		
		httpPost.setHeader("Authorization", authorization);
			    
	    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
	    StringBody message = new StringBody(entidad.getMessage(), ContentType.MULTIPART_FORM_DATA);
	    StringBody receiver_id = new StringBody(entidad.getReceiver_id().toString(), ContentType.MULTIPART_FORM_DATA);
	    builder.addPart("message", message);
	    builder.addPart("receiver_id", receiver_id);
	    for(int i = 0; i < entidad.getFile().length; i++) {
	    	//CREA UN ARCHIVO
	    	MultipartFile multipartFile = entidad.getFile()[i];
	    	String nombre =  multipartFile.getOriginalFilename().split("\\.")[0] + "-" + String.valueOf(System.currentTimeMillis()).substring(6);
	    	String extencion = multipartFile.getOriginalFilename().split("\\.")[multipartFile.getOriginalFilename().split("\\.").length-1];
	    	String directory = DIRECTORY +"/"+ nombre + "." + extencion;
	    	File destination = new File(directory);
	    	multipartFile.transferTo(destination);
	    	
	    	File m = new File(directory);
//	    	FileBody fileBody = new FileBody(m, ContentType.DEFAULT_BINARY);
//	    	builder.addPart("file[" + i + "]", fileBody);	
	    	builder.addBinaryBody("file[" + i + "]", new FileInputStream(m), ContentType.APPLICATION_OCTET_STREAM, m.getName());
	    }
	    HttpEntity entity = builder.build();
	    //
	    httpPost.setEntity(entity);

	    CloseableHttpResponse response = client.execute(httpPost);
	    if(response.getStatusLine().getStatusCode() == 200) {
	    	entity = response.getEntity();
	    	String responseString = EntityUtils.toString(entity, "UTF-8");
	    	client.close();
	    	
	    	return new ResponseEntity<String>(responseString, HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	    }
	}
}
