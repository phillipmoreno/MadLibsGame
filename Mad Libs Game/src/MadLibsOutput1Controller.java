import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MadLibsOutput1Controller {

	@FXML
	public TextArea madLibsTA;
	
	   @FXML
	    private Button menu;

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
				+ "\n\nThe best area of Wackytown is Make-Believe Land, which includes the “No Tests School,” where students study subject, but where there are "
				+ "never any tests. There is also a demonstration of the “Homework Robot.” Just give your homework to the robot, press the button, and it comes out "
				+ "done entirely correct! It's the wave of the future! "
				+ "\n\nWe hope you will come visit Wackytown soon. You are sure to have a wacky time!");
	}
}
