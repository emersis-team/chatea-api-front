package ar.mil.cideso.modelo;

import org.json.JSONObject;

public class Location {
	private Long id;
	private String name;

	public Location() { }
	public Location(JSONObject res) {
		this.id = res.getLong("id");
		this.name = res.getString("name");
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}

