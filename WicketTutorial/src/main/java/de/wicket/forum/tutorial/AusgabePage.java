package de.wicket.forum.tutorial;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

public class AusgabePage extends WebPage {

	private static final long serialVersionUID = 1L;
	private Eintrag einEintrag;

	public AusgabePage(Eintrag nachricht) {
		super();
		this.einEintrag = nachricht;
		WicketApplication.eintraege.add(einEintrag);
	}

	public AusgabePage() {
		super();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Link<Void>("homeLink") {
			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
		add(
				new PropertyListView<Eintrag>("eintraege",
						WicketApplication.eintraege) {

					private static final long serialVersionUID = 1L;

					@Override
					public void populateItem(final ListItem<Eintrag> listItem) {
						listItem.add(new Label("benutzerName"));
						listItem.add(new MultiLineLabel("nachricht"));
					}
				}).setVersioned(false);
	}

	public Eintrag getEinEintrag() {
		return einEintrag;
	}

	public void setEinEintrag(Eintrag einEintrag) {
		this.einEintrag = einEintrag;
	}

}
