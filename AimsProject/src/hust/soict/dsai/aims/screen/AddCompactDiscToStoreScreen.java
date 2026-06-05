package hust.soict.dsai.aims.screen;

import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField tfId;
	private JTextField tfTitle;
	private JTextField tfCategory;
	private JTextField tfCost;
	private JTextField tfDirector;
	private JTextField tfArtist;

	public AddCompactDiscToStoreScreen(Store store, Cart cart) {
		super(store, cart, "Add CD");
	}

	@Override
	protected void buildForm() {
		tfId = addField("ID");
		tfTitle = addField("Title");
		tfCategory = addField("Category");
		tfCost = addField("Cost");
		tfDirector = addField("Director");
		tfArtist = addField("Artist");
	}

	@Override
	protected void addMediaToStore() {
		try {
			CompactDisc cd = new CompactDisc(Integer.parseInt(tfId.getText()), tfTitle.getText(), tfCategory.getText(),
					Float.parseFloat(tfCost.getText()), tfDirector.getText(), tfArtist.getText());
			store.addMedia(cd);
			dispose();
			new StoreScreen(store, cart);
		} catch (NumberFormatException e) {
			showInputError(e);
		}
	}
}
