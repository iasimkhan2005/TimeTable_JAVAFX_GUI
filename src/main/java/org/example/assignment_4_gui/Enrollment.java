package org.example.assignment_4_gui;

public class Enrollment {
    private int studentId;
    private int courseId;
    private int timeSlot;

    public Enrollment(int studentId, int courseId, int timeSlot) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.timeSlot = timeSlot;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getTimeSlot() {
        return timeSlot;
    }
}