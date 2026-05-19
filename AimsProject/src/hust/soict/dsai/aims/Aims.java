package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();

		initStore(store);

		int choice;
		do {
			showMenu();
			choice = readInt();

			switch (choice) {
			case 1:
				handleViewStore(store, cart);
				break;
			case 2:
				handleUpdateStore(store);
				break;
			case 3:
				handleCurrentCart(cart);
				break;
			case 0:
				System.out.println("Exit AIMS.");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 0);
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	private static void initStore(Store store) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		dvd1.setId(1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		dvd2.setId(2);

		Book book = new Book(3, "Effective Java", "Programming", 45.0f);
		book.addAuthor("Joshua Bloch");

		CompactDisc cd = new CompactDisc(4, "Best Songs", "Music", 15.99f, "Some Director", "Some Artist");
		cd.addTrack(new Track("Song A", 5));
		cd.addTrack(new Track("Song B", 4));

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(book);
		store.addMedia(cd);
	}

	private static void handleViewStore(Store store, Cart cart) {
		int choice;

		do {
			store.print();
			storeMenu();
			choice = readInt();

			switch (choice) {
			case 1:
				Media media = inputMediaFromStore(store);
				if (media != null) {
					System.out.println(media.toString());
					handleMediaDetails(media, cart);
				}
				break;
			case 2:
				Media mediaToAdd = inputMediaFromStore(store);
				if (mediaToAdd != null) {
					cart.addMedia(mediaToAdd);
				}
				break;
			case 3:
				Media mediaToPlay = inputMediaFromStore(store);
				if (mediaToPlay != null) {
					playMedia(mediaToPlay);
				}
				break;
			case 4:
				handleCurrentCart(cart);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 0);
	}

	private static void handleMediaDetails(Media media, Cart cart) {
		int choice;

		do {
			mediaDetailsMenu();
			choice = readInt();

			switch (choice) {
			case 1:
				cart.addMedia(media);
				break;
			case 2:
				playMedia(media);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 0);
	}

	private static void handleUpdateStore(Store store) {
		System.out.println("Update Store:");
		System.out.println("1. Add DVD");
		System.out.println("2. Add Book");
		System.out.println("3. Add CD");
		System.out.println("4. Remove media");
		System.out.println("0. Back");

		int choice = readInt();

		switch (choice) {
		case 1:
			addDVDToStore(store);
			break;
		case 2:
			addBookToStore(store);
			break;
		case 3:
			addCDToStore(store);
			break;
		case 4:
			Media media = inputMediaFromStore(store);
			if (media != null) {
				store.removeMedia(media);
			}
			break;
		case 0:
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}

	private static void handleCurrentCart(Cart cart) {
		int choice;

		do {
			cart.print();
			cartMenu();
			choice = readInt();

			switch (choice) {
			case 1:
				filterCart(cart);
				break;
			case 2:
				sortCart(cart);
				break;
			case 3:
				Media mediaToRemove = inputMediaFromCart(cart);
				if (mediaToRemove != null) {
					cart.removeMedia(mediaToRemove);
				}
				break;
			case 4:
				Media mediaToPlay = inputMediaFromCart(cart);
				if (mediaToPlay != null) {
					playMedia(mediaToPlay);
				}
				break;
			case 5:
				System.out.println("An order has been created.");
				cart.clearCart();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 0);
	}

	private static void filterCart(Cart cart) {
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		int choice = readInt();

		if (choice == 1) {
			System.out.print("Enter id: ");
			int id = readInt();
			cart.searchById(id);
		} else if (choice == 2) {
			System.out.print("Enter title: ");
			String title = scanner.nextLine();
			cart.searchByTitle(title);
		} else {
			System.out.println("Invalid choice.");
		}
	}

	private static void sortCart(Cart cart) {
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		int choice = readInt();

		if (choice == 1) {
			cart.sortByTitleCost();
			cart.print();
		} else if (choice == 2) {
			cart.sortByCostTitle();
			cart.print();
		} else {
			System.out.println("Invalid choice.");
		}
	}

	private static void addDVDToStore(Store store) {
		System.out.print("Enter id: ");
		int id = readInt();

		System.out.print("Enter title: ");
		String title = scanner.nextLine();

		System.out.print("Enter category: ");
		String category = scanner.nextLine();

		System.out.print("Enter director: ");
		String director = scanner.nextLine();

		System.out.print("Enter length: ");
		int length = readInt();

		System.out.print("Enter cost: ");
		float cost = readFloat();

		DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
		dvd.setId(id);
		store.addMedia(dvd);
	}

	private static void addBookToStore(Store store) {
		System.out.print("Enter id: ");
		int id = readInt();

		System.out.print("Enter title: ");
		String title = scanner.nextLine();

		System.out.print("Enter category: ");
		String category = scanner.nextLine();

		System.out.print("Enter cost: ");
		float cost = readFloat();

		Book book = new Book(id, title, category, cost);

		System.out.print("Enter author: ");
		String author = scanner.nextLine();
		book.addAuthor(author);

		store.addMedia(book);
	}

	private static void addCDToStore(Store store) {
		System.out.print("Enter id: ");
		int id = readInt();

		System.out.print("Enter title: ");
		String title = scanner.nextLine();

		System.out.print("Enter category: ");
		String category = scanner.nextLine();

		System.out.print("Enter cost: ");
		float cost = readFloat();

		System.out.print("Enter director: ");
		String director = scanner.nextLine();

		System.out.print("Enter artist: ");
		String artist = scanner.nextLine();

		CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);

		System.out.print("Enter number of tracks: ");
		int numberOfTracks = readInt();

		for (int i = 0; i < numberOfTracks; i++) {
			System.out.print("Enter track title: ");
			String trackTitle = scanner.nextLine();

			System.out.print("Enter track length: ");
			int trackLength = readInt();

			cd.addTrack(new Track(trackTitle, trackLength));
		}

		store.addMedia(cd);
	}

	private static Media inputMediaFromStore(Store store) {
		System.out.print("Enter media title: ");
		String title = scanner.nextLine();

		Media media = findMediaByTitleInStore(store, title);

		if (media == null) {
			System.out.println("Media not found in store.");
		}

		return media;
	}

	private static Media inputMediaFromCart(Cart cart) {
		System.out.print("Enter media title: ");
		String title = scanner.nextLine();

		Media media = findMediaByTitleInCart(cart, title);

		if (media == null) {
			System.out.println("Media not found in cart.");
		}

		return media;
	}

	private static Media findMediaByTitleInStore(Store store, String title) {
		for (Media media : store.getItemsInStore()) {
			if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title)) {
				return media;
			}
		}
		return null;
	}

	private static Media findMediaByTitleInCart(Cart cart, String title) {
		for (Media media : cart.getItemsOrdered()) {
			if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title)) {
				return media;
			}
		}
		return null;
	}

	private static void playMedia(Media media) {
		if (media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("This media cannot be played.");
		}
	}

	private static int readInt() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.print("Please enter an integer: ");
			}
		}
	}

	private static float readFloat() {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.print("Please enter a number: ");
			}
		}
	}
}