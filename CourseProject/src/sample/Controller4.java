package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Controller4 {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button finish;

    @FXML
    private Label textResult;

    @FXML
    void initialize() {

        textResult.setText(InputData.massege() + "\t\n" + InputData.calculate());

        finish.setOnAction(event -> {
            finish.getScene().getWindow().hide();


        });

    }
}
