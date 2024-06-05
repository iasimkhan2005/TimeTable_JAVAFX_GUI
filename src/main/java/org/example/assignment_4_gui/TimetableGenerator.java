//package org.example.assignment_4_gui;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TimetableGenerator {
//    private Connection conn;
//
//    public TimetableGenerator(Connection conn) {
//        this.conn = conn;
//    }
//
//    public Timetable generateTimetable() {
//        // Retrieve data from database
//        List<Student> students = retrieveStudentsFromDatabase();
//        List<Teacher> teachers = retrieveTeachersFromDatabase();
//        List<Course> courses = retrieveCoursesFromDatabase();
//        List<Assignment> assignments = retrieveAssignmentsFromDatabase();
//        List<Enrollment> enrollments = retrieveEnrollmentsFromDatabase();
//
//        // Create timetable structure
//        Timetable timetable = new Timetable();
//        for (int i = 0; i < 5; i++) { // 5 time slots
//            timetable.addTimeSlot(new TimeSlot());
//        }
//
//        // Assign courses to time slots
//        for (Assignment assignment : assignments) {
//            Course course = findCourse(courses, assignment.getCourseId());
//            Teacher teacher = findTeacher(teachers, assignment.getTeacherId());
//            TimeSlot timeSlot = timetable.getTimeSlot(assignment.getTimeSlot());
//            timeSlot.setCourse(course);
//            timeSlot.setTeacher(teacher);
//        }
//
//        // Assign teachers to time slots
//        for (Teacher teacher : teachers) {
//            TimeSlot timeSlot = timetable.getTimeSlot(teacher.getTimeSlot());
//            timeSlot.setTeacher(teacher);
//        }
//
//        // Assign students to time slots
//        for (Enrollment enrollment : enrollments) {
//            Student student = findStudent(students, enrollment.getStudentId());
//            Course course = findCourse(courses, enrollment.getCourseId());
//            TimeSlot timeSlot = timetable.getTimeSlot(enrollment.getTimeSlot());
//            timeSlot.addStudent(student);
//        }
//
//        return timetable;
//    }
//
//    private List<Student> retrieveStudentsFromDatabase() {
//        List<Student> students = new ArrayList<>();
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
//            while (rs.next()) {
//                Student student = new Student(rs.getInt("id"), rs.getString("name"));
//                students.add(student);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return students;
//    }
//
//    private List<Teacher> retrieveTeachersFromDatabase() {
//        List<Teacher> teachers = new ArrayList<>();
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM teachers");
//            while (rs.next()) {
//                Teacher teacher = new Teacher(rs.getInt("id"), rs.getString("name"));
//                teachers.add(teacher);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return teachers;
//    }
//
//    private List<Course> retrieveCoursesFromDatabase() {
//        List<Course> courses = new ArrayList<>();
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM courses");
//            while (rs.next()) {
//                Course course = new Course(rs.getInt("id"), rs.getString("name"));
//                courses.add(course);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return courses;
//    }
//
//    private List<Assignment> retrieveAssignmentsFromDatabase() {
//        List<Assignment> assignments = new ArrayList<>();
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM assignments");
//            while (rs.next()) {
//                Assignment assignment = new Assignment(rs.getInt("course_id"), rs.getInt("teacher_id"), rs.getInt("time_slot"));
//                assignments.add(assignment);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return assignments;
//    }
//
//    private List<Enrollment> retrieveEnrollmentsFromDatabase() {
//        List<Enrollment> enrollments = new ArrayList<>();
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM enrollments");
//            while (rs.next()) {
//                Enrollment enrollment = new Enrollment(rs.getInt("student_id"), rs.getInt("course_id"), rs.getInt("time_slot"));
//                enrollments.add(enrollment);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return enrollments;
//    }
//
//    private Course findCourse(List<Course> courses, int courseId) {
//        for (Course course : courses) {
//            if (course.getId() == courseId) {
//                return course;
//            }
//        }
//        return null;
//    }
//
//    private Teacher findTeacher(List<Teacher> teachers, int teacherId) {
//        for (Teacher teacher : teachers) {
//            if (teacher.getId() == teacherId) {
//                return teacher;
//            }
//        }
//        return null;
//    }
//
//    private Student findStudent(List<Student> students, int studentId) {
//        for (Student student : students) {
//            if (student.getId() == studentId) {
//                return student;
//            }
//        }
//        return null;
//    }
//}