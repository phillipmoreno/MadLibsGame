import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class MadLibsOutput2Controller {

	@FXML
	private Button menuButton;

	@FXML
	private Button exitButton;

	@FXML
	private TextArea output;
	
    @FXML
    private ImageView madLibsLogo;

	@FXML
	void closeProgram(ActionEvent event) {
		System.exit(0);
	}
	
    @FXML
    void openMainMenu(ActionEvent event) {
      	Stage stage = (Stage) exitButton.getScene().getWindow();
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
				+ " halfway down the field. What a shot! Then it was my turn. I picked up the " + noun + ", took aim, and missed completely. I felt so "
				+ adjective2 + "! I tried again, and this time I kicked the " + noun
				+ " all the way to the end of the field. The fans in the stands hollered “" + expression
				+ "!” I won the game!\n\nNow I am the champion of " + school + "! I didn't want " + name
				+ " to feel badly, so I treated " + name + " to a trip to restaurant for a(n) " + food + " sundae with "
				+ liquid + " on top!");

	}

}
