package Lab01;

import javax.swing.JOptionPane;

public class exer226 {
	public static void main(String[] args) {

		String notification = JOptionPane.showInputDialog(null,
				"ban muon giai phuong trinh nao \n 1. bac nhat 1  an \n 2.bac nhat 2 an \n 3.phuong trinh bac 2 ",
				"chon so 1 hoac 2 hoac 3", JOptionPane.INFORMATION_MESSAGE);
		int firstnum = Integer.parseInt(notification);
		switch (firstnum) {
		case (1):
			String strnum1, strnum2;
			strnum1 = JOptionPane.showInputDialog(null, "ax voi a la = ", "nhap a", JOptionPane.INFORMATION_MESSAGE);
			strnum2 = JOptionPane.showInputDialog(null, "b  = ", "nhap b", JOptionPane.INFORMATION_MESSAGE);
			Double num1 = Double.parseDouble(strnum1);
			Double num2 = Double.parseDouble(strnum2);

			if (num1 != 0) {
				JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem duy nhat");
			} else if (num1 == 0 && num2 == 0) {
				JOptionPane.showMessageDialog(null, "Phuong Trinh Vo so Nghiem");
			} else
				JOptionPane.showMessageDialog(null, "Phuong Trinh Vo Nghiem");
			break;
		case (2):
			String strnum11, strnum12, strnum111, strnum21, strnum22, strnum222;
			strnum11 = JOptionPane.showInputDialog(null, "a1x voi a1 la = ", "nhap a1",
					JOptionPane.INFORMATION_MESSAGE);
			strnum12 = JOptionPane.showInputDialog(null, "a2x voi a2 la   = ", "nhap a2",
					JOptionPane.INFORMATION_MESSAGE);
			strnum111 = JOptionPane.showInputDialog(null, "a3 la = ", "nhap a3", JOptionPane.INFORMATION_MESSAGE);
			strnum21 = JOptionPane.showInputDialog(null, "b1x voi b1 la = ", "nhap b1",
					JOptionPane.INFORMATION_MESSAGE);
			strnum22 = JOptionPane.showInputDialog(null, "b2x voi b2 la = ", "nhap b2",
					JOptionPane.INFORMATION_MESSAGE);
			strnum222 = JOptionPane.showInputDialog(null, "b3   = ", "nhap b3", JOptionPane.INFORMATION_MESSAGE);
			double a1 = Double.parseDouble(strnum11);
			double a2 = Double.parseDouble(strnum12);
			double a3 = Double.parseDouble(strnum111);
			double b1 = Double.parseDouble(strnum21);
			double b2 = Double.parseDouble(strnum22);
			double b3 = Double.parseDouble(strnum222);
			double D = a1 * b2 - a2 * b1;
			double D1 = a3 * b2 - a2 * b3;
			double D2 = a1 * b3 - a3 * b1;
			if (D != 0) {
				String notif = "He co nghiem la : " + D1 / D + " va " + D2 / D;
				JOptionPane.showMessageDialog(null, notif, "He co 2 nghiem", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (D1 == 0 && D2 == 0) {
					JOptionPane.showMessageDialog(null, "He vo so nghiem");
				} else {
					JOptionPane.showMessageDialog(null, "He vo nghiem");
				}
			}
			break;
		case (3):
			String strnuma, strnumb, strnumc;
			strnuma = JOptionPane.showInputDialog(null, "ax^2 voi a la = ", "nhap a", JOptionPane.INFORMATION_MESSAGE);
			double numa = Double.parseDouble(strnuma);
			if (numa == 0) {
				strnumb = JOptionPane.showInputDialog(null, "bx voi b la = ", "nhap b",
						JOptionPane.INFORMATION_MESSAGE);
				strnumc = JOptionPane.showInputDialog(null, "c  = ", "nhap c", JOptionPane.INFORMATION_MESSAGE);
				Double numb = Double.parseDouble(strnumb);
				Double numc = Double.parseDouble(strnumc);
				if (numb != 0) {
					JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem duy nhat");
				} else if (numb == 0 && numc == 0) {
					JOptionPane.showMessageDialog(null, "Phuong Trinh Vo so Nghiem");
				} else
					JOptionPane.showMessageDialog(null, "Phuong Trinh Vo  Nghiem");
				break;
			}
			strnumb = JOptionPane.showInputDialog(null, "bx voi b la = ", "nhap b", JOptionPane.INFORMATION_MESSAGE);
			strnumc = JOptionPane.showInputDialog(null, "c  = ", "nhap c", JOptionPane.INFORMATION_MESSAGE);
			Double numb = Double.parseDouble(strnumb);
			Double numc = Double.parseDouble(strnumc);
			double delta = numb * numb - 4 * numa * numc;
			if (delta > 0) {
				JOptionPane.showMessageDialog(null, "pt bac 2 co 2 nghiem phan biet");
			} else if (delta == 0) {
				JOptionPane.showMessageDialog(null, "pt bac 2 co 1 nghiem kep");
			} else
				JOptionPane.showMessageDialog(null, "pt bac 2 vo nghiem");
			break;
		}
	}
}
