package AimsProject;

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


	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("The disc" + disc.getTitle() + "has been added");
			} else {
				System.out.print("The cart is almost full. cannot add : " + disc.getTitle());

	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		// Duyệt qua mảng itemsOrdered (giả sử qtyOrdered là số lượng hiện tại)
		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc dvd = itemsOrdered[i];
			System.out.println((i + 1) + ".DVD - " + dvd.getTitle() + " - " + dvd.getCategory() + " - "
					+ dvd.getDirector() + " - " + dvd.getLength() + ": " + dvd.getCost() + " $");
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}

	public void searchById(int id) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.print("Found : " + itemsOrdered[i].toString());
				found = true;
				break;
			}
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		// Tận dụng lại phương thức đã viết để tránh lặp code
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);

	public void searchByTitle(String title) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			// So sánh title (bỏ qua hoa thường)
			if (itemsOrdered[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
				System.out.println("Found : " + itemsOrdered[i].toString());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No DVD found with title: " + title);
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
