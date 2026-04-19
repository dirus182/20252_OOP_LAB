package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.test.disc.DigitalVideoDisc;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");

		// Test thêm vào kho
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);

		// Test xóa khỏi kho
		store.removeDVD(dvd2);
	}
}