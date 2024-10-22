/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.viettuts.qlsv.entity;

/**
 *
 * @author admin
 */
public class Classroom {
    private String classId;
    private String className;
    private String subject;
    private String teacher;
    private int numberOfStudents;
    private String schedule;

    // Constructor
    public Classroom(String classId, String className, String subject, String teacher, int numberOfStudents, String schedule) {
        this.classId = classId;
        this.className = className;
        this.subject = subject;
        this.teacher = teacher;
        this.numberOfStudents = numberOfStudents;
        this.schedule = schedule;
    }

    // Getters và Setters
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
