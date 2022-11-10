package ar.mil.cideso.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.multipart.MultipartFile;

import ar.mil.cideso.Utils.UtilsHttp;
import ar.mil.cideso.modelo.Mensaje;

@Controller
public class ChatController {

	@Value( "${server.url}" )
	private String url;
	
	@Autowired
  private SimpMessagingTemplate template;
	
	private static final String DIRECTORY = "/home/usuario/files";
	//private static final String DIRECTORY = "E:/Trabajo/CIDESO/chat ea/Files";

	@PostMapping("/messages/textMessage")
	public ResponseEntity<Mensaje> postChat(
		@Valid @RequestBody Mensaje entidad,
		@RequestHeader Map<String, String> headers
	) throws ClientProtocolException, IOException {
		try {
			String token = headers.get("Authentication");

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("user_id", entidad.getUser_id().toString()));
			params.add(new BasicNameValuePair("message", entidad.getMessage()));
			params.add(new BasicNameValuePair("conversation_id", entidad.getConversation_id().toString()));

			entidad.getConversation_members().forEach(m -> 
				this.template.convertAndSend("/notificacion/mensaje/" + m.getUser_id(), entidad)
			);
			UtilsHttp request = new UtilsHttp();
			request.setToken(token);
			request.runPost(url + "/api/textMessage", new UrlEncodedFormEntity(params));

			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/messages/fileMessage")
	public ResponseEntity<String> postAdjunto(
		@ModelAttribute Mensaje entidad,
		@RequestHeader Map<String, String> headers
	) throws ClientProtocolException, IOException {
		try {

			String token = headers.get("Authentication");
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

			StringBody message = new StringBody(entidad.getMessage(), ContentType.MULTIPART_FORM_DATA);
			StringBody conversation_id = new StringBody(entidad.getConversation_id().toString(), ContentType.MULTIPART_FORM_DATA);
			StringBody user_id = new StringBody(entidad.getUser_id().toString(), ContentType.MULTIPART_FORM_DATA);

			builder.addPart("message", message);
			builder.addPart("user_id", user_id);
			builder.addPart("conversation_id", conversation_id);

			for(int i = 0; i < entidad.getFile().length; ++i) {
				MultipartFile newFile = entidad.getFile()[i];

				String[] filenameSplit = newFile.getOriginalFilename().split("\\.");

				String nombre = filenameSplit[0] + "-" + String.valueOf(System.currentTimeMillis()).substring(6);
				String extencion = filenameSplit[filenameSplit.length-1];

				String directory = DIRECTORY +"/"+ nombre + "." + extencion;
				File newLocation = new File(directory);
				File m = new File(directory);

				newFile.transferTo(newLocation);
				builder.addBinaryBody("file[" + i + "]", new FileInputStream(m), ContentType.APPLICATION_OCTET_STREAM, m.getName());
			}

			HttpEntity entity = builder.build();

			UtilsHttp request = new UtilsHttp();
			request.setToken(token);
			request.runPost(url + "/api/fileMessage", entity);
			String responseString = request.getString();

			entidad.getConversation_members().forEach(m -> 
				this.template.convertAndSend("/notificacion/mensaje/" + m.getUser_id(), entidad)
			);

			return new ResponseEntity<String>(responseString, HttpStatus.OK);
		} catch(IOException e){
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}
	}
}

