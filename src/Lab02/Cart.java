package Lab02;

import AimsProject.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered = 0;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
		} else {
			System.out.println("Full storage");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered--;
				found = true;
				System.out.println("Has already removed");
				break;
			}
		}
		if (!found) {
			System.out.println("No found");
		}
	}

	public float totalCost() {
		float total = 0.0f;
		for (int k = 0; k < qtyOrdered; k++) {
			total += itemsOrdered[k].getCost();
		}
		return total;
	}

	public static int getMaxNumbersOrdered() {
		return MAX_NUMBERS_ORDERED;
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}

}
