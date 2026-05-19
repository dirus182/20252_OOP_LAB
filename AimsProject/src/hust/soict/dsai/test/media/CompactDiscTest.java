package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

public class CompactDiscTest {
	public static void main(String[] args) {
		CompactDisc cd = new CompactDisc(1, "Best Songs", "Music", 15.99f, "Some Director", "Some Artist");

		Track track1 = new Track("Song A", 5);
		Track track2 = new Track("Song A", 5);
		Track track3 = new Track("Song B", 4);

		cd.addTrack(track1);
		cd.addTrack(track2);
		cd.addTrack(track3);

		System.out.println("CD length: " + cd.getLength());
		cd.play();
	}
}