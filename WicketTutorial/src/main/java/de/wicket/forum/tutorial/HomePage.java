package de.wicket.forum.tutorial;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 3436333845493815637L;
	private String feldInhalt;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		PropertyModel<String> feldModel = new PropertyModel<String>(this,
				"feldInhalt");
		Form formular = new Form("formular") {

			private static final long serialVersionUID = 8919254699133944081L;

			@Override
			protected void onSubmit() {

				this.setResponsePage(new AusgabePage(feldInhalt));

			}
		};
		TextField<String> feld = new TextField<>("feld", feldModel);

		formular.add(feld);

		add(formular);

	}

	public String getFeldInhalt() {
		return feldInhalt;
	}

	public void setFeldInhalt(String feldInhalt) {
		this.feldInhalt = feldInhalt;
	}

}
