package org.example.assignment_4_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCourseController {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    @FXML
    TextField Name;
    @FXML
    TextField Course_id;
    @FXML
    TextField Course_credits;
    @FXML
    Button AddCourse;
    @FXML
    Button BACK;
    @FXML
    void handleadd(ActionEvent event){
       Course Co =new Course(Course_id,Name,Course_credits);
       Co.handleAddCourse();
    }
    @FXML
    void  handleBack(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) BACK.getScene().getWindow();
            stage.close();

            root =  FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Admin Menu");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {e.printStackTrace();}
    }

}
