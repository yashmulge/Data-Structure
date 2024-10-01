package com.yj.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

import com.yj.model.Student;

public class StudentHashtable {
	private Hashtable<Integer, Student> students;

	public StudentHashtable() {
		students = new Hashtable<>();
	}

	public void addStudent(Student student) {
		students.put(student.getId(), student);
	}

	public void deleteStudent(int id) {
		students.remove(id);
	}

	public void displayAllStudents() {
		students.forEach((id, student) -> System.out.println("ID: " + id + ", " + student));
	}

	public Student getStudent(int id) {
		return students.get(id);
	}

	public boolean containsStudent(int id) {
		return students.containsKey(id);
	}

	public int size() {
		return students.size();
	}
	 public List<Student> getSortedStudents() {
	        List<Student> sortedStudents = new ArrayList<>(students.values());
	        Collections.sort(sortedStudents, Comparator.comparing(Student::getId));
	        return sortedStudents;
	    }
}
