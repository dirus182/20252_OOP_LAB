package AimsProject;

public class Store {
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
	private int qtyInStore = 0; // Số lượng DVD hiện có trong kho

	// Phương thức thêm DVD vào kho
	public void addDVD(DigitalVideoDisc dvd) {
		if (qtyInStore < 100) {
			itemsInStore[qtyInStore] = dvd;
			qtyInStore++;
			System.out.println("The DVD " + dvd.getTitle() + " has been added to the store.");
		} else {
			System.out.println("The store is almost full!");
		}
	}

	// Phương thức xóa DVD khỏi kho

	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i = 0; i < qtyInStore; i++) {
			if (itemsInStore[i].equals(dvd)) {
				// Dịch chuyển các phần tử phía sau lên để lấp chỗ trống
				for (int j = i; j < qtyInStore - 1; j++) {
					itemsInStore[j] = itemsInStore[j + 1];
				}
				itemsInStore[qtyInStore - 1] = null;
				qtyInStore--;
				System.out.println("The DVD " + dvd.getTitle() + " has been removed from the store.");
				return;
			}
		}
		System.out.println("The DVD was not found in the store.");
	}
}
