package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller2 {
    @FXML
    private Label exeptionField2;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField answerField2;

    @FXML
    private Button next2;

    @FXML
    void initialize() {

        answerField2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (t1.length() > 3){
                    answerField2.setText(s);
                }


                if (!t1.matches("\\d*")) {
                    answerField2.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        next2.setOnAction(event -> {

            if (answerField2.getCharacters().toString().isEmpty()) {
                return;
            }


            try {
                InputData.cont2 = Integer.parseInt(answerField2.getCharacters().toString());
            } catch (NumberFormatException e) {
                e.getMessage();
            }


            if (InputData.cont2 >= 200) {
                exeptionField2.setText("Не вірне значення");
                return;
            } else if (InputData.cont2 <= 0) {
                exeptionField2.setText("Не вірне значення");
                return;
            }


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample3.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            Stage stage1 = (Stage) next2.getScene().getWindow();
            stage1.close();
        });

    }
}

