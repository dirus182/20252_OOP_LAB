package hust.soict.dsai.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGrid extends JFrame {
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnDelete;
	private JButton btnReset;
	private JTextField tfDisplay;

	public NumberGrid() {
		tfDisplay = new JTextField();
		tfDisplay.setEditable(false);

		JPanel panelButtons = new JPanel(new GridLayout(4, 3));
		addButtons(panelButtons);

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);

		setTitle("Number Grid");
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void addButtons(JPanel panelButtons) {
		ButtonListener listener = new ButtonListener();

		for (int i = 1; i <= 9; i++) {
			btnNumbers[i] = new JButton(String.valueOf(i));
			btnNumbers[i].addActionListener(listener);
			panelButtons.add(btnNumbers[i]);
		}

		btnDelete = new JButton("DEL");
		btnDelete.addActionListener(listener);
		panelButtons.add(btnDelete);

		btnNumbers[0] = new JButton("0");
		btnNumbers[0].addActionListener(listener);
		panelButtons.add(btnNumbers[0]);

		btnReset = new JButton("C");
		btnReset.addActionListener(listener);
		panelButtons.add(btnReset);
	}

	public static void main(String[] args) {
		new NumberGrid();
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			for (int i = 0; i < btnNumbers.length; i++) {
				if (source == btnNumbers[i]) {
					tfDisplay.setText(tfDisplay.getText() + i);
					return;
				}
			}

			if (source == btnDelete) {
				String currentText = tfDisplay.getText();
				if (currentText.length() > 0) {
					tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
				}
			} else if (source == btnReset) {
				tfDisplay.setText("");
			}
		}
	}
}
