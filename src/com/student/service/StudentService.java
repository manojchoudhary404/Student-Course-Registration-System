package com.student.service;

import com.student.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    private List<Student> students = new ArrayList<>();

   
    public void addStudent(Student student) {
        students.add(student);
    }

  
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    
    public void getTopStudents() {
        students.stream()
                .filter(s -> s.getMarks() > 70)
                .forEach(System.out::println);
    }

    public void groupByCourse() {
        Map<String, List<Student>> grouped =
                students.stream().collect(Collectors.groupingBy(Student::getCourse));

        grouped.forEach((course, list) -> {
            System.out.println("\nCourse: " + course);
            list.forEach(System.out::println);
        });
    }

    
    public void sortByMarks() {
        students.stream()
                .sorted((s1, s2) -> s2.getMarks() - s1.getMarks())
                .forEach(System.out::println);
    }
}