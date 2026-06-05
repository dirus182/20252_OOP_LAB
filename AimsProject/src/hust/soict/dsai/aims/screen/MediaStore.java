package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;

	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart; // gán
		this.setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel(media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Nút Add to Cart
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cart.addMedia(media);
				JOptionPane.showMessageDialog(MediaStore.this, media.getTitle() + " added to cart.");
			}
		});
		container.add(btnAddToCart);
		// Nút Play nếu media implement Playable
		if (media instanceof Playable) {
			JButton btnPlay = new JButton("Play");
			btnPlay.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						((Playable) media).play();
						JOptionPane.showMessageDialog(MediaStore.this,
								"Playing " + media.getTitle() + "\nLength: " + getPlayableLength());
					} catch (PlayerException ex) {
						JOptionPane.showMessageDialog(MediaStore.this, ex.getMessage(), "Cannot play",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
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

	private String getPlayableLength() {
		if (media instanceof Disc) {
			return ((Disc) media).getLength() + " minutes";
		}
		return "N/A";
	}
}
