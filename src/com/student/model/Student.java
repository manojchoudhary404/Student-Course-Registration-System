package com.student.model;

public class Student {

    private int studentId;
    private String name;
    private String course;
    private int marks;

    public Student(int studentId, String name, String course, int marks) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "ID: " + studentId +
               ", Name: " + name +
               ", Course: " + course +
               ", Marks: " + marks;
    }
}