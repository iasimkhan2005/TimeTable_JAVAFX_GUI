package org.example.assignment_4_gui;

import java.util.ArrayList;
import java.util.List;

public class TimeSlot {
    private Course course;
    private Teacher teacher;
    private List<Student> students;

    public TimeSlot() {
        students = new ArrayList<>();
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Course getCourse() {
        return course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}
