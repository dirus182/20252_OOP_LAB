package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CartScreen extends JFrame {
	private Cart cart;
	private JFXPanel fxPanel;

	public CartScreen(Cart cart) {
		this.cart = cart;

		Platform.setImplicitExit(false);
		fxPanel = new JFXPanel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(fxPanel, BorderLayout.CENTER);

		setTitle("Cart");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Platform.runLater(() -> {
			try {
				URL fxmlUrl = getClass().getResource("/fxml/cart.fxml");
				if (fxmlUrl == null) {
					throw new IOException("Cannot find /fxml/cart.fxml");
				}
				FXMLLoader loader = new FXMLLoader(fxmlUrl);
				loader.setController(new CartScreenController(cart));
				Parent root = loader.load();
				fxPanel.setScene(new Scene(root));
				System.out.println("Cart screen loaded from FXML.");
			} catch (Throwable e) {
				System.err.println("Cannot load cart.fxml. Falling back to JavaFX code UI.");
				e.printStackTrace();
				fxPanel.setScene(new Scene(createFallbackCartView()));
			}
		});

		setVisible(true);
	}

	private Parent createFallbackCartView() {
		BorderPane root = new BorderPane();
		root.setPrefSize(1024, 768);

		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Options");
		menu.getItems().addAll(new MenuItem("View store"), new MenuItem("View cart"));
		menuBar.getMenus().add(menu);

		Label title = new Label("CART");
		title.setFont(new Font(50));
		title.setTextFill(Color.AQUA);
		title.setPadding(new Insets(0, 0, 0, 10));
		root.setTop(new VBox(menuBar, title));

		TextField tfFilter = new TextField();
		RadioButton byId = new RadioButton("By ID");
		RadioButton byTitle = new RadioButton("By Title");
		ToggleGroup filterGroup = new ToggleGroup();
		byId.setToggleGroup(filterGroup);
		byTitle.setToggleGroup(filterGroup);
		byId.setSelected(true);

		HBox filterBox = new HBox(10, new Label("Filter:"), tfFilter, byId, byTitle);
		filterBox.setAlignment(Pos.CENTER_LEFT);
		filterBox.setPadding(new Insets(10, 0, 10, 0));

		TableView<Media> table = new TableView<Media>();
		TableColumn<Media, String> titleColumn = new TableColumn<Media, String>("Title");
		titleColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		TableColumn<Media, String> categoryColumn = new TableColumn<Media, String>("Category");
		categoryColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		TableColumn<Media, Float> costColumn = new TableColumn<Media, Float>("Cost");
		costColumn.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		table.getColumns().add(titleColumn);
		table.getColumns().add(categoryColumn);
		table.getColumns().add(costColumn);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		FilteredList<Media> filteredItems = new FilteredList<Media>(cart.getItemsOrdered(), media -> true);
		table.setItems(filteredItems);

		Button btnPlay = new Button("Play");
		Button btnRemove = new Button("Remove");
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.getButtons().addAll(btnPlay, btnRemove);

		VBox center = new VBox(filterBox, table, buttonBar);
		center.setPadding(new Insets(0, 10, 0, 10));
		VBox.setVgrow(table, Priority.ALWAYS);
		root.setCenter(center);

		Label total = new Label(formatTotal());
		total.setFont(new Font(24));
		total.setTextFill(Color.AQUA);
		Label totalTitle = new Label("Total:");
		totalTitle.setFont(new Font(24));
		HBox totalBox = new HBox(10, totalTitle, total);
		totalBox.setAlignment(Pos.CENTER);

		Button placeOrder = new Button("Place Order");
		placeOrder.setFont(new Font(24));
		placeOrder.setTextFill(Color.WHITE);
		placeOrder.setStyle("-fx-background-color: red;");

		VBox right = new VBox(20, totalBox, placeOrder);
		right.setAlignment(Pos.TOP_CENTER);
		right.setPadding(new Insets(50, 20, 0, 20));
		root.setRight(right);

		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				btnRemove.setVisible(newValue != null);
				btnPlay.setVisible(newValue instanceof Playable);
			}
		});

		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				final String filter = newValue == null ? "" : newValue.toLowerCase();
				filteredItems.setPredicate(media -> {
					if (filter.length() == 0) {
						return true;
					}
					if (byId.isSelected()) {
						return String.valueOf(media.getId()).contains(filter);
					}
					return media.getTitle() != null && media.getTitle().toLowerCase().contains(filter);
				});
			}
		});

		btnRemove.setOnAction(event -> {
			Media selected = table.getSelectionModel().getSelectedItem();
			if (selected != null) {
				cart.removeMedia(selected);
				total.setText(formatTotal());
			}
		});

		btnPlay.setOnAction(event -> {
			Media selected = table.getSelectionModel().getSelectedItem();
			if (selected instanceof Playable) {
				try {
					((Playable) selected).play();
					showAlert(Alert.AlertType.INFORMATION, "Playing", "Playing " + selected.getTitle());
				} catch (PlayerException e) {
					showAlert(Alert.AlertType.ERROR, "Cannot play", e.getMessage());
				}
			}
		});

		placeOrder.setOnAction(event -> {
			cart.clearCart();
			total.setText(formatTotal());
			showAlert(Alert.AlertType.INFORMATION, "Order", "An order has been created.");
		});

		cart.getItemsOrdered()
				.addListener((javafx.collections.ListChangeListener<Media>) change -> total.setText(formatTotal()));

		return root;
	}

	private String formatTotal() {
		return String.format("%.2f $", cart.totalCost());
	}

	private void showAlert(Alert.AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
