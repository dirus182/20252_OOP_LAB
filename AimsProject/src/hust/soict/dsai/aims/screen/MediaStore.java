package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;

	public MediaStore(Media media) {
		this.media = media;

		this.setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel(media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton btnAddToCart = new JButton("Add to cart");
		container.add(btnAddToCart);

		if (media instanceof Playable) {
			JButton btnPlay = new JButton("Play");
			container.add(btnPlay);
		}

		this.add(Box.createVerticalGlue()); // tạo khoảng trống co giãn theo chiều dọc
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.add(Box.createVerticalGlue());

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setPreferredSize(new Dimension(200, 150));
	}
}