import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MadLibsMainMenuController implements Initializable {

    @FXML
    private Button story1;

    @FXML
    private Button story2;

    @FXML
    private Button story3;

    @FXML
    void handleButtonAction(ActionEvent event) {
    	if(event.getSource() == story1) {
    		
    	}else if(event.getSource() == story2) {
    		
    	}else if(event.getSource()== story3) {
    		
    	}
    }

    public void initialize(URL url, ResourceBundle rb) {
    	Circle circle = new Circle(9);
    	PathTransition transition1 = new PathTransition();
    	PathTransition transition2 = new PathTransition();
    	PathTransition transition3 = new PathTransition();
    	
    	transition1.setNode(story1);
    	transition2.setNode(story2);
    	transition3.setNode(story3);
    	
    	transition1.setDuration(Duration.seconds(2));
    	transition2.setDuration(Duration.seconds(2));
    	transition3.setDuration(Duration.seconds(2));

    	transition1.setPath(circle);
    	transition2.setPath(circle);
    	transition3.setPath(circle);
    	
    	transition1.setCycleCount(PathTransition.INDEFINITE);
    	transition2.setCycleCount(PathTransition.INDEFINITE);
    	transition3.setCycleCount(PathTransition.INDEFINITE);
    	
    	transition1.play();
    	transition2.play();
    	transition3.play();
    }
}
