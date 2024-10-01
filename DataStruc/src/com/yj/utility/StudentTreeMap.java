package com.yj.utility;

import java.util.TreeMap;

import com.yj.model.Student;

public class StudentTreeMap {
    private TreeMap<Integer, Student> studentMap;

    public StudentTreeMap() {
        studentMap = new TreeMap<>();
    }

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void deleteStudent(int id) {
        studentMap.remove(id);
    }

    public void displayAllStudents() {
        studentMap.forEach((id, student) -> System.out.println("ID: " + id + ", " + student));
    }

    public Student getStudent(int id) {
        return studentMap.get(id);
    }

    public boolean containsStudent(int id) {
        return studentMap.containsKey(id);
    }

    public int size() {
        return studentMap.size();
    }
}
