package org.example.assignment_4_gui;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private TextField enrollment_id;
    private TextField Name;
    private TextField Section;

//    public Student(int id, String name) {
//        this.enrollment_id = id;
//        this.Name = name;
//    }

    public Student(TextField enrollment_id,TextField Name, TextField Section){

        this.enrollment_id =enrollment_id;
        this.Name= Name;
        this.Section= Section;
    }
//public int getId() {
//    return enrollment_id;
//}
//
//public String getName() {
//    return Name;
//}

    public void handleAddStudent()
    {
        String query = "INSERT INTO students (enrollment_number, name, section) VALUES (?, ?, ?);";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(query)) {
            if (!enrollment_id.getText().matches("\\d+")) {
                // Input is not a valid integer (contains non-digit characters)
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setContentText("Please enter a valid teacher ID (integer only)!");
                alert.showAndWait();
            }
            else {
                int teacher_id = Integer.parseInt(enrollment_id.getText());
                preparedStatement.setInt(1,teacher_id);
                String Student_name = Name.getText();
                String Student_section = Section.getText();




                preparedStatement.setString(2, Student_name);
                preparedStatement.setString(3, Student_section);
                preparedStatement.executeUpdate();
                showAlert("Successful",Student_name +" Added");
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

