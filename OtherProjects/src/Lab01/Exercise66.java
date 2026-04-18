package Lab01;

import java.util.Scanner;

public class Exercise66 {
	public static void main(String args[]) {
		int m, n, c, d;
		Scanner in = new Scanner(System.in);

		System.out.println("Nhap so dong cua hai ma tran");
		m = in.nextInt();
		System.out.println("Nhap so cot cua hai ma tran");
		n = in.nextInt();

		int array1[][] = new int[m][n];
		int array2[][] = new int[m][n];
		int sum[][] = new int[m][n];

		System.out.println("Nhap ma tran thu nhat");

		for (c = 0; c < m; c++)
			for (d = 0; d < n; d++)
				array1[c][d] = in.nextInt();

		System.out.println("Nhap ma tran thu hai");

		for (c = 0; c < m; c++)
			for (d = 0; d < n; d++)
				array2[c][d] = in.nextInt();

		for (c = 0; c < m; c++)
			for (d = 0; d < n; d++)
				sum[c][d] = array1[c][d] + array2[c][d];

		System.out.println("Tong cua hai ma tran:");

		for (c = 0; c < m; c++) {
			for (d = 0; d < n; d++)
				System.out.print(sum[c][d] + "\t");

			System.out.println();
		}
	}
}