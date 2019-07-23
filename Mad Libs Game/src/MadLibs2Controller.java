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
		
    	try {
			// FXMLLoader object is created to load in fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsOutput2.fxml"));
			// Parent object is created and set as a loader
			Parent root = (Parent) loader.load();
			// MadLibOutputController object is created and controller is retrieved
			MadLibsOutput2Controller mloc = loader.getController();
			// the setTextArea function is called
			mloc.setTextArea(name, adjective1, noun, expression, number, adjective2, school, restaurant, food, liquid);
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
