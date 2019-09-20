package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Label exeptionField;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField answerField1;

    @FXML
    private Button next1;

    @FXML
    void initialize() {

        answerField1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                if (t1.length() > 3){
                    answerField1.setText(s);
                }

                if (!t1.matches("\\d*")) {
                    answerField1.setText(t1.replaceAll("[^\\d]", ""));

                }
            }
        });


        next1.setOnAction(event -> {
            if (answerField1.getCharacters().toString().isEmpty()) {
                return;
            }
            try {
                InputData.cont1 = Integer.parseInt(answerField1.getCharacters().toString());
            } catch (NumberFormatException e) {
                e.getMessage();

            }



            if (InputData.cont1 >= 200) {
                exeptionField.setText("Не вірне значення");
                return;
            } else if (InputData.cont1 <= 0) {
                exeptionField.setText("Не вірне значення");
                return;
            }


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample2.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            Stage stage1 = (Stage) next1.getScene().getWindow();
            stage1.close();
        });


    }

}
