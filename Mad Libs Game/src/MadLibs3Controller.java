import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MadLibs3Controller {

    @FXML
    private Label exclamationTF;

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
    private Button exit;

    @FXML
    void closeProgram(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void openNewStage(ActionEvent event) {
       	Stage story3 = (Stage) exit.getScene().getWindow();
    	story3.close();
    	try {
			// FXMLLoader object is created to load in fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsOutput3.fxml"));
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
    }

}
