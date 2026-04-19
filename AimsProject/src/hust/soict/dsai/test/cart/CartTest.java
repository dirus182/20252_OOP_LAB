package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.test.disc.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		// 1. Tạo giỏ hàng mới
		Cart cart = new Cart();

		// 2. Tạo các DVD và thêm vào giỏ
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);

		// 3. Test hàm in
		cart.print();

		// 4. Test hàm tìm kiếm
		cart.searchById(1); // Nên tìm thấy Lion King
		cart.searchByTitle("Star"); // Nên tìm thấy Star Wars
	}
}