package ar.mil.cideso.modelo;

import org.json.JSONObject;

public class Usuario {
	private Long id;
	private String name;
	private String lastname;
	private String dni;
	private String email;
	private String grade;
	private String organization;
	private String password;
	private String token;
	private Boolean isAdmin;
	
	public Usuario() {}
	public Usuario(JSONObject usuario) {
		this.id = usuario.getLong("id");
		this.name = usuario.getString("name");
		this.lastname = usuario.get("surname").toString();
		this.dni = usuario.get("dni").toString();
		this.email = usuario.get("user_name").toString();
		this.grade = usuario.get("grade").toString();
		this.organization = usuario.get("location_id").toString();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	} 

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	} 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	} 

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	} 

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(Boolean admin) {
		this.isAdmin = admin;
	}
}

