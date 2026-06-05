package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	@FXML
	private Pane drawingAreaPane;

	@FXML
	private RadioButton penRadioButton;

	@FXML
	private RadioButton eraserRadioButton;

	@FXML
	private void drawingAreaMouseDragged(MouseEvent event) {
		Circle newCircle = new Circle(event.getX(), event.getY(), 4);
		if (eraserRadioButton != null && eraserRadioButton.isSelected()) {
			newCircle.setFill(Color.WHITE);
		} else {
			newCircle.setFill(Color.BLACK);
		}
		drawingAreaPane.getChildren().add(newCircle);
	}

	@FXML
	private void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
}
