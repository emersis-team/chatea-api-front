package ar.mil.cideso.context;

import ar.mil.cideso.modelo.Location;
import ar.mil.cideso.modelo.Usuario;

public class LocationContext {
	private Location location;
	private Usuario user;

	public Location getLocation() {
		return location;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario u) {
		this.user = u;
	}

	public void setLocation(Location l) {
		this.location = l;
	}
}
