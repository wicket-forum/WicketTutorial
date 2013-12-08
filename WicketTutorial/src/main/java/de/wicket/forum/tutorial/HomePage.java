package de.wicket.forum.tutorial;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.image.NonCachingImage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.IResource.Attributes;

import de.wicket.forum.tutorial.service.BarcodeService;
import de.wicket.forum.tutorial.service.BarcodeServiceImpl;

public class HomePage extends WebPage {

	private final class MyDynamicImageResource extends DynamicImageResource {
		private final String code;
		
		private static final long serialVersionUID = 7565060347902576989L;

		private MyDynamicImageResource(String nachrichtFeld) {
			this.code = nachrichtFeld;
		}

		@Override
		protected byte[] getImageData(Attributes attributes) {
			return barcodeService.asRawBytes(code);
		}
	}

	private static final long serialVersionUID = 3436333845493815637L;
	private MyBarCode barcode = new MyBarCode("init");
	private BarcodeService barcodeService;

	@Override
	protected void onInitialize() {
		final TextField<String> codeFeld = new TextField<>("code");

		barcodeService = new BarcodeServiceImpl();
		super.onInitialize();
		final Image image = new NonCachingImage("image", new MyDynamicImageResource(
				codeFeld.getInput()));

		Form<MyBarCode> formular = new Form<MyBarCode>("formular",
				new CompoundPropertyModel<>(barcode)) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {

				image.setImageResource(new MyDynamicImageResource(codeFeld
						.getInput()));

			}
			
		};

		add(new Link<Void>("ausgabeLink") {

			
			private static final long serialVersionUID = -4516487621151583616L;

			@Override
			public void onClick() {
				setResponsePage(AusgabePage.class);

			}
		});

		final WebMarkupContainer cont = new WebMarkupContainer("cont");
		add(cont);

		cont.add(image);
		image.setOutputMarkupId(true);

		cont.setOutputMarkupId(true);
		final AjaxButton ajaxButton = new AjaxButton("ajaxButton") {

			
			private static final long serialVersionUID = -403265768963728534L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				image.setImageResource(new MyDynamicImageResource(codeFeld
						.getInput()));
			}

		};
		formular.add(ajaxButton);
		formular.add(codeFeld);

		add(formular);

	}
}
