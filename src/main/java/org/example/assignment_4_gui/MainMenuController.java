package org.example.assignment_4_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    @FXML
    Button Admin_btn;
    @FXML
    Button Student_btn;
    @FXML
    void handleAdminBTN(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) Admin_btn.getScene().getWindow();
            stage.close();
            root =  FXMLLoader.load(MainMenuController.class.getResource("AdminMenu.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Admin Menu");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {e.printStackTrace();}
    }
    @FXML
    void handleStudentBTN(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) Student_btn.getScene().getWindow();
            stage.close();
            root =  FXMLLoader.load(MainMenuController.class.getResource("StudentMenu.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Student Menu");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {e.printStackTrace();}
    }

}
