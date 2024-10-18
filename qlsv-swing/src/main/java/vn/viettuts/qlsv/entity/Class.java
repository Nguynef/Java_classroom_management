package vn.viettuts.qlsv.entity;

import java.util.List;
import java.time.LocalDateTime;

public class Class {
    private String className;
    private int studentCount;
    private String course;
    private Room assignedRoom;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Student> student;

    // Constructor
    public Class(String className, int studentCount, String course, Room assignedRoom, LocalDateTime startTime, LocalDateTime endTime, Student student) {
        this.className = className;
        this.studentCount = studentCount;
        this.course = course;
        this.assignedRoom = assignedRoom;
        this.startTime = startTime;
        this.endTime = endTime;
        this.student = (List<Student>) student;
    }

    // Getters and setters
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Room getAssignedRoom() {
        return assignedRoom;
    }

    public void setAssignedRoom(Room assignedRoom) {
        this.assignedRoom = assignedRoom;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
