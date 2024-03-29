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

public class MadLibs3Controller implements Initializable {

	@FXML
	private AnchorPane container;

	@FXML
	private TextField animalTF;

	@FXML
	private TextField adjectiveTF;

	@FXML
	private TextField colorTF;

	@FXML
	private TextField nounTF1;

	@FXML
	private TextField foodTF;

	@FXML
	private TextField plantTF;

	@FXML
	private TextField verbTF;

	@FXML
	private TextField noiseTF;

	@FXML
	private TextField nounTF2;

	@FXML
	private TextField exclamationTF;

	@FXML
	private Button libIt;

	@FXML
	private Button menu;

	// Circle object created
	Circle circle = new Circle(9.0);

	// PathTransition objects created. Duration and Path are set in constructor
	PathTransition transition1 = new PathTransition(Duration.seconds(1.2), circle);
	PathTransition transition2 = new PathTransition(Duration.seconds(1.2), circle);

	// DropShadow object created for animation
	DropShadow shadow1 = new DropShadow();
	DropShadow shadow2 = new DropShadow();

	@FXML
	void returnToMenu(ActionEvent event) throws IOException {
		// FXML file is loaded
		Parent root = FXMLLoader.load(getClass().getResource("MadLibsMainMenu.fxml"));
		Scene scene = menu.getScene();
		root.translateXProperty().set(scene.getHeight());
		StackPane parentContainer = (StackPane) scene.getRoot();
		parentContainer.getChildren().add(root);
		// Timeline object is created
		Timeline timeline = new Timeline();
		KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf = new KeyFrame(Duration.seconds(0.9), kv);
		timeline.getKeyFrames().add(kf);
		container.setDisable(true);
		timeline.setOnFinished(event1 -> {
			parentContainer.getChildren().remove(container);
		});
		// Animation is played
		timeline.play();
	}

	@FXML
	void loadStory(ActionEvent event) throws IOException {
		if (animalTF.getText().equals("") || adjectiveTF.getText().equals("") || colorTF.getText().equals("")
				|| nounTF1.getText().equals("") || foodTF.getText().equals("") || plantTF.getText().equals("")
				|| nounTF2.getText().equals("") || verbTF.getText().equals("") || noiseTF.getText().equals("")
				|| exclamationTF.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please be sure to enter input for every field", "Missing Field(s)",
					JOptionPane.WARNING_MESSAGE);
		} else {
			// Strings are initialized and used to retrieve input from every text field
			String animal = animalTF.getText();
			String adjective = adjectiveTF.getText();
			String color = colorTF.getText();
			String noun1 = nounTF1.getText();
			String food = foodTF.getText();
			String plant = plantTF.getText();
			String noun2 = nounTF2.getText();
			String verb = verbTF.getText();
			String noise = noiseTF.getText();
			String exclamation = exclamationTF.getText();

			// FXMLLoader object is created to load FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsOutput3.fxml"));
			// Parent object is created and set as a loader
			Parent root = (Parent) loader.load();
			// MadLibOutputController object is created and controller is retrieved
			MadLibsOutput3Controller mloc = loader.getController();
			// setTextArea function is called
			mloc.setTextArea(animal, adjective, color, noun1, food, plant, noun2, verb, noise, exclamation);
			Scene scene = libIt.getScene();
			root.translateXProperty().set(scene.getWidth());
			StackPane parentContainer = (StackPane) scene.getRoot();
			parentContainer.getChildren().add(root);
			// Timeline object is created
			Timeline timeline = new Timeline();
			KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
			KeyFrame kf = new KeyFrame(Duration.seconds(0.9), kv);
			timeline.getKeyFrames().add(kf);
			// Nodes are disabled once the transition has commenced
			container.setDisable(true);
			timeline.setOnFinished(event1 -> {
				parentContainer.getChildren().remove(container);
			});
			// Animation is played
			timeline.play();
		}
	}

	@FXML
	void hovered(MouseEvent event) {
		// Color and spread is set for DropShadow objects
		shadow1.setColor(Color.CORNFLOWERBLUE);
		shadow1.setSpread(0.5);
		shadow2.setColor(Color.CORNFLOWERBLUE);
		shadow2.setSpread(0.5);

		if (event.getSource() == libIt) {
			// Transition is stopped once mouse hovers button
			transition1.stop();
			// Shadow effect is enabled once mouse hovers button
			libIt.setEffect(shadow1);
		} else if (event.getSource() == menu) {
			transition2.stop();
			menu.setEffect(shadow2);
		}
	}

	@FXML
	void play(MouseEvent event) {
		// Animation is played once mouse no longer hovers buttons
		transition1.play();
		transition2.play();
		// Shadow effect is removed once mouse no longer hovers buttons
		libIt.setEffect(null);
		menu.setEffect(null);
	}

	@FXML
	void keyPressed(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			libIt.fire();
		} else if (event.getCode().equals(KeyCode.ESCAPE)) {
			menu.fire();
		}
	}

	public void initialize(URL url, ResourceBundle rb) {
		// Nodes are set
		transition1.setNode(libIt);
		transition2.setNode(menu);

		// Transition direction is reversed once a full cycle has been completed
		transition1.setAutoReverse(true);
		transition2.setAutoReverse(true);

		// Transition cycles are repeated indefinitely
		transition1.setCycleCount(PathTransition.INDEFINITE);
		transition2.setCycleCount(PathTransition.INDEFINITE);

		// Transition animation is played
		transition1.play();
		transition2.play();

	}
}
