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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MadLibsOutput3Controller implements Initializable {

	@FXML
	private Label title;

	@FXML
	private TextArea output;

	@FXML
	private ImageView logo;

	@FXML
	private Button menu;

	@FXML
	private Button exit;

	// Circle object is created
	Circle circle = new Circle(9.4);
	// Rectangle object is created
	Rectangle rectangle = new Rectangle(16, 8);

	// PathTransition objects are created. Duration and Path are set in constructor
	PathTransition transition1 = new PathTransition(Duration.seconds(1.2), circle);
	PathTransition transition2 = new PathTransition(Duration.seconds(1.2), circle);
	PathTransition transition3 = new PathTransition(Duration.seconds(1.9), rectangle);

	// DropShadow object created for animation
	DropShadow shadow1 = new DropShadow();
	DropShadow shadow2 = new DropShadow();
	DropShadow shadow3 = new DropShadow();

	@FXML
	void closeProgram(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void openMainMenu(ActionEvent event) {
		Stage stage = (Stage) exit.getScene().getWindow();
		stage.close();
		try {
			// FXMLLoader object is created to load FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsMainMenu.fxml"));
			// Parent object is created and set as a loader
			Parent root = (Parent) loader.load();
			// Stage object is created
			Stage menu = new Stage();
			// Stage title is set
			menu.setTitle("Mad Libs");
			// Scene object is created and set with the Parent object as a parameter
			menu.setScene(new Scene(root));
			// The Stage icon is set to a .png image
			menu.getIcons().add(new Image("MadLibsLogo.png"));
			// Stage is displayed
			menu.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// setTextArea function is created to output the story that includes user input
	public void setTextArea(String animal, String adjective, String color, String noun1, String food, String plant,
			String noun2, String verb, String noise, String exclamation) {
		output.setText("This year our class is doing a special science project. We have a(n) " + animal
				+ " that we are taking care of. It is very " + adjective + " and it has " + color
				+ " eyes. It lives in a(n) " + noun1 + " in the back of our classroom. We feed it " + food + " and "
				+ plant + " every day, but I think it really wants to eat my " + noun2 + ". Everyone likes our "
				+ animal + ".\r\n" + "\r\n" + "One day, the " + animal + " got out of its cage and started " + verb
				+ " all around the room. It made a loud " + noise + ". I think it was trying to say, “" + exclamation
				+ "!”");
	}

	@FXML
	void hovered(MouseEvent event) {
		// Color and spread is set for DropShadow objects
		shadow1.setColor(Color.CORNFLOWERBLUE);
		shadow1.setSpread(0.5);
		shadow2.setColor(Color.CORNFLOWERBLUE);
		shadow2.setSpread(0.5);

		if (event.getSource() == menu) {
			// Transition is stopped once mouse hovers button
			transition1.stop();
			// Shadow effect is enabled once mouse hovers button
			menu.setEffect(shadow1);
		} else if (event.getSource() == exit) {
			transition2.stop();
			exit.setEffect(shadow2);
		}
	}

	@FXML
	void play(MouseEvent event) {
		// Animation is played once mouse no longer hovers buttons
		transition1.play();
		transition2.play();
		// Shadow effect is removed once mouse no longer hovers buttons
		menu.setEffect(null);
		exit.setEffect(null);
	}

	public void initialize(URL url, ResourceBundle rb) {
		// Nodes are set
		transition1.setNode(menu);
		transition2.setNode(exit);
		transition3.setNode(title);

		// Transition direction is reversed once a full cycle has been completed
		transition1.setAutoReverse(true);
		transition2.setAutoReverse(true);

		// Transition cycles are repeated indefinitely
		transition1.setCycleCount(PathTransition.INDEFINITE);
		transition2.setCycleCount(PathTransition.INDEFINITE);
		transition3.setCycleCount(PathTransition.INDEFINITE);

		// Transition animation is played
		transition1.play();
		transition2.play();
		transition3.play();
	}
}
