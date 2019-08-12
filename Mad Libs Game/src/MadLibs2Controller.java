import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MadLibs2Controller implements Initializable {

	@FXML
	private AnchorPane container;

	@FXML
	private TextField nameTF;

	@FXML
	private TextField adjectiveTF1;

	@FXML
	private TextField nounTF;

	@FXML
	private TextField expressionTF;

	@FXML
	private TextField numberTF;

	@FXML
	private TextField adjectiveTF2;

	@FXML
	private TextField schoolTF;

	@FXML
	private TextField restaurantTF;

	@FXML
	private TextField foodTF;

	@FXML
	private TextField liquidTF;

	@FXML
	private Button libIt;

	@FXML
	private Button menu;

	Circle circle = new Circle(9.0);

	PathTransition transition1 = new PathTransition();
	PathTransition transition2 = new PathTransition();
	PathTransition transition3 = new PathTransition();

	// DropShadow object created for animation
	DropShadow shadow1 = new DropShadow();
	DropShadow shadow2 = new DropShadow();

	@FXML
	void returnToMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MadLibsMainMenu.fxml"));
		Scene scene = menu.getScene();
		root.translateXProperty().set(scene.getHeight());
		StackPane parentContainer = (StackPane) scene.getRoot();
		parentContainer.getChildren().add(root);
		Timeline timeline = new Timeline();
		KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf = new KeyFrame(Duration.seconds(0.9), kv);
		timeline.getKeyFrames().add(kf);
		container.setDisable(true);
		timeline.setOnFinished(event1 -> {
			parentContainer.getChildren().remove(container);
		});
		timeline.play();
	}

	@FXML
	void loadStory(ActionEvent event) throws IOException {
		if (nameTF.getText().equals("") || adjectiveTF1.getText().equals("") || nounTF.getText().equals("")
				|| expressionTF.getText().equals("") || numberTF.getText().equals("")
				|| adjectiveTF2.getText().equals("") || schoolTF.getText().equals("")
				|| restaurantTF.getText().equals("") || foodTF.getText().equals("") || liquidTF.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please be sure to enter input for every field", "Missing Field(s)",
					JOptionPane.WARNING_MESSAGE);
		} else {
			String name = nameTF.getText();
			String adjective1 = adjectiveTF1.getText();
			String noun = nounTF.getText();
			String expression = expressionTF.getText();
			String number = numberTF.getText();
			String adjective2 = adjectiveTF2.getText();
			String school = schoolTF.getText();
			String restaurant = restaurantTF.getText();
			String food = foodTF.getText();
			String liquid = liquidTF.getText();

			// FXMLLoader object is created to load in fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsOutput2.fxml"));
			// Parent object is created and set as a loader
			Parent root = (Parent) loader.load();
			// MadLibOutputController object is created and controller is retrieved
			MadLibsOutput2Controller mloc = loader.getController();
			// the setTextArea function is called
			mloc.setTextArea(name, adjective1, noun, expression, number, adjective2, school, restaurant, food, liquid);
			Scene scene = libIt.getScene();
			root.translateXProperty().set(scene.getWidth());
			StackPane parentContainer = (StackPane) scene.getRoot();
			parentContainer.getChildren().add(root);
			Timeline timeline = new Timeline();
			KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
			KeyFrame kf = new KeyFrame(Duration.seconds(0.9), kv);
			timeline.getKeyFrames().add(kf);
			timeline.setOnFinished(event1 -> {
				parentContainer.getChildren().remove(container);
			});
			timeline.play();
		}
	}

	@FXML
	void keyPressed(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			libIt.fire();
		} else if (event.getCode().equals(KeyCode.ESCAPE)) {
			menu.fire();
		}
	}

	@FXML
	void hovered(MouseEvent event) {
		shadow1.setColor(Color.CORNFLOWERBLUE);
		shadow1.setSpread(0.5);
		shadow2.setColor(Color.CORNFLOWERBLUE);
		shadow2.setSpread(0.5);

		if (event.getSource() == libIt) {
			transition1.stop();
			libIt.setEffect(shadow1);
		} else if (event.getSource() == menu) {
			transition2.stop();
			menu.setEffect(shadow2);
		}
	}

	@FXML
	void play(MouseEvent event) {
		transition1.play();
		transition2.play();
		libIt.setEffect(null);
		menu.setEffect(null);
	}

	public void initialize(URL url, ResourceBundle rb) {
		transition1.setNode(libIt);
		transition2.setNode(menu);

		transition1.setPath(circle);
		transition2.setPath(circle);

		transition1.setDuration(Duration.seconds(1.2));
		transition2.setDuration(Duration.seconds(1.2));

		transition1.setAutoReverse(true);
		transition2.setAutoReverse(true);

		transition1.setCycleCount(PathTransition.INDEFINITE);
		transition2.setCycleCount(PathTransition.INDEFINITE);

		transition1.play();
		transition2.play();
	}
}
