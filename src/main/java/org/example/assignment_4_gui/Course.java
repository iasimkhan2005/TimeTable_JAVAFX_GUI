package org.example.assignment_4_gui;


import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Course {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private TextField id;
    private TextField Name;
    private TextField Credits;
    //these Variables are for view Courses in Student Menu
    private int ID;
    private String NAME;
    private int CREDITS;


    private String teacherName;

    public Course(TextField id, TextField name, TextField credits)  {
        this.id = id;
        this.Name = name;
        this.Credits = credits;
    }

    public Course(int ID, String NAME, int CREDITS)  {
        this.ID = ID;
        this.NAME = NAME;
        this.CREDITS = CREDITS;
    }

    public int getId() {
        int Id = Integer.parseInt(id.getText());
        return Id;
    }

    public String getName() {
        String name = Name.getText();
        return name;

    }

    public int getCredits() {
        int Course_Credits = Integer.parseInt(Credits.getText());
        return Course_Credits;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void handleAddCourse() {
        String query = "INSERT INTO courses (course_id, name, credits) VALUES (?, ?, ?);";
        try(
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(query))

        {
            if (!id.getText().matches("\\d+") || !Credits.getText().matches("\\d+")) {
                // Input is not a valid integer (contains non-digit characters)
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setContentText("Please enter a valid Course id and Course Credits (integer only)!");
                alert.showAndWait();
            } else {
                int Course_id = Integer.parseInt(id.getText());
                preparedStatement.setInt(1, Course_id);
                String CourseName = Name.getText();
                int Course_credit = Integer.parseInt(Credits.getText());


                preparedStatement.setString(2, CourseName);
                preparedStatement.setInt(3, Course_credit);
                preparedStatement.executeUpdate();
                showAlert("Successful", CourseName + " Added");
            }


        }
        catch(
                SQLException e)

        {
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
