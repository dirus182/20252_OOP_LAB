package Lab01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exer64 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input month: ");
		String monthinput = scanner.nextLine();
		String monthoutput = monthinput.toLowerCase().trim().replace(".", "");
		int num = -1;
		// 1. Khởi tạo Map theo kiểu Java 8
		Map<String, Integer> monthMap = new HashMap<>();
		monthMap.put("jan", 1);
		monthMap.put("feb", 2);
		monthMap.put("mar", 3);
		monthMap.put("apr", 4);
		monthMap.put("may", 5);
		monthMap.put("jun", 6);
		monthMap.put("jul", 7);
		monthMap.put("aug", 8);
		monthMap.put("sep", 9);
		monthMap.put("oct", 10);
		monthMap.put("nov", 11);
		monthMap.put("dec", 12);
		if (monthoutput.matches("\\d+")) {
			int tempNum = Integer.parseInt(monthoutput);
			if (tempNum >= 1 && tempNum <= 12) {
				num = tempNum;
			}
		} else {
			/*
			 * num = monthMap.entrySet().stream().filter(entry ->
			 * monthoutput.startsWith(entry.getKey()))
			 * .map(Map.Entry::getValue).findFirst().orElse(-1);
			 */
			for (Map.Entry<String, Integer> entry : monthMap.entrySet()) {
				if (monthoutput.startsWith(entry.getKey())) {
//lay value(tuong duong map)
					num = entry.getValue();
					break;
				}
			}
		}
		if (num == -1) {
			System.out.println("Error");
			return;
		}
		System.out.println("Input year: ");
		int year = scanner.nextInt();
		int days = 0;
		switch (num) {
		// Nhóm 1: Các tháng luôn có 31 ngày
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		// Nhóm 2: Các tháng có 30 ngày (4, 6, 9, 11)
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			// Giả sử bạn đã có biến 'year' từ input người dùng
			// Công thức kiểm tra năm nhuận:
			// Chia hết cho 400 HOẶC (Chia hết cho 4 VÀ không chia hết cho 100)
			if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
				days = 29; // Năm nhuận
			} else {
				days = 28; // Năm thường
			}
			break;

		default:
			days = 0;
			break;
		}
		System.out.println("there are " + days + " of " + num + "th of " + year);
		scanner.close();
	}

}
