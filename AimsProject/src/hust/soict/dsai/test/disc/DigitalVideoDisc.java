package hust.soict.dsai.test.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	// --- PHẦN MỚI THÊM ---
	// Thành viên lớp (Class Member): Cả lớp dùng chung 1 biến này
	private static int nbDigitalVideoDiscs = 0;
	// Thành viên thể hiện (Instance Member): Mỗi đối tượng có 1 ID riêng
	private int id;

	public DigitalVideoDisc() {

	}

	public DigitalVideoDisc(String title) {
		this.title = title;
		// Tăng biến tổng của lớp lên 1
		nbDigitalVideoDiscs++;
		// Gán giá trị hiện tại của biến tổng cho id của đối tượng này
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String category, String title, float cost) {
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String director, String category, String title, float cost) {
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public float getCost() {
		return cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
