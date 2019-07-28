import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MadLibsOutput3Controller implements Initializable {

	@FXML
	private TextArea output;

	@FXML
	private ImageView logo;
	
    @FXML
    private Polygon triangle1;

    @FXML
    private Polygon triangle2;

	@FXML
	private Button exit;

	Circle circle = new Circle(9.4);
	
	RotateTransition transition1 = new RotateTransition(Duration.seconds(1.2), triangle1);
	RotateTransition transition2 = new RotateTransition(Duration.seconds(1.2), triangle2);
	
	@FXML
	void closeProgram(ActionEvent event) {
		System.exit(0);
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
	
	public void initialize(URL url, ResourceBundle rb) {


		transition1.setNode(triangle1);
		transition2.setNode(triangle2);

		transition1.setByAngle(360);
		transition2.setByAngle(360);
		
		transition1.setCycleCount(RotateTransition.INDEFINITE);
		transition2.setCycleCount(RotateTransition.INDEFINITE);

		transition1.play();
		transition2.play();


	}
}
