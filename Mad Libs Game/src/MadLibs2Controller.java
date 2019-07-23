import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MadLibs2Controller {

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
    private Button close;

    @FXML
    void closeStage(ActionEvent event) {
    	Stage stage = (Stage) close.getScene().getWindow();
		stage.close();

    }

    @FXML
    void openNewStage(ActionEvent event) {
    	Stage stage = (Stage) close.getScene().getWindow();
		stage.close();
    	try {
			// FXMLLoader object is created to load in fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsOutput2.fxml"));
			// Parent object is created and set as a loader
			Parent root = (Parent) loader.load();
			// Stage object is created
			Stage Output = new Stage();
			// Stage title is set
			Output.setTitle("A New Sport");
			// Scene object is created and set with the Parent object as a parameter
			Output.setScene(new Scene(root));
			// The Stage icon is set to a .png image
			Output.getIcons().add(new Image("MadLibsLogo.png"));
			// Stage is displayed
			Output.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
