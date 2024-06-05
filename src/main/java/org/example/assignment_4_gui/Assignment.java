package org.example.assignment_4_gui;

public class Assignment {
    private int courseId;
    private int teacherId;
    private int timeSlot;

    public Assignment(int courseId, int teacherId, int timeSlot) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.timeSlot = timeSlot;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getTimeSlot() {
        return timeSlot;
    }
}