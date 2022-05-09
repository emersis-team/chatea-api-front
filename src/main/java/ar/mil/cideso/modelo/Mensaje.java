package ar.mil.cideso.modelo;

import org.springframework.web.multipart.MultipartFile;

public class Mensaje {
	private String message;
	private Long receiver_id;
	private MultipartFile[] file;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(Long receiver_id) {
		this.receiver_id = receiver_id;
	}
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
}
