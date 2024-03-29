package ar.mil.cideso.modelo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
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
	private List<String> contacts = new ArrayList<>();
	private List<String> groups = new ArrayList<>();

	public Usuario() {}
	public Usuario(JSONObject usuario) {
		this.id = usuario.getJSONObject("user").getLong("id");
		this.name = usuario.getJSONObject("user").getString("name");
		this.lastname = usuario.getJSONObject("user").get("surname").toString();
		this.dni = usuario.getJSONObject("user").get("dni").toString();
		this.email = usuario.getJSONObject("user").get("user_name").toString();
		this.grade = usuario.getJSONObject("user").get("grade").toString();
		this.organization = usuario.getJSONObject("user").get("location_id").toString();

		try {
			JSONArray apiContacts = usuario.getJSONArray("contacts");

			for(int i=0;i<apiContacts.length();++i) {
				JSONObject apiContact = apiContacts.getJSONObject(i);
				this.contacts.add(apiContact.get("contact_id").toString());
			}

			JSONArray apiGroups = usuario.getJSONArray("groups");

			for(int i=0;i<apiGroups.length();++i) {
				JSONObject apiGroup = apiGroups.getJSONObject(i);
				this.groups.add(apiGroup.get("group_id").toString());
			}

		} catch(JSONException e) {
			e.printStackTrace();
		}
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

	public List<String> getContacts() {
		return this.contacts;
	}

	public List<String> getGroups() {
		return this.groups;
	}
	
	public void setGroups(List<String> g) {
		this.groups = g;
	}

	public void setContacts(List<String> c) {
		this.contacts = c;
	}
}

