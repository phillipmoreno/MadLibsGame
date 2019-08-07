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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MadLibsOutput1Controller implements Initializable {

	@FXML
	private Label title;

	@FXML
	public TextArea madLibsTA;

	@FXML
	private Button menu;

	@FXML
	private Button exit;

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
	void returnToMenu(ActionEvent event) {
		Stage output = (Stage) menu.getScene().getWindow();
		output.close();
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

	// setTextArea function is created to output the http://www.eduplace.com/tales/
	// chosen story including the user input
	public void setTextArea(String town1, String town2, String food1, String food2, String food3, String book1,
			String book2, String toy, String subject) {
		madLibsTA.setText("Wackytown is a new amusement park located outside " + town1
				+ ". Wackytown has several distinct areas, including " + town2
				+ " Blvd., Make-Believe Land, Wild West Land, and Space Land. Best of all, everything has the Wackytown difference built right in."
				+ "\n\nWhen you first enter Wackytown, you walk onto " + town2
				+ " Blvd., which is just like the real place. There is a grocery store selling " + food1 + ", " + food2
				+ ", " + " and " + food3 + ". There is a bookstore selling " + book1 + " and " + book2
				+ ". There is even a toy store selling " + toy + "! It's like having " + town2
				+ " right in your own back yard."
				+ "\n\nThe best area of Wackytown is Make-Believe Land, which includes the “No Tests School,” where students study " + subject + ", but where there are "
				+ "never any tests. There is also a demonstration of the “Homework Robot.” Just give your homework to the robot, press the button, and it comes out "
				+ "done entirely correct! It's the wave of the future! "
				+ "\n\nWe hope you will come visit Wackytown soon. You are sure to have a wacky time!");
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
