package de.wicket.forum.tutorial;

import java.util.ArrayList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import de.wicket.forum.tutorial.service.QRResource;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see de.wicket.forum.tutorial.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	public static ArrayList<Eintrag> eintraege = new ArrayList<>();

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		mountResource("/WicketTutorial/qr/${code}", QRResource.asReference());
	}
}
