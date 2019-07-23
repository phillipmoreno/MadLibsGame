import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MadLibsMainMenuController implements Initializable {

	@FXML
	private Button story1;

	@FXML
	private Button story2;

	@FXML
	private Button story3;

	@FXML
	private Button exit;

	@FXML
	void closeProgram(ActionEvent event) {
		System.exit(0);
	}

	// DropShadow object created for animation
	DropShadow shadow1 = new DropShadow();
	DropShadow shadow2 = new DropShadow();
	DropShadow shadow3 = new DropShadow();
	DropShadow shadow4 = new DropShadow();

	// Circle object created for PathTransition
	Circle circle = new Circle(9.4);
	Rectangle rectangle = new Rectangle(20, 10);

	// PathTransition objects created for animation
	PathTransition transition1 = new PathTransition();
	PathTransition transition2 = new PathTransition();
	PathTransition transition3 = new PathTransition();

	@FXML
	void handleButtonAction(ActionEvent event) {
		Stage menu = (Stage) exit.getScene().getWindow();
    	menu.close();
		if (event.getSource() == story1) {
			try {
				// FXMLLoader object is created to load in fxml file
				FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsStory1.fxml"));
				// Parent object is created and set as a loader
				Parent root = (Parent) loader.load();
				// Stage object is created
				Stage stage = new Stage();
				// Stage title is set
				stage.setTitle("WackyTown");
				// Scene object is created and set with the Parent object as a parameter
				stage.setScene(new Scene(root));
				// The Stage icon is set to a .png image
				stage.getIcons().add(new Image("MadLibsLogo.png"));
				// Stage is displayed
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (event.getSource() == story2) {
			try {
				// FXMLLoader object is created to load in fxml file
				FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsStory2.fxml"));
				// Parent object is created and set as a loader
				Parent root = (Parent) loader.load();
				// Stage object is created
				Stage stage = new Stage();
				// Stage title is set
				stage.setTitle("A New Sport");
				// Scene object is created and set with the Parent object as a parameter
				stage.setScene(new Scene(root));
				// The Stage icon is set to a .png image
				stage.getIcons().add(new Image("MadLibsLogo.png"));
				// Stage is displayed
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (event.getSource() == story3) {
			try {
				// FXMLLoader object is created to load in fxml file
				FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsStory3.fxml"));
				// Parent object is created and set as a loader
				Parent root = (Parent) loader.load();
				// Stage object is created
				Stage stage = new Stage();
				// Stage title is set
				stage.setTitle("Our Class Project");
				// Scene object is created and set with the Parent object as a parameter
				stage.setScene(new Scene(root));
				// The Stage icon is set to a .png image
				stage.getIcons().add(new Image("MadLibsLogo.png"));
				// Stage is displayed
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void hovered(MouseEvent event) {
		shadow1.setColor(Color.BLUE);
		shadow1.setSpread(0.4);
		shadow2.setColor(Color.RED);
		shadow2.setSpread(0.4);
		shadow3.setColor(Color.GOLD);
		shadow3.setSpread(0.4);

		if (event.getSource() == story1) {
			story1.setEffect(shadow1);
			transition1.stop();
		} else if (event.getSource() == story2) {
			story2.setEffect(shadow2);
			transition2.stop();
		} else if (event.getSource() == story3) {
			story3.setEffect(shadow3);
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

		transition1.setDuration(Duration.seconds(1.2));
		transition2.setDuration(Duration.seconds(1.2));
		transition3.setDuration(Duration.seconds(1.2));

		transition1.setPath(rectangle);
		transition2.setPath(circle);
		transition3.setPath(rectangle);

		transition1.setCycleCount(PathTransition.INDEFINITE);
		transition2.setCycleCount(PathTransition.INDEFINITE);
		transition3.setCycleCount(PathTransition.INDEFINITE);

		transition1.play();
		transition2.play();
		transition3.play();
	}
}
