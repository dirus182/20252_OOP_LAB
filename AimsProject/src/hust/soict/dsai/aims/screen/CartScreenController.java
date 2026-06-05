package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CartScreenController {
	private Cart cart;

	@FXML
	private TableView<Media> tbMedia;
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	@FXML
	private TableColumn<Media, Float> colMediaCost;

	public CartScreenController(Cart cart) {
		this.cart = cart;
	}

	@FXML
	private void initialize() {
		// Bind dữ liệu giỏ hàng lên TableView
		ObservableList<Media> items = FXCollections.observableArrayList(cart.getItemsOrdered());
		tbMedia.setItems(items);
		colMediaTitle.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("title"));
		colMediaCategory.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("category"));
		colMediaCost.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("cost"));
	}
}