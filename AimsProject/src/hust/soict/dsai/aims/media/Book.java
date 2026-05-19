package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();

	public Book() {
		super();
	}

	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("The author has been added.");
		} else {
			System.out.println("The author already exists.");
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("The author has been removed.");
		} else {
			System.out.println("The author does not exist.");
		}
	}

	@Override
	public String toString() {
		return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + authors.toString() + " - "
				+ this.getCost() + " $";
	}

}
