package Lab01;

import java.util.Scanner;

public class Exercise63 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap n: ");
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}

			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}
}