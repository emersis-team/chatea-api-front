package ar.mil.cideso.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Mensaje {
	private Long user_id;
	private String message;
	private Long conversation_id;
	private List<Member> conversation_members = new ArrayList<Member>();
	private MultipartFile[] file;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getConversation_id() {
		return conversation_id;
	}
	public void setConversation_id(Long conversation_id) {
		this.conversation_id = conversation_id;
	}
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
	public List<Member> getConversation_members() {
		return conversation_members;
	}
	public void setConversation_members(List<Member> conversation_members) {
		this.conversation_members = conversation_members;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
}
