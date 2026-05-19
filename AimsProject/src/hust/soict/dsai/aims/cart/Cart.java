package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public void addMedia(Media media) {
		if (!itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
			System.out.println("The media has been added.");
		} else {
			System.out.println("The media already exists in the cart.");
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The media has been removed.");
		} else {
			System.out.println("The media does not exist in the cart.");
		}
	}

	public float totalCost() {
		float total = 0.0f;

		for (Media media : itemsOrdered) {
			total += media.getCost();
		}

		return total;
	}

	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");

		for (int i = 0; i < itemsOrdered.size(); i++) {
			Media media = itemsOrdered.get(i);
			System.out.println((i + 1) + ". " + media.toString());
		}

		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}

	public void searchById(int id) {
		boolean found = false;

		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Found: " + media.toString());
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("No media found with id: " + id);
		}
	}

	public void searchByTitle(String title) {
		boolean found = false;

		for (Media media : itemsOrdered) {
			if (media.getTitle() != null && media.getTitle().toLowerCase().contains(title.toLowerCase())) {
				System.out.println("Found: " + media.toString());
				found = true;
			}
		}

		if (!found) {
			System.out.println("No media found with title: " + title);
		}
	}

	public int getQtyOrdered() {
		return itemsOrdered.size();
	}

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public void clearCart() {
		itemsOrdered.clear();
	}
}