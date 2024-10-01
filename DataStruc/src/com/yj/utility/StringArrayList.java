package com.yj.utility;

import java.util.ArrayList;

public class StringArrayList {
	private ArrayList<String> strings;

	public StringArrayList() {
		strings = new ArrayList<>();
	}

	public void addString(String str) {
        if (!strings.contains(str)) {
            strings.add(str);
            System.out.println("String added successfully!");
        } else {
            System.out.println("String already exists in the list.");
        }
    }


	public void deleteString(int index) {
		if (index >= 0 && index < strings.size()) {
			strings.remove(index);
		}
	}

	public void displayStrings() {
		for (String str : strings) {
			System.out.println(str);
		}
	}

	public Boolean contains(String str) {
		 return strings.contains(str);

	}

	public void printString(int index) {
		if (index >= 0 && index < strings.size()) {
			System.out.println("String at index " + index + ": " + strings.get(index));
		} else {
			System.out.println("Invalid index.");
		}
	}

	public int searchString(String str) {
		return strings.indexOf(str);
	}

	public ArrayList<String> getStrings() {
		return strings;
	}
}
