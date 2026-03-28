
import java.util.Arrays;

public class Exercise65 {
	public static void main(String args[]) {
		int[] a = {1789, 2035, 1899, 1456, 2013};
		System.out.println("Mang ban dau: ");
        for (int num : a) {
            System.out.print(num + " ");
        }
        Arrays.sort(a);
        System.out.println("\nMang sau khi sap xep: ");
        for (int num : a) {
            System.out.print(num + " ");
        }
        
        int sum = 0;
        for (int value : a) {
            sum += value;
        }
        System.out.println("\nTong cac phan tu cua mang: " + sum);
        System.out.println("\nTrung binh cong cac phan tu cua mang: " + sum/a.length);
	}
}