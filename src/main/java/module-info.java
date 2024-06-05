module org.example.assignment_4_gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens org.example.assignment_4_gui to javafx.fxml;
    exports org.example.assignment_4_gui;
}