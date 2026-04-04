package Lab01;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class exer65 {
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();

		String strn = JOptionPane.showInputDialog(null, "Input array's number: ", "Input ",
				JOptionPane.INFORMATION_MESSAGE);
		int n = Integer.parseInt(strn);
		int total = 0;
		for (int i = 0; i < n; i++) {
			String strk = JOptionPane.showInputDialog(null, "Input number of index : " + i, "Input ",
					JOptionPane.INFORMATION_MESSAGE);
			int k = Integer.parseInt(strk);
			total += k;
			a1.add(k);
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {// n = 4 - 1 - 2 => n = 1 => j < 1, j + 1 -> j = 1, index 0 1 2 3 3
				int temp1 = a1.get(j);
				int temp2 = a1.get(j + 1);
				if (temp1 > temp2) {
					a1.set(j, temp2);
					a1.set(j + 1, temp1);
				}
			}

		}
		double average = (double) total / n;
		JOptionPane.showMessageDialog(null, a1.toString());
		JOptionPane.showMessageDialog(null, "Total: " + total + "\nAverage: " + average);

	}
}
