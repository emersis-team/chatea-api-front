package ar.mil.cideso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	@GetMapping("/login")
	public String login(){
		return "index";
	}
	@GetMapping("/video")
	public String video(){
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
