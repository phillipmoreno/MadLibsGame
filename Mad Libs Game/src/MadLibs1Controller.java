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

public class MadLibs1Controller {

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
	void closeProgram(ActionEvent event) {
		Stage stage = (Stage) close.getScene().getWindow();
		stage.close();
	}

	@FXML
	void openNewStage(ActionEvent event) {
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
		try {
			// FXMLLoader object is created to load in fxml file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MadLibsOutput1.fxml"));
			// Parent object is created and set as a loader
			Parent root = (Parent) loader.load();
			// MadLibOutputController object is created and controller is retrieved
			MadLibsOutput1Controller mloc = loader.getController();
			// the setTextArea function is called
			mloc.setTextArea(city1, city2, food1, food2, food3, book1, book2, toy, subject);
			// Stage object is created
			Stage stage = new Stage();
			// Stage title is set
			stage.setTitle("MAD LIBS Output");
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
