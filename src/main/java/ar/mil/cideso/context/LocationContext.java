package ar.mil.cideso.context;

import ar.mil.cideso.modelo.Location;
import ar.mil.cideso.modelo.Usuario;

public class LocationContext {
	private Location l;
	private Usuario u;

	public Location getLocation() {
		return l;
	}

	public Usuario getUsuario() {
		return u;
	}

	public void setUsuario(Usuario u) {
		this.u = u;
	}

	public void setLocation(Location l) {
		this.l = l;
	}
}
