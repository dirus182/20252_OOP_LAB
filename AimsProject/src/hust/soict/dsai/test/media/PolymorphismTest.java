package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class PolymorphismTest {
	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();

		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

		Book book = new Book(1, "Effective Java", "Programming", 45.0f);
		book.addAuthor("Joshua Bloch");

		CompactDisc cd = new CompactDisc(2, "Best Songs", "Music", 15.99f, "Some Director", "Some Artist");
		cd.addTrack(new Track("Song A", 5));
		cd.addTrack(new Track("Song B", 4));

		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);

		for (Media m : mediae) {
			System.out.println(m.toString());
			System.out.println("--------------------------------");
		}
	}
}