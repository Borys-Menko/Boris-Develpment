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

public class Controller3 {
    @FXML
    private Label exeptionField3;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField answerField3;

    @FXML
    private Button next3;

    @FXML
    void initialize() {

        answerField3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                if (t1.length() > 3){
                    answerField3.setText(s);
                }


                if (!t1.matches("\\d*")) {
                    answerField3.setText(t1.replaceAll("[^\\d{3}]", ""));
                }
            }
        });

        next3.setOnAction(event -> {
            if (answerField3.getCharacters().toString().isEmpty()) {
                return;
            }


            try {
                InputData.cont3 = Integer.parseInt(answerField3.getCharacters().toString());
            }catch (NumberFormatException e){
                e.getMessage();
            }


            if (InputData.cont3 >= 200) {
                exeptionField3.setText("Не вірне значення");
                return;
            } else if (InputData.cont3 <= 0) {
                exeptionField3.setText("Не вірне значення");
                return;
            }


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/stampleFinish.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            Stage stage1 = (Stage) next3.getScene().getWindow();
            stage1.close();
        });

    }
}
