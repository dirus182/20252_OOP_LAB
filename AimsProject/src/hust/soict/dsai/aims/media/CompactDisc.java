package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc() {
		super();
	}

	public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
		super(id, title, category, cost, director, 0);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("The track has been added.");
		} else {
			System.out.println("The track already exists.");
		}
	}

	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("The track has been removed.");
		} else {
			System.out.println("The track does not exist.");
		}
	}

	@Override
	public int getLength() {
		int totalLength = 0;

		for (Track track : tracks) {
			totalLength += track.getLength();
		}

		return totalLength;
	}

	@Override
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("Cannot play this CD.");
		} else {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());

			for (Track track : tracks) {
				track.play();
			}
		}
	}

	@Override
	public String toString() {
		return "CompactDisc [artist=" + artist + ", tracks=" + tracks + ", getArtist()=" + getArtist()
				+ ", getLength()=" + getLength() + ", getDirector()=" + getDirector() + ", getId()=" + getId()
				+ ", getTitle()=" + getTitle() + ", getCategory()=" + getCategory() + ", getCost()=" + getCost()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}