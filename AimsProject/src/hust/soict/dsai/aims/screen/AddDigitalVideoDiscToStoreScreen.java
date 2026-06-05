package hust.soict.dsai.aims.screen;

import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField tfTitle;
	private JTextField tfCategory;
	private JTextField tfDirector;
	private JTextField tfLength;
	private JTextField tfCost;

	public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
		super(store, cart, "Add DVD");
	}

	@Override
	protected void buildForm() {
		tfTitle = addField("Title");
		tfCategory = addField("Category");
		tfDirector = addField("Director");
		tfLength = addField("Length");
		tfCost = addField("Cost");
	}

	@Override
	protected void addMediaToStore() {
		try {
			DigitalVideoDisc dvd = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(),
					Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText()));
			store.addMedia(dvd);
			dispose();
			new StoreScreen(store, cart);
		} catch (NumberFormatException e) {
			showInputError(e);
		}
	}
}
