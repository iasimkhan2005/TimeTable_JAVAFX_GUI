package org.example.assignment_4_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMenuController {
    @FXML
    Button AddTeacher_btn;
    @FXML
    Button AddStudent_btn;
    @FXML
    Button AddCourse_btn;
    @FXML
    Button EnrollStudent_btn;
    @FXML
    Button AssignCourse_btn;
    @FXML
    Button ViewTimeTable_btn;

    //Functions

    //teacher Adding Function
    @FXML
    void handleAddTeacher_btn(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) AddTeacher_btn.getScene().getWindow();
            stage.close();
            root =  FXMLLoader.load(AdminMenuController.class.getResource("AddTeacher.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Add Teacher Menu");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {e.printStackTrace();}
    }

    //student Adding Function
    @FXML
    void handleAddStudent_btn(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) AddStudent_btn.getScene().getWindow();
            stage.close();
            root =  FXMLLoader.load(AdminMenuController.class.getResource("AddStudent.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Add Student Menu");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {e.printStackTrace();}
    }

    //Course Adding Function
    @FXML
    void handleAddCourse_btn(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) AddCourse_btn.getScene().getWindow();
            stage.close();
            root =  FXMLLoader.load(AdminMenuController.class.getResource("AddCourse.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Add Course Menu");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {e.printStackTrace();}
    }
    //Enrolling student to course Function
    @FXML
    void handleEnrollStudent_btn(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) EnrollStudent_btn.getScene().getWindow();
            stage.close();
            root =  FXMLLoader.load(AdminMenuController.class.getResource("EnrollStudent.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Enroll Student Menu");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {e.printStackTrace();}
    }

    //Assigning Course to Teacher
    @FXML
    void handleAssignCourse_btn(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) AssignCourse_btn.getScene().getWindow();
            stage.close();
            root =  FXMLLoader.load(AdminMenuController.class.getResource("AssignCourse.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Assign Course");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {e.printStackTrace();}
    }
}
