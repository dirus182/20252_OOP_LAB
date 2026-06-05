package hust.soict.dsai.aims.screen;

import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private JTextField tfId;
	private JTextField tfTitle;
	private JTextField tfCategory;
	private JTextField tfCost;
	private JTextField tfAuthor;

	public AddBookToStoreScreen(Store store, Cart cart) {
		super(store, cart, "Add Book");
	}

	@Override
	protected void buildForm() {
		tfId = addField("ID");
		tfTitle = addField("Title");
		tfCategory = addField("Category");
		tfCost = addField("Cost");
		tfAuthor = addField("Author");
	}

	@Override
	protected void addMediaToStore() {
		try {
			Book book = new Book(Integer.parseInt(tfId.getText()), tfTitle.getText(), tfCategory.getText(),
					Float.parseFloat(tfCost.getText()));
			if (tfAuthor.getText().trim().length() > 0) {
				book.addAuthor(tfAuthor.getText());
			}
			store.addMedia(book);
			dispose();
			new StoreScreen(store, cart);
		} catch (NumberFormatException e) {
			showInputError(e);
		}
	}
}
