package com.yj.app;

import java.util.Scanner;

import com.yj.model.Student;
import com.yj.utility.StudentVector;

public class StudentVectorApplication {

	final static int AddStudent = 1;
	final static int DeleteStudent = 2;
	final static int DisplayAllStudents = 3;
	final static int PrintStudent = 4;
	final static int SearchStudent = 5;
	final static int Exit = 6;

	static Scanner scanner = new Scanner(System.in);
	static StudentVector studentVector = new StudentVector();

	public static void main(String[] args) {
		runStudentVector();
	}

	public static void runStudentVector() {
		int option = 0;
		do {
			option = readMenuOption();
			switch (option) {
			case AddStudent:
				System.out.println("Enter student name: ");
				String name = scanner.nextLine();
				System.out.println("Enter student ID: ");
				int id = scanner.nextInt();
				studentVector.addStudent(new Student(name, id));
				System.out.println("Student added successfully!");
				break;
			case DeleteStudent:
				System.out.println("Enter the index of the student to delete: ");
				int deleteIndex = scanner.nextInt();
				studentVector.deleteStudent(deleteIndex);
				break;
			case DisplayAllStudents:
				System.out.println("All students:");
				studentVector.displayAllStudents();
				break;
			case PrintStudent:
				System.out.println("Enter the index of the student to print: ");
				int printIndex = scanner.nextInt();
				Student student = studentVector.getStudent(printIndex);
				if (student != null) {
					System.out.println("Student at index " + printIndex + ": " + student);
				} else {
					System.out.println("Invalid index.");
				}
				break;
			case SearchStudent:
				System.out.println("Enter student name to search: ");
				scanner.nextLine(); 
				String searchName = scanner.nextLine();
				int index = studentVector.searchStudentByName(searchName);
				if (index != -1) {
					System.out.println("Student found at index " + index + ": " + studentVector.getStudent(index));
				} else {
					System.out.println("Student not found.");
				}
				break;
			case Exit:
				System.out.println("Exiting program...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (option != Exit);

		scanner.close();
	}

	private static int readMenuOption() {
		System.out.println("\nSelect Option:  ");
		System.out.println("1 for Add a student");
		System.out.println("2 for Delete a student");
		System.out.println("3 for Display all students");
		System.out.println("4 for Print a student");
		System.out.println("5 for Search for a student");
		System.out.println("6 for Exit");
		System.out.print("Enter Option: ");
		int option = scanner.nextInt();
		scanner.nextLine(); 
		return option;
	}
}
