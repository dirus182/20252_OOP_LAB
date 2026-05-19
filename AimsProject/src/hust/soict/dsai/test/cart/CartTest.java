package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		Book book1 = new Book(1, "Aladdin", "Book", 25.0f);

		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(book1);

		System.out.println("Before sorting:");
		cart.print();

		System.out.println("Sort by title then cost:");
		cart.sortByTitleCost();
		cart.print();

		System.out.println("Sort by cost then title:");
		cart.sortByCostTitle();
		cart.print();
	}
}