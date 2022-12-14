package ar.mil.cideso.modelo;

import org.json.JSONObject;

public class Groups {
	public Long id;
	public String name;

	public Groups() { }
	public Groups(JSONObject group) {
		this.id = group.getLong("id");
		this.name = group.getString("name");
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id){
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}

