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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.mil.cideso.modelo.Mensaje;
import ar.mil.cideso.modelo.Posicion;

@Controller
@RequestMapping(value = "/api")
public class PosicionController {

	@Value( "${server.url}" )
	private String url;
	
	@Autowired
  private SimpMessagingTemplate template;
	
	@PostMapping("/position/user_position")
	public ResponseEntity<Mensaje> postPosicion(@Valid @RequestBody Posicion entidad) throws ClientProtocolException, IOException {
		
		if(entidad.getUser_id() != null) {
			try {
				CloseableHttpClient client = HttpClients.createDefault();
				HttpPost httpPost = new HttpPost(url + "/api/position/user_position");
				
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("user_id", entidad.getUser_id().toString()));
				params.add(new BasicNameValuePair("lat", entidad.getLat()));
				params.add(new BasicNameValuePair("lon", entidad.getLon()));
				params.add(new BasicNameValuePair("alt", entidad.getAlt()));
				httpPost.setEntity(new UrlEncodedFormEntity(params));
				
				CloseableHttpResponse response = client.execute(httpPost);
				if(response.getStatusLine().getStatusCode() == 200) {
					HttpEntity entity = response.getEntity();
					String responseString = EntityUtils.toString(entity, "UTF-8");
					client.close();
				}	
				
				client = HttpClients.createDefault();
				HttpGet httpGet = new HttpGet(url + "/api/position/"+ entidad.getUser_id().toString() +"/user_contacts_positions");
			    response = client.execute(httpGet);
			    if(response.getStatusLine().getStatusCode() == 200) {
			    	HttpEntity entity = response.getEntity();
					String responseString = EntityUtils.toString(entity, "UTF-8");
					JSONObject jsonObject = new JSONObject(responseString);
					JSONArray jsonArray = (JSONArray) jsonObject.get("user_contacts_positions");
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject explrObject = jsonArray.getJSONArray(i).getJSONObject(0);
			            this.template.convertAndSend("/notificacion/posicion/" + explrObject.get("user_id"), entidad);
				    }
			    }
			    
				return new ResponseEntity<>(HttpStatus.OK);
			} catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/position/{id}/user_contacts_positions")
	public ResponseEntity<String> getConversaciones(
		@PathVariable(value = "id") Long id
	) throws ClientProtocolException, IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url + "/api/position/"+ id +"/user_contacts_positions");

		CloseableHttpResponse response = client.execute(httpGet);
		if(response.getStatusLine().getStatusCode() == 200) {
			try {
				HttpEntity entity = response.getEntity();
				String responseString = EntityUtils.toString(entity, "UTF-8");
				client.close();
				
				return new ResponseEntity<String>(responseString, HttpStatus.OK);	    		
			} catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<String>(HttpStatus.valueOf(response.getStatusLine().getStatusCode()));
		}
	}
}
