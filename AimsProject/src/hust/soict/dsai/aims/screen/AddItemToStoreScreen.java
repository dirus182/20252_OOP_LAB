package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	protected Store store;
	protected Cart cart;
	protected JPanel formPanel;

	public AddItemToStoreScreen(Store store, Cart cart, String title) {
		this.store = store;
		this.cart = cart;

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createMenuBar(), BorderLayout.NORTH);

		formPanel = new JPanel(new GridLayout(0, 2, 8, 8));
		buildForm();
		cp.add(formPanel, BorderLayout.CENTER);

		JButton addButton = new JButton("Add to store");
		addButton.addActionListener(e -> addMediaToStore());
		JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		south.add(addButton);
		cp.add(south, BorderLayout.SOUTH);

		setTitle(title);
		setSize(500, 320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	protected JTextField addField(String label) {
		formPanel.add(new JLabel(label));
		JTextField textField = new JTextField();
		formPanel.add(textField);
		return textField;
	}

	protected JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		JMenuItem viewStore = new JMenuItem("View store");
		JMenuItem viewCart = new JMenuItem("View cart");

		addBook.addActionListener(e -> {
			dispose();
			new AddBookToStoreScreen(store, cart);
		});
		addCD.addActionListener(e -> {
			dispose();
			new AddCompactDiscToStoreScreen(store, cart);
		});
		addDVD.addActionListener(e -> {
			dispose();
			new AddDigitalVideoDiscToStoreScreen(store, cart);
		});
		viewStore.addActionListener(e -> {
			dispose();
			new StoreScreen(store, cart);
		});
		viewCart.addActionListener(e -> new CartScreen(cart));

		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore);
		menu.add(viewStore);
		menu.add(viewCart);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}

	protected void showInputError(Exception e) {
		JOptionPane.showMessageDialog(this, e.getMessage(), "Invalid input", JOptionPane.ERROR_MESSAGE);
	}

	protected abstract void buildForm();

	protected abstract void addMediaToStore();
}
