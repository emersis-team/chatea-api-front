package ar.mil.cideso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ar.mil.cideso.controller.MessageController;
import ar.mil.cideso.modelo.Message;

@Controller
public class PagesController {
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	@GetMapping("/javi")
	public String javi() throws Exception{
   	 MessageController asd = new MessageController();
    	Message message = new Message();
    	message.setFrom("javi");
    	message.setText("sadasd");
    	asd.send(message);
    	return "index";
	}
	@GetMapping("/login")
	public String login(){
		return "index";
	}
	@GetMapping("/chat/{id}/{dest}")
	public String chat(){
		return "index";
	}
	@GetMapping("/token/{token}")
	public String token(){
		return "index";
	}
}
