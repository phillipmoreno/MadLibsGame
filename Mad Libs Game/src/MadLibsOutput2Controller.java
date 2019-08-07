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

public class MadLibsOutput2Controller implements Initializable {

	@FXML
	private Label title;

	@FXML
	private Button menu;

	@FXML
	private Button exit;

	@FXML
	private TextArea output;

	@FXML
	private ImageView madLibsLogo;

	Circle circle = new Circle(9.4);
	Rectangle rectangle = new Rectangle(16, 8);

	PathTransition transition1 = new PathTransition();
	PathTransition transition2 = new PathTransition();
	PathTransition transition3 = new PathTransition();

	// DropShadow object created for animation
	DropShadow shadow1 = new DropShadow();
	DropShadow shadow2 = new DropShadow();

	@FXML
	void closeProgram(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void hovered(MouseEvent event) {
		shadow1.setColor(Color.CORNFLOWERBLUE);
		shadow1.setSpread(0.5);
		shadow2.setColor(Color.CORNFLOWERBLUE);
		shadow2.setSpread(0.5);

		if (event.getSource() == menu) {
			transition1.stop();
			menu.setEffect(shadow1);
		} else if (event.getSource() == exit) {
			transition2.stop();
			exit.setEffect(shadow2);
		}
	}

	@FXML
	void play(MouseEvent event) {
		transition1.play();
		transition2.play();
		menu.setEffect(null);
		exit.setEffect(null);
	}

	@FXML
	void openMainMenu(ActionEvent event) {
		Stage stage = (Stage) exit.getScene().getWindow();
		stage.close();
		try {
			// FXMLLoader object is created to load in fxml file
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

	public void setTextArea(String name, String adjective1, String noun, String expression, String number,
			String adjective2, String school, String restaurant, String food, String liquid) {
		output.setText(name + " and I decided to try out the newest sport at " + school + ". It's called " + adjective1
				+ " " + noun + ". The object of the game is to kick a(n) " + adjective1 + " " + noun
				+ " all the way to the end of the field. Every time you do, the fans yell “" + expression
				+ "!” and you get " + number + " points. The person with the most points wins.\n\n" + name
				+ " started and kicked the " + noun
				+ " halfway down the field. What a shot! Then it was my turn. I picked up the " + noun
				+ ", took aim, and missed completely. I felt so " + adjective2
				+ "! I tried again, and this time I kicked the " + noun
				+ " all the way to the end of the field. The fans in the stands hollered “" + expression
				+ "!” I won the game!\n\nNow I am the champion of " + school + "! I didn't want " + name
				+ " to feel badly, so I treated " + name + " to a trip to " + restaurant + " for a(n) " + food + " sundae with "
				+ liquid + " on top!");

	}

	public void initialize(URL url, ResourceBundle rb) {
		transition1.setNode(menu);
		transition2.setNode(exit);
		transition3.setNode(title);

		transition1.setPath(circle);
		transition2.setPath(circle);
		transition3.setPath(rectangle);

		transition1.setDuration(Duration.seconds(1.2));
		transition2.setDuration(Duration.seconds(1.2));
		transition3.setDuration(Duration.seconds(1.9));

		transition1.setAutoReverse(true);
		transition2.setAutoReverse(true);

		transition1.setCycleCount(PathTransition.INDEFINITE);
		transition2.setCycleCount(PathTransition.INDEFINITE);
		transition3.setCycleCount(PathTransition.INDEFINITE);

		transition1.play();
		transition2.play();
		transition3.play();

	}

}
