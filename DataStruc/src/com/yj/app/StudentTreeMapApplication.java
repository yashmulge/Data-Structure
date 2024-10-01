package com.yj.app;

import com.yj.model.Student;
import com.yj.utility.StudentTreeMap;

import java.util.Scanner;

public class StudentTreeMapApplication {
	private static final int ADD_STUDENT = 1;
	private static final int DELETE_STUDENT = 2;
	private static final int DISPLAY_ALL_STUDENTS = 3;
	private static final int GET_STUDENT = 4;
	private static final int CONTAINS_STUDENT = 5;
	private static final int SIZE = 6;
	private static final int EXIT = 7;

	private static Scanner scanner = new Scanner(System.in);
	private static StudentTreeMap studentTreeMap = new StudentTreeMap();

	public static void main(String[] args) {
		runStudentTreeMap();
	}

	public static void runStudentTreeMap() {
		int option = 0;
		do {
			option = readMenuOption();
			switch (option) {
			case ADD_STUDENT:
				System.out.println("Enter student name: ");
				String name = scanner.nextLine();
				System.out.println("Enter student ID: ");
				int id = scanner.nextInt();
				scanner.nextLine(); 
				studentTreeMap.addStudent(new Student(name, id));
				System.out.println("Student added successfully!");
				break;
			case DELETE_STUDENT:
				System.out.println("Enter student ID to delete: ");
				int deleteId = scanner.nextInt();
				scanner.nextLine(); 
				studentTreeMap.deleteStudent(deleteId);
				break;
			case DISPLAY_ALL_STUDENTS:
				System.out.println("All students:");
				studentTreeMap.displayAllStudents();
				break;
			case GET_STUDENT:
				System.out.println("Enter student ID to get: ");
				int getId = scanner.nextInt();
				scanner.nextLine(); 
				Student getStudent = studentTreeMap.getStudent(getId);
				if (getStudent != null) {
					System.out.println("Student details: " + getStudent);
				} else {
					System.out.println("Student not found.");
				}
				break;
			case CONTAINS_STUDENT:
				System.out.println("Enter student ID to check: ");
				int containsId = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				boolean contains = studentTreeMap.containsStudent(containsId);
				if (contains) {
					System.out.println("Student exists in the map.");
				} else {
					System.out.println("Student does not exist in the map.");
				}
				break;
			case SIZE:
				System.out.println("Number of students: " + studentTreeMap.size());
				break;
			case EXIT:
				System.out.println("Exiting program...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (option != EXIT);

		scanner.close();
	}

	private static int readMenuOption() {
		System.out.println("\nSelect Option:");
		System.out.println("1. Add a student");
		System.out.println("2. Delete a student");
		System.out.println("3. Display all students");
		System.out.println("4. Get student details");
		System.out.println("5. Check if student exists");
		System.out.println("6. Get number of students");
		System.out.println("7. Exit");
		System.out.print("Enter Option: ");
		int option = scanner.nextInt();
		scanner.nextLine();
		return option;
	}
}
