package com.student.app;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.exception.InvalidMarksException;

import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n1 Add Student");
            System.out.println("2 View All Students");
            System.out.println("3 Students with Marks > 70");
            System.out.println("4 Group Students by Course");
            System.out.println("5 Sort Students by Marks");
            System.out.println("6 Exit");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();

                        if (marks < 0 || marks > 100) {
                            throw new InvalidMarksException("Marks must be between 0 and 100");
                        }

                        service.addStudent(new Student(id, name, course, marks));
                        System.out.println("Student Added Successfully!");
                        break;

                    case 2:
                        service.viewAllStudents();
                        break;

                    case 3:
                        service.getTopStudents();
                        break;

                    case 4:
                        service.groupByCourse();
                        break;

                    case 5:
                        service.sortByMarks();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (InvalidMarksException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid Input! Please try again.");
                sc.nextLine();
                sc.close();
            }
        }
    }
}