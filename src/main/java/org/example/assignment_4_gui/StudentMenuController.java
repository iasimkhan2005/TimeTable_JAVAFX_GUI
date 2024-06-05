package org.example.assignment_4_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentMenuController {
    @FXML
    Button ViewCourse;
    @FXML
    Button ViewTimeTable;

    @FXML
    void handleView(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) ViewCourse.getScene().getWindow();
            stage.close();
            root =  FXMLLoader.load(StudentMenuController.class.getResource("ViewCourse.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Add Teacher Menu");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {e.printStackTrace();}

    }

//    @FXML
//    void handleViewTimeTable(ActionEvent event){
//        Parent root;
//        try {
//            Stage stage= (Stage) ViewTimeTable.getScene().getWindow();
//            stage.close();
//            root =  FXMLLoader.load(AdminMenuController.class.getResource("ViewCourse.fxml"));
//            // root.setOnScroll(this);
//            stage = new Stage();
//            stage.setTitle("Add Teacher Menu");
//            stage.setScene(new Scene(root));
//            stage.show();
//
//        } catch (IOException e) {e.printStackTrace();}
//
//    }
}
