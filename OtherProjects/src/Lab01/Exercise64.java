package Lab01;

import javax.swing.JOptionPane;

public class Exercise64 {
	public static void main(String args[]) {
		System.out.println("Hello world");
		String strMonth, strYear;
		strMonth = JOptionPane.showInputDialog(null, "Please input the month: ", "Input the month",
				JOptionPane.INFORMATION_MESSAGE);
		int flag;

		if (strMonth.compareTo("1") == 0 || strMonth.compareTo("Jan") == 0 || strMonth.compareTo("Jan.") == 0
				|| strMonth.compareTo("January") == 0) {
			flag = 1;
		} else if (strMonth.compareTo("2") == 0 || strMonth.compareTo("Feb") == 0 || strMonth.compareTo("Feb.") == 0
				|| strMonth.compareTo("Feburary") == 0) {
			flag = 2;
		} else if (strMonth.compareTo("3") == 0 || strMonth.compareTo("Mar") == 0 || strMonth.compareTo("Mar.") == 0
				|| strMonth.compareTo("March") == 0) {
			flag = 3;
		} else if (strMonth.compareTo("4") == 0 || strMonth.compareTo("Apr") == 0 || strMonth.compareTo("Apr.") == 0
				|| strMonth.compareTo("April") == 0) {
			flag = 4;
		} else if (strMonth.compareTo("5") == 0 || strMonth.compareTo("May") == 0 || strMonth.compareTo("May.") == 0
				|| strMonth.compareTo("May") == 0) {
			flag = 5;
		} else if (strMonth.compareTo("6") == 0 || strMonth.compareTo("Jun") == 0 || strMonth.compareTo("Jun.") == 0
				|| strMonth.compareTo("June") == 0) {
			flag = 6;
		} else if (strMonth.compareTo("7") == 0 || strMonth.compareTo("Jul") == 0 || strMonth.compareTo("Jul.") == 0
				|| strMonth.compareTo("July") == 0) {
			flag = 7;
		} else if (strMonth.compareTo("8") == 0 || strMonth.compareTo("Aug") == 0 || strMonth.compareTo("Aug.") == 0
				|| strMonth.compareTo("August") == 0) {
			flag = 8;
		} else if (strMonth.compareTo("9") == 0 || strMonth.compareTo("Sep") == 0 || strMonth.compareTo("Sep.") == 0
				|| strMonth.compareTo("September") == 0) {
			flag = 9;
		} else if (strMonth.compareTo("10") == 0 || strMonth.compareTo("Oct") == 0 || strMonth.compareTo("Oct.") == 0
				|| strMonth.compareTo("October") == 0) {
			flag = 10;
		} else if (strMonth.compareTo("11") == 0 || strMonth.compareTo("Nov") == 0 || strMonth.compareTo("Nov.") == 0
				|| strMonth.compareTo("November") == 0) {
			flag = 11;
		} else if (strMonth.compareTo("12") == 0 || strMonth.compareTo("Dec") == 0 || strMonth.compareTo("Dec.") == 0
				|| strMonth.compareTo("December") == 0) {
			flag = 12;
		} else {
			flag = 0;
		}

		while (flag == 0) {
			JOptionPane.showMessageDialog(null, "Invalid month input. Please input again." + " Value: " + strMonth);
			strMonth = JOptionPane.showInputDialog(null, "Please input the month: ", "Input the month",
					JOptionPane.INFORMATION_MESSAGE);
			if (strMonth.compareTo("1") == 0 || strMonth.compareTo("Jan") == 0 || strMonth.compareTo("Jan.") == 0
					|| strMonth.compareTo("January") == 0) {
				flag = 1;
			} else if (strMonth.compareTo("2") == 0 || strMonth.compareTo("Feb") == 0 || strMonth.compareTo("Feb.") == 0
					|| strMonth.compareTo("Feburary") == 0) {
				flag = 2;
			} else if (strMonth.compareTo("3") == 0 || strMonth.compareTo("Mar") == 0 || strMonth.compareTo("Mar.") == 0
					|| strMonth.compareTo("March") == 0) {
				flag = 3;
			} else if (strMonth.compareTo("4") == 0 || strMonth.compareTo("Apr") == 0 || strMonth.compareTo("Apr.") == 0
					|| strMonth.compareTo("April") == 0) {
				flag = 4;
			} else if (strMonth.compareTo("5") == 0 || strMonth.compareTo("May") == 0 || strMonth.compareTo("May.") == 0
					|| strMonth.compareTo("May") == 0) {
				flag = 5;
			} else if (strMonth.compareTo("6") == 0 || strMonth.compareTo("Jun") == 0 || strMonth.compareTo("Jun.") == 0
					|| strMonth.compareTo("June") == 0) {
				flag = 6;
			} else if (strMonth.compareTo("7") == 0 || strMonth.compareTo("Jul") == 0 || strMonth.compareTo("Jul.") == 0
					|| strMonth.compareTo("July") == 0) {
				flag = 7;
			} else if (strMonth.compareTo("8") == 0 || strMonth.compareTo("Aug") == 0 || strMonth.compareTo("Aug.") == 0
					|| strMonth.compareTo("August") == 0) {
				flag = 8;
			} else if (strMonth.compareTo("9") == 0 || strMonth.compareTo("Sep") == 0 || strMonth.compareTo("Sep.") == 0
					|| strMonth.compareTo("September") == 0) {
				flag = 9;
			} else if (strMonth.compareTo("10") == 0 || strMonth.compareTo("Oct") == 0
					|| strMonth.compareTo("Oct.") == 0 || strMonth.compareTo("October") == 0) {
				flag = 10;
			} else if (strMonth.compareTo("11") == 0 || strMonth.compareTo("Nov") == 0
					|| strMonth.compareTo("Nov.") == 0 || strMonth.compareTo("November") == 0) {
				flag = 11;
			} else if (strMonth.compareTo("12") == 0 || strMonth.compareTo("Dec") == 0
					|| strMonth.compareTo("Dec.") == 0 || strMonth.compareTo("December") == 0) {
				flag = 12;
			} else {
				flag = 0;
			}
		}

		strYear = JOptionPane.showInputDialog(null, "Please input the year: ", "Input the year",
				JOptionPane.INFORMATION_MESSAGE);
		int year = Integer.parseInt(strYear);

		switch (flag) {
		case 1:
			System.out.println("31 days");
			break;
		case 2:
			if (year % 4 == 0) {
				System.out.println("28 days");
			} else {
				System.out.println("29 days");
			}
			break;
		case 3:
			System.out.println("31 days");
			break;
		case 4:
			System.out.println("30 days");
			break;
		case 5:
			System.out.println("31 days");
			break;
		case 6:
			System.out.println("30 days");
			break;
		case 7:
			System.out.println("31 days");
			break;
		case 8:
			System.out.println("31 days");
			break;
		case 9:
			System.out.println("30 days");
			break;
		case 10:
			System.out.println("31 days");
			break;
		case 11:
			System.out.println("30 days");
			break;
		case 12:
			System.out.println("31 days");
			break;
		default:
			System.out.println("Failed" + strMonth);
		}
	}
}