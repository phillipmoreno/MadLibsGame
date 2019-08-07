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
import javafx.stage.Stage;
import javafx.util.Duration;

public class MadLibs1Controller implements Initializable {

	@FXML
	private AnchorPane container;

	@FXML
	private TextField cityTF1;

	@FXML
	private TextField cityTF2;

	@FXML
	private TextField foodTF1;

	@FXML
	private TextField foodTF2;

	@FXML
	private TextField foodTF3;

	@FXML
	private TextField bookTF1;

	@FXML
	private TextField bookTF2;

	@FXML
	private TextField toyTF;

	@FXML
	private TextField schoolsubTF;

	@FXML
	private Button close;

	@FXML
	private Button libIt;

	Circle circle = new Circle(9.4);

	PathTransition transition1 = new PathTransition();
	PathTransition transition2 = new PathTransition();
	PathTransition transition3 = new PathTransition();

	// DropShadow object created for animation
	DropShadow shadow1 = new DropShadow();
	DropShadow shadow2 = new DropShadow();

	@FXML
	void closeProgram(ActionEvent event) {
		Stage stage = (Stage) close.getScene().getWindow();
		stage.close();
	}

	@FXML
	void openNewStage(ActionEvent event) throws IOException {
		if (cityTF1.getText().equals("") || cityTF2.getText().equals("") || foodTF1.getText().equals("")
				|| foodTF2.getText().equals("") || foodTF3.getText().equals("") || bookTF1.getText().equals("")
				|| bookTF2.getText().equals("") || toyTF.getText().equals("") || schoolsubTF.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please be sure to enter input for every field", "Missing Field(s)",
					JOptionPane.WARNING_MESSAGE);
		} else {
			// String objects are created and used to retrieve input from every text field
			String city1 = cityTF1.getText();
			String city2 = cityTF2.getText();
			String food1 = foodTF1.getText();
			String food2 = foodTF2.getText();
			String food3 = foodTF3.getText();
			String book1 = bookTF1.getText();
			String book2 = bookTF2.getText();
			String toy = toyTF.getText();
			String subject = schoolsubTF.getText();

			// FXMLLoader object is created to load in fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsOutput1.fxml"));
			// Parent object is created and set as a loader
			Parent root = (Parent) loader.load();
			// MadLibOutputController object is created and controller is retrieved
			MadLibsOutput1Controller mloc = loader.getController();
			// the setTextArea function is called
			mloc.setTextArea(city1, city2, food1, food2, food3, book1, book2, toy, subject);
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
			close.fire();
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
		} else if (event.getSource() == close) {
			transition2.stop();
			close.setEffect(shadow2);
		}
	}

	@FXML
	void play(MouseEvent event) {
		transition1.play();
		transition2.play();
		libIt.setEffect(null);
		close.setEffect(null);
	}

	public void initialize(URL url, ResourceBundle rb) {
		transition1.setNode(libIt);
		transition2.setNode(close);

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
