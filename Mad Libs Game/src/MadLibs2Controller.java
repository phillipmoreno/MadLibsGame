import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    }

}
