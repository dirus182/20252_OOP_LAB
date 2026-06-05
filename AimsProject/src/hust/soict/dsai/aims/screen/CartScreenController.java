package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CartScreenController {
	private Cart cart;
	private FilteredList<Media> filteredItems;

	@FXML
	private TableView<Media> tblMedia;
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnRemove;
	@FXML
	private TextField tfFilter;
	@FXML
	private RadioButton radioBtnFilterId;
	@FXML
	private RadioButton radioBtnFilterTitle;
	@FXML
	private Label lblTotal;

	public CartScreenController(Cart cart) {
		this.cart = cart;
	}

	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Media, Float>("cost"));

		ObservableList<Media> items = cart.getItemsOrdered();
		filteredItems = new FilteredList<Media>(items, media -> true);
		tblMedia.setItems(filteredItems);
		tblMedia.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		updateTotal();

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
		});

		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});

		items.addListener(new ListChangeListener<Media>() {
			@Override
			public void onChanged(Change<? extends Media> change) {
				updateTotal();
			}
		});
	}

	private void updateButtonBar(Media media) {
		boolean hasSelection = media != null;
		btnRemove.setVisible(hasSelection);
		btnPlay.setVisible(hasSelection && media instanceof Playable);
	}

	@FXML
	private void btnRemovePressed() {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media != null) {
			cart.removeMedia(media);
			updateTotal();
		}
	}

	@FXML
	private void btnPlayPressed() {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media instanceof Playable) {
			try {
				((Playable) media).play();
				showInfo("Playing", "Playing " + media.getTitle());
			} catch (PlayerException e) {
				showError(e.getMessage());
			}
		}
	}

	@FXML
	private void btnPlaceOrderPressed() {
		cart.clearCart();
		showInfo("Order", "An order has been created.");
		updateTotal();
	}

	private void showFilteredMedia(String filter) {
		final String lowerCaseFilter = filter == null ? "" : filter.toLowerCase();
		filteredItems.setPredicate(media -> {
			if (lowerCaseFilter.length() == 0) {
				return true;
			}
			if (radioBtnFilterId.isSelected()) {
				return String.valueOf(media.getId()).contains(lowerCaseFilter);
			}
			return media.getTitle() != null && media.getTitle().toLowerCase().contains(lowerCaseFilter);
		});
	}

	private void updateTotal() {
		lblTotal.setText(String.format("%.2f $", cart.totalCost()));
	}

	private void showInfo(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	private void showError(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Cannot play");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
