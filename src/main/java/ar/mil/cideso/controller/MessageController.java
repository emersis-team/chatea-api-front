package ar.mil.cideso.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import ar.mil.cideso.modelo.Message;
import ar.mil.cideso.modelo.OutputMessage;

@Controller
public class MessageController {
	
	@Autowired
    private SimpMessagingTemplate template;

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(Message message) throws Exception {
		System.out.println("javi");
	    String time = new SimpleDateFormat("HH:mm").format(new Date());
	    this.send("hola");
	    return new OutputMessage(message.getFrom(), message.getText(), time);
	}
	
	public void send(String text) throws Exception {
		this.template.convertAndSend("/topic/messages2", text);
	}
}
