package com.yj.utility;

//StudentVector.java
import java.util.Vector;

import com.yj.model.Student;

public class StudentVector {
	private Vector<Student> students;

	public StudentVector() {
		students = new Vector<>();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void deleteStudent(int index) {
		if (index >= 0 && index < students.size()) {
			students.remove(index);
		}
	}

	public void displayAllStudents() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public Student getStudent(int index) {
		if (index >= 0 && index < students.size()) {
			return students.get(index);
		}
		return null;
	}

	public int searchStudentByName(String name) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}

	public Vector<Student> getStudents() {
		return students;
	}
}
