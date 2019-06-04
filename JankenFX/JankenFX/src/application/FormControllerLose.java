package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FormControllerLose {
    @FXML private Button button_Home;




//初期画面に移動する
    @FXML
    public void onHomeClicked() {
    	new Main().changeView("Form.fxml");
    }

}
