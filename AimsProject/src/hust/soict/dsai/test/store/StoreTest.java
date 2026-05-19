package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");

		// Test thêm vào kho
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);

		// In store để kiểm tra
		store.print();

		// Test xóa khỏi kho
		store.removeMedia(dvd2);

		// In lại sau khi xóa
		store.print();
	}
}