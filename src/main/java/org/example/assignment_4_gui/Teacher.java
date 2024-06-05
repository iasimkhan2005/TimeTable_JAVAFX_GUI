package org.example.assignment_4_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teacher {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
   @FXML
    private TextField Id;
   @FXML
    private TextField Name;
   @FXML
    private  TextField Subject;
    private int timeSlot;
//    public Teacher(int id, String name, int timeSlot) {
//        this.id = id;
//        this.name = name;
//    }
    public Teacher (TextField id, TextField name, TextField subject){
        this.Id=id;
        this.Name=name;
        this.Subject=subject;
    }

//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
    public int getTimeSlot() {
        return timeSlot;
    }

    public void handleadd(){
        String query = "INSERT INTO teachers (teacher_id, teacher_name, subject) VALUES (?, ?, ?);";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(query)) {
            if (!Id.getText().matches("\\d+")) {
                // Input is not a valid integer (contains non-digit characters)
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setContentText("Please enter a valid teacher ID (integer only)!");
                alert.showAndWait();
            }
            else {
                int teacher_id = Integer.parseInt(Id.getText());
                preparedStatement.setInt(1,teacher_id);
                String teacher_name = Name.getText();
                String teacher_subject = Subject.getText();

                preparedStatement.setString(2, teacher_name);
                preparedStatement.setString(3, teacher_subject);
                preparedStatement.executeUpdate();
                showAlert("Successful",teacher_name +" Added");
            }


        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
