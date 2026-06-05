package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

// 2 phần chính 
// 1. Phần trên : menu + header AIMS + nút View Cart
// 2. Phần giữa : danh sách các media trong store
public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart; // thêm field

	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart; // gán cart

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {
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

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		cart.addActionListener(e -> new CartScreen(this.cart));

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));

		ArrayList<Media> mediaInStore = store.getItemsInStore();

		for (int i = 0; i < mediaInStore.size() && i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}

		return center;
	}

	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart(); // tạo cart ở đây
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

		Book book1 = new Book(1, "Effective Java", "Programming", 45.0f);
		book1.addAuthor("Joshua Bloch");

		CompactDisc cd1 = new CompactDisc(2, "Best Songs", "Music", 15.99f, "Some Director", "Some Artist");
		cd1.addTrack(new Track("Song A", 5));
		cd1.addTrack(new Track("Song B", 4));

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(book1);
		store.addMedia(cd1);

		new StoreScreen(store, cart);
	}
}
