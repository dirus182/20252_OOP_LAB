package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * CartScreen: JFrame hiển thị giỏ hàng - Nhúng JavaFX TableView bằng JFXPanel -
 * Constructor nhận Cart để load dữ liệu
 */
public class CartScreen extends JFrame {
	private Cart cart;
	private JFXPanel fxPanel;

	public CartScreen(Cart cart) {
		this.cart = cart;

		fxPanel = new JFXPanel(); // nhúng JavaFX vào Swing
		this.add(fxPanel);

		setTitle("Cart");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// JavaFX thread: load FXML và set Controller
		Platform.runLater(() -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/cart.fxml"));
				CartScreenController controller = new CartScreenController(cart);
				loader.setController(controller);
				Parent root = loader.load();
				fxPanel.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		setVisible(true);
	}
}