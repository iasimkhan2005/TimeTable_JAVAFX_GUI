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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class EnrollStudentController {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    @FXML
    TextField StudentEnrollmentNO;
    @FXML
    TextField Courseid;
    @FXML
    Button Enroll;
    @FXML
    Button BACK;
    @FXML
    void handleenroll(ActionEvent event){
        String query = "INSERT INTO enrollments (student_enrollment_number, course_id) VALUES (?, ?);";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(query)) {
            if (!StudentEnrollmentNO.getText().matches("\\d+") || !Courseid.getText().matches("\\d+")) {
                // Input is not a valid integer (contains non-digit characters)
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setContentText("Please enter a valid Course id and Course Credits (integer only)!");
                alert.showAndWait();
            }
            else {

                    try {
                        String query1 = "SELECT COUNT(*) AS count FROM students WHERE enrollment_number = ?;";
                        PreparedStatement prmt = connection.prepareStatement(query1);
                        int Enrollment = Integer.parseInt(StudentEnrollmentNO.getText());
                        prmt.setInt(1, Enrollment);
                        ResultSet resultSet1 = prmt.executeQuery();
                        if (resultSet1.next()) {
                            int count = resultSet1.getInt("count");
                            if (count == 0) {
                                throw new SQLException("Student Enrollment Not exist");

                            }

                        }
                        String query2 = "SELECT COUNT(*) AS count FROM courses  WHERE course_id = ?;";
                        PreparedStatement prmt1 = connection.prepareStatement(query2);
                        int id = Integer.parseInt(Courseid.getText());
                        prmt1.setInt(1, id);
                        ResultSet resultSet2 = prmt1.executeQuery();
                        if (resultSet2.next()) {
                            int count = resultSet2.getInt("count");
                            if (count == 0) {
                                throw new SQLException("Course id not found");
                            }

                        }

                        preparedStatement.setInt(1, Enrollment);
                        preparedStatement.setInt(2, id);
                        preparedStatement.executeUpdate();
                        showAlert("Successful", " Enrolled");

                    }
                    catch (InputMismatchException | NumberFormatException e){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Input");
                        alert.setContentText("Please enter a valid value.");
                        alert.showAndWait();

                    }
                    catch (SQLException e) {
                        // Handle SQL exceptions (e.g., enrollment number not found)
                        if (e.getMessage().equals("Student Enrollment Not exist")) {
                            showAlert("Invalid", "Student Enrollment Not exist");
                            StudentEnrollmentNO.clear();
                            StudentEnrollmentNO.requestFocus();
                        } else {
                            // Handle other SQL exceptions (e.g., course ID not found)
                            showAlert("Error", e.getMessage());
                            Courseid.clear();
                            Courseid.requestFocus();

                        }

                    }




            }


        } catch (SQLException e) {
            e.printStackTrace();

        }
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
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
