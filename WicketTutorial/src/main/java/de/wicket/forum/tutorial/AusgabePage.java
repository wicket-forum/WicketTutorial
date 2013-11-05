package de.wicket.forum.tutorial;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

public class AusgabePage extends WebPage {

	private static final long serialVersionUID = 1L;
	private PropertyModel<String> nachrichtInhalt;

	public AusgabePage(PropertyModel<String> nachricht) {
		super();
		this.nachrichtInhalt = nachricht;

		add(new Label("nachricht", nachrichtInhalt));
	}

	public PropertyModel<String> getNachrichtInhalt() {
		return nachrichtInhalt;
	}

	public void setNachrichtInhalt(PropertyModel<String> nachrichtInhalt) {
		this.nachrichtInhalt = nachrichtInhalt;
	}

}
