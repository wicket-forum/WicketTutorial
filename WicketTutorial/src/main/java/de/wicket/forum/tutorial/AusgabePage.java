package de.wicket.forum.tutorial;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

public class AusgabePage extends WebPage {

	private static final long serialVersionUID = 1L;
	private String nachrichtInhalt;

	public AusgabePage(String nachricht) {
		super();
		this.nachrichtInhalt = nachricht;
		PropertyModel<String> model = new PropertyModel<>(this,
				"nachrichtInhalt");
		add(new Label("nachricht", model));
	}

	public String getNachrichtInhalt() {
		return nachrichtInhalt;
	}

	public void setNachrichtInhalt(String nachrichtInhalt) {
		this.nachrichtInhalt = nachrichtInhalt;
	}

}
