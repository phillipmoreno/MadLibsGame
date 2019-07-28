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

public class MadLibs3Controller {

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
	private Button exit;

	@FXML
	void closeProgram(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void openNewStage(ActionEvent event) {
		Stage story3 = (Stage) exit.getScene().getWindow();
		story3.close();
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
	
		try {
			
			// FXMLLoader object is created to load in fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsOutput3.fxml"));
			// Parent object is created and set as a loader
			Parent root = (Parent) loader.load();
			// MadLibOutputController object is created and controller is retrieved
			MadLibsOutput3Controller mloc = loader.getController();
			// the setTextArea function is called
			mloc.setTextArea(animal, adjective, color, noun1, food, plant, noun2, verb, noise, exclamation);
			// Stage object is created
			Stage Output = new Stage();
			// Stage title is set
			Output.setTitle("Our Class Project");
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
