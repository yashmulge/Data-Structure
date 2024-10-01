package com.yj.app;

import com.yj.utility.StringTreeMap;

import java.util.Scanner;

public class StringTreeMapApplication {
	private static final int ADD_STRING = 1;
	private static final int DELETE_STRING = 2;
	private static final int DISPLAY_ALL_STRINGS = 3;
	private static final int GET_STRING = 4;
	private static final int CONTAINS_STRING = 5;
	private static final int SIZE = 6;
	private static final int EXIT = 7;

	private static Scanner scanner = new Scanner(System.in);
	private static StringTreeMap stringTreeMap = new StringTreeMap();

	public static void main(String[] args) {
		runStringTreeMap();
	}

	public static void runStringTreeMap() {
		int option = 0;
		do {
			option = readMenuOption();
			switch (option) {
			case ADD_STRING:
				System.out.println("Enter key: ");
				String key = scanner.nextLine();
				System.out.println("Enter value: ");
				String value = scanner.nextLine();
				stringTreeMap.addString(key, value);
				System.out.println("String added successfully!");
				break;
			case DELETE_STRING:
				System.out.println("Enter key to delete: ");
				String deleteKey = scanner.nextLine();
				stringTreeMap.deleteString(deleteKey);
				break;
			case DISPLAY_ALL_STRINGS:
				System.out.println("All strings:");
				stringTreeMap.displayAllStrings();
				break;
			case GET_STRING:
				System.out.println("Enter key to get value: ");
				String getKey = scanner.nextLine();
				String getString = stringTreeMap.getString(getKey);
				if (getString != null) {
					System.out.println("Value: " + getString);
				} else {
					System.out.println("String not found.");
				}
				break;
			case CONTAINS_STRING:
				System.out.println("Enter key to check: ");
				String containsKey = scanner.nextLine();
				boolean contains = stringTreeMap.containsString(containsKey);
				if (contains) {
					System.out.println("String exists in the map.");
				} else {
					System.out.println("String does not exist in the map.");
				}
				break;
			case SIZE:
				System.out.println("Number of strings: " + stringTreeMap.size());
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
		System.out.println("1. Add a string");
		System.out.println("2. Delete a string");
		System.out.println("3. Display all strings");
		System.out.println("4. Get value for a key");
		System.out.println("5. Check if key exists");
		System.out.println("6. Get number of strings");
		System.out.println("7. Exit");
		System.out.print("Enter Option: ");
		int option = scanner.nextInt();
		scanner.nextLine(); 
		return option;
	}
}
