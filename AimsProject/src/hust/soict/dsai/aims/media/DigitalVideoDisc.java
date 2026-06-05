package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

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

	@Override
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			String message = "ERROR: DVD length is non-positive!";
			System.err.println(message);
			throw new PlayerException(message);
		}

		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	@Override
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - "
				+ this.getLength() + " - " + this.getCost() + " $";
	}

}
