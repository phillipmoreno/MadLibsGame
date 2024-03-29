import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MadLibsMainMenuController implements Initializable {

	@FXML
	private StackPane parentContainer;

	@FXML
	private AnchorPane anchorRoot;

	@FXML
	private Button story1;

	@FXML
	private Button story2;

	@FXML
	private Button story3;

	@FXML
	private Polygon triangle1;

	@FXML
	private Polygon triangle2;

	@FXML
	private Polygon triangle3;

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
	PathTransition exitTransition = new PathTransition();

	RotateTransition transition4 = new RotateTransition(Duration.seconds(1.2), triangle1);
	RotateTransition transition5 = new RotateTransition(Duration.seconds(1.2), triangle2);
	RotateTransition transition6 = new RotateTransition(Duration.seconds(1.2), triangle3);

	@FXML
	void loadStory1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MadLibsStory1.fxml"));
		Scene scene = story1.getScene();
		root.translateYProperty().set(scene.getHeight());
		parentContainer.getChildren().add(root);
		Timeline timeline = new Timeline();
		KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf = new KeyFrame(Duration.seconds(0.9), kv);
		timeline.getKeyFrames().add(kf);
		story1.setDisable(true);
		story2.setDisable(true);
		story3.setDisable(true);
		timeline.setOnFinished(event1 -> {
			parentContainer.getChildren().remove(anchorRoot);
		});
		timeline.play();
	}

	@FXML
	void loadStory2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MadLibsStory2.fxml"));
		Scene scene = story2.getScene();
		root.translateYProperty().set(scene.getHeight());
		parentContainer.getChildren().add(root);
		Timeline timeline = new Timeline();
		KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf = new KeyFrame(Duration.seconds(0.9), kv);
		timeline.getKeyFrames().add(kf);
		story1.setDisable(true);
		story2.setDisable(true);
		story3.setDisable(true);
		timeline.setOnFinished(event1 -> {
			parentContainer.getChildren().remove(anchorRoot);
		});
		timeline.play();
	}

	@FXML
	void loadStory3(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MadLibsStory3.fxml"));
		Scene scene = story3.getScene();
		root.translateYProperty().set(scene.getHeight());
		parentContainer.getChildren().add(root);
		Timeline timeline = new Timeline();
		KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf = new KeyFrame(Duration.seconds(0.9), kv);
		timeline.getKeyFrames().add(kf);
		story1.setDisable(true);
		story2.setDisable(true);
		story3.setDisable(true);
		timeline.setOnFinished(event1 -> {
			parentContainer.getChildren().remove(anchorRoot);
		});
		timeline.play();
	}

	@FXML
	void hovered(MouseEvent event) {
		shadow1.setColor(Color.BLUE);
		shadow1.setSpread(0.4);
		shadow2.setColor(Color.RED);
		shadow2.setSpread(0.4);
		shadow3.setColor(Color.GOLD);
		shadow3.setSpread(0.4);
		shadow4.setColor(Color.LIGHTGREEN);
		shadow4.setSpread(0.4);

		if (event.getSource() == story1) {
			story1.setEffect(shadow1);
			transition1.stop();
			transition4.stop();
			triangle1.setFill(Color.LIGHTGREEN);
		} else if (event.getSource() == story2) {
			story2.setEffect(shadow2);
			transition2.stop();
			transition5.stop();
			triangle2.setFill(Color.LIGHTGREEN);
		} else if (event.getSource() == story3) {
			story3.setEffect(shadow3);
			transition3.stop();
			transition6.stop();
			triangle3.setFill(Color.LIGHTGREEN);
		} else if (event.getSource() == exit) {
			exit.setEffect(shadow4);
			exitTransition.stop();
		}
	}

	@FXML
	void play(MouseEvent event) {
		triangle1.setFill(Color.DODGERBLUE);
		transition1.play();
		transition4.play();
		story1.setEffect(null);
		triangle2.setFill(Color.RED);
		transition2.play();
		transition5.play();
		story2.setEffect(null);
		triangle3.setFill(Color.GOLD);
		transition3.play();
		transition6.play();
		story3.setEffect(null);
		exitTransition.play();
		exit.setEffect(null);
	}

	public void initialize(URL url, ResourceBundle rb) {

		transition1.setNode(story1);
		transition2.setNode(story2);
		transition3.setNode(story3);
		transition4.setNode(triangle1);
		transition5.setNode(triangle2);
		transition6.setNode(triangle3);
		exitTransition.setNode(exit);

		transition4.setByAngle(360);
		transition5.setByAngle(360);
		transition6.setByAngle(360);

		transition4.setAutoReverse(false);
		transition5.setAutoReverse(false);
		transition6.setAutoReverse(false);

		transition1.setDuration(Duration.seconds(1.2));
		transition2.setDuration(Duration.seconds(1.2));
		transition3.setDuration(Duration.seconds(1.2));
		exitTransition.setDuration(Duration.seconds(1.2));

		transition1.setPath(rectangle);
		transition2.setPath(circle);
		transition3.setPath(rectangle);
		exitTransition.setPath(circle);

		transition1.setCycleCount(PathTransition.INDEFINITE);
		transition2.setCycleCount(PathTransition.INDEFINITE);
		transition3.setCycleCount(PathTransition.INDEFINITE);
		transition4.setCycleCount(RotateTransition.INDEFINITE);
		transition5.setCycleCount(RotateTransition.INDEFINITE);
		transition6.setCycleCount(RotateTransition.INDEFINITE);
		exitTransition.setCycleCount(PathTransition.INDEFINITE);

		transition1.play();
		transition2.play();
		transition3.play();
		transition4.play();
		transition5.play();
		transition6.play();
		exitTransition.play();

	}
}
