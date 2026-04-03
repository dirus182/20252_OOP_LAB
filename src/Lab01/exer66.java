package Lab01;

import java.util.Scanner;

public class exer66 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhap so hang cua ma tran: ");
		int rows = scanner.nextInt();

		System.out.print("Nhap so cot cua ma tran: ");
		int cols = scanner.nextInt();

		int[][] A = new int[rows][cols];
		int[][] B = new int[rows][cols];
		int[][] C = new int[rows][cols];

		System.out.println("\nNhap ma tran A:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("A[" + i + "][" + j + "] = ");
				A[i][j] = scanner.nextInt();
			}
		}

		System.out.println("\nNhap ma tran B:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("B[" + i + "][" + j + "] = ");
				B[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}

		System.out.println("\nMa tran A:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("\nMa tran B:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(B[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("\nTong hai ma tran C = A + B:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(C[i][j] + "\t");
			}
			System.out.println();
		}

		scanner.close();
	}
}