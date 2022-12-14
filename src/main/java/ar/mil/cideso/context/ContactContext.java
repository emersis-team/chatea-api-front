package ar.mil.cideso.context;

import java.util.List;

public class ContactContext {
	private List<String> contacts;
	private List<String> groups;

	public String getContacts() {
		return this.contacts.toString();
	}

	public String getGroups() {
		return this.groups.toString();
	}

	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}
}
