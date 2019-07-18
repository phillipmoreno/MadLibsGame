import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MadLibsMainMenuController implements Initializable {

	@FXML
	private Button story1;

	@FXML
	private Button story2;

	@FXML
	private Button story3;
	
	// DropShadow object created for animation
	DropShadow shadow = new DropShadow();

	// Circle object created for PathTransition
	Circle circle = new Circle(9);
	
	// PathTransition objects created for animation
	PathTransition transition1 = new PathTransition();
	PathTransition transition2 = new PathTransition();
	PathTransition transition3 = new PathTransition();

	@FXML
	void handleButtonAction(ActionEvent event) {
		if (event.getSource() == story1) {

		} else if (event.getSource() == story2) {

		} else if (event.getSource() == story3) {

		}
	}

	@FXML
	void hovered(MouseEvent event) {
		shadow.setColor(Color.BLUE);
		if (event.getSource() == story1) {
			story1.setEffect(shadow);
			transition1.stop();
		} else if (event.getSource() == story2) {
			story2.setEffect(shadow);
			transition2.stop();
		} else if (event.getSource() == story3) {
			story3.setEffect(shadow);
			transition3.stop();
		}
	}

	@FXML
	void play(MouseEvent event) {
		transition1.play();
		story1.setEffect(null);
		transition2.play();
		story2.setEffect(null);
		transition3.play();
		story3.setEffect(null);

	}

	public void initialize(URL url, ResourceBundle rb) {

		transition1.setNode(story1);
		transition2.setNode(story2);
		transition3.setNode(story3);

		transition1.setDuration(Duration.seconds(2));
		transition2.setDuration(Duration.seconds(2));
		transition3.setDuration(Duration.seconds(2));

		transition1.setPath(circle);
		transition2.setPath(circle);
		transition3.setPath(circle);

		transition1.setCycleCount(PathTransition.INDEFINITE);
		transition2.setCycleCount(PathTransition.INDEFINITE);
		transition3.setCycleCount(PathTransition.INDEFINITE);

		transition1.play();
		transition2.play();
		transition3.play();
	}
}
