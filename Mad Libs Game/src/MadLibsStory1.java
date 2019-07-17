import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MadLibsStory1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Parent object is created
		Parent root = FXMLLoader.load(getClass().getResource("MadLibsStory1.fxml"));
		// Scene object is created and parent object is used as a parameter
		Scene scene = new Scene(root);
		// Stage is set
		primaryStage.setScene(scene);
		// The Stage title is set
		primaryStage.setTitle("MAD LIBS 101");
		// The Stage icon is set to a .png image
		primaryStage.getIcons().add(new Image("MadLibsLogo.png"));
		// The stage is displayed
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
