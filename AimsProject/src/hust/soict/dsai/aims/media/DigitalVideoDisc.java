package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {

	public DigitalVideoDisc(String title) {
		super(0, title, null, 0.0f, null, 0);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(0, title, category, cost, null, 0);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(0, title, category, cost, director, 0);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(0, title, category, cost, director, length);
	}
}