package hust.soict.dsai.aims.disc;

import hust.soict.dsai.test.disc.DigitalVideoDisc;

class DVDWrapper {
	DigitalVideoDisc dvd; // Đây là thuộc tính (cái ruột của hộp)
	// Đây là Constructor (Hàm khởi tạo)

	DVDWrapper(DigitalVideoDisc dvd) {
		this.dvd = dvd; // Gán giá trị truyền vào cho thuộc tính của lớp
	}
}

public class TestPassingParameter {
	public static void main(String[] args) {
		DVDWrapper w1 = new DVDWrapper(new DigitalVideoDisc("Jungle"));
		DVDWrapper w2 = new DVDWrapper(new DigitalVideoDisc("Cinderella"));

		swap(w1, w2);

		System.out.println("w1 title: " + w1.dvd.getTitle()); // Sẽ ra Cinderella
		System.out.println("w2 title: " + w2.dvd.getTitle()); // Sẽ ra Jungle
	}

	public static void swap(DVDWrapper dw1, DVDWrapper dw2) {
		DigitalVideoDisc temp = dw1.dvd;
		dw1.dvd = dw2.dvd;
		dw2.dvd = temp;
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
