package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		// 1. Tạo giỏ hàng mới
		Cart cart = new Cart();

		// 2. Tạo các DVD
		/*
		 * DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
		 * "Roger Allers", 87, 19.95f); dvd1.setId(1); cart.addMedia(dvd1);
		 * 
		 * DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
		 * "George Lucas", 87, 24.95f); dvd2.setId(2); cart.addMedia(dvd2);
		 * 
		 * DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
		 * dvd3.setId(3); cart.addMedia(dvd3);
		 */
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		// 3. Test hàm in
		cart.print();

		/*
		 * // 4. Test hàm tìm kiếm cart.searchById(1); cart.searchByTitle("Star");
		 */
		cart.print();

		cart.searchByTitle("Lion");
	}
}