import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class MadLibsMainMenuController {

    @FXML
    private AnchorPane circle1;

    @FXML
    private Button story1;

    @FXML
    private Button story2;

    @FXML
    private Button story3;

    @FXML
    private Circle circle2;

    @FXML
    void handleButtonAction(ActionEvent event) {
    	if(event.getSource() == story1) {
    		
    	}else if(event.getSource() == story2) {
    		
    	}else if(event.getSource()== story3) {
    		
    	}
    }

}
