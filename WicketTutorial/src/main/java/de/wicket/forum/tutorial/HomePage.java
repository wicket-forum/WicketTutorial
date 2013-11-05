package de.wicket.forum.tutorial;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 3436333845493815637L;
	private Eintrag eintrag = new Eintrag("nachricht", "benutzer");

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Form<Eintrag> formular = new Form<Eintrag>("formular",
				new CompoundPropertyModel<>(eintrag)) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {

				this.setResponsePage(new AusgabePage(getModelObject()));

			}
		};

		TextField<String> nachrichtFeld = new TextField<>("nachricht");
		TextField<String> benutzerFeld = new TextField<>("benutzerName");
		formular.add(benutzerFeld);
		formular.add(nachrichtFeld);

		add(new Link<Void>("ausgabeLink") {

			@Override
			public void onClick() {
				setResponsePage(AusgabePage.class);

			}
		});

		add(formular);

	}
}
