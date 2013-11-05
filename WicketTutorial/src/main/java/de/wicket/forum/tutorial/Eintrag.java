package de.wicket.forum.tutorial;

import java.io.Serializable;

public class Eintrag implements Serializable {

	private static final long serialVersionUID = 3260236472431511275L;
	private String nachricht;
	private String benutzerName;

	public String getNachricht() {
		return nachricht;
	}

	public void setNachricht(String nachricht) {
		this.nachricht = nachricht;
	}

	public String getBenutzerName() {
		return benutzerName;
	}

	public void setBenutzerName(String benutzerName) {
		this.benutzerName = benutzerName;
	}

	public Eintrag(String nachricht, String benutzerName) {
		super();
		this.nachricht = nachricht;
		this.benutzerName = benutzerName;
	}

}
