import javax.swing.JOptionPane;
import java.lang.Math;

public class Exercise225 {
	public static void main(String args[]) {
		String strNum1, strNum2;
		
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		double sumResult = num1 + num2;
		System.out.println("Sum of two entered number: " + sumResult );
		
		double diffResult = Math.abs(num1 - num2);
		System.out.println("Difference of two entered number: " + diffResult );
		
		double proResult = num1 * num2;
		System.out.println("Product of two entered number: " + proResult );
		
		if (num2 == 0) {
			System.out.println("The second number must not be zero!");
		} else {
			double divideResult = num1 / num2;
			System.out.println("Devide of two entered number: " + divideResult );
		}
	}
}