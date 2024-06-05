package org.example.assignment_4_gui;

import java.util.ArrayList;
import java.util.List;

public class Timetable {
    private List<TimeSlot> timeSlots;

    public Timetable() {
        timeSlots = new ArrayList<>();
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        timeSlots.add(timeSlot);
    }

    public TimeSlot getTimeSlot(int index) {
        return timeSlots.get(index);
    }
}