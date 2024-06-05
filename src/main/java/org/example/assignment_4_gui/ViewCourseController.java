package org.example.assignment_4_gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ViewCourseController {
    private DatabaseConnection databaseConnection = new DatabaseConnection();


    @FXML
    TextField Enrollment;
    @FXML
    Button View;
    @FXML
    Button BACK;
    @FXML
    TableView<Course> CoursesTableView;

    @FXML
    void handleView(ActionEvent event){
        int EN = Integer.parseInt(Enrollment.getText());
        try (Connection connection = databaseConnection.getConnection();) {
            String query1 = "SELECT COUNT(*) AS count FROM students WHERE enrollment_number = ?;";
            PreparedStatement prmt = connection.prepareStatement(query1);
            prmt.setInt(1, EN);
            ResultSet resultSet1 = prmt.executeQuery();
            if (resultSet1.next()) {
                int count = resultSet1.getInt("count");
                if (count == 0) {
                    throw new SQLException("Student Enrollment Not exist");

                }

            }
        }
        catch (SQLException e) {
            // Handle SQL exceptions (e.g., enrollment number not found)
                showAlert("Invalid", "Student Enrollment Not exist");
                Enrollment.clear();
                Enrollment.requestFocus();

        }
        // Define the columns
        TableColumn<Course, Integer> courseIdColumn = new TableColumn<>("Course ID");
        courseIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Course, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Course, Integer> creditsColumn = new TableColumn<>("Credits");
        creditsColumn.setCellValueFactory(new PropertyValueFactory<>("credits"));

        TableColumn<Course, String> teacherColumn = new TableColumn<>("Teacher");
        teacherColumn.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
// Add the columns to the TableView
        CoursesTableView.getColumns().addAll(courseIdColumn, nameColumn, creditsColumn,teacherColumn);
        ObservableList<Course> courses = CourseDatabase(EN);

        CoursesTableView.setItems(courses);
    }

    private ObservableList<Course> CourseDatabase(int enrollmentNumber) {
        ObservableList<Course> courses = FXCollections.observableArrayList();
        try {


            Connection connection = databaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT c.course_id, c.name, c.credits,t.teacher_name " +
                    "FROM enrollments e " +
                    "JOIN courses c ON e.course_id = c.course_id " +
                    "JOIN assignments a ON c.course_id = a.course_id " +
                    "JOIN teachers t ON a.teacher_id = t.teacher_id " +
                    "WHERE e.student_enrollment_number = " + enrollmentNumber);
            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("name"),
                        rs.getInt("credits")
                );
                course.setTeacherName(rs.getString("teacher_name"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    @FXML
    void  handleBack(ActionEvent event){
        Parent root;
        try {
            Stage stage= (Stage) BACK.getScene().getWindow();
            stage.close();

            root =  FXMLLoader.load(getClass().getResource("StudentMenu.fxml"));
            // root.setOnScroll(this);
            stage = new Stage();
            stage.setTitle("Student Menu");
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
