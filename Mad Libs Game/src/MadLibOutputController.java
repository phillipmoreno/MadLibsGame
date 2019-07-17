import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MadLibOutputController {

	@FXML
	public TextArea madLibsTA;

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
