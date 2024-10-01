package com.yj.app;

import java.util.Scanner;
import com.yj.utility.StringArrayList;

public class StringArrayListApplication {

	final static int AddString = 1;
	final static int DeleteString = 2;
	final static int DisplayStrings = 3;
	final static int PrintString = 4;
	final static int SearchString = 5;
	final static int Contains = 6;
	final static int Exit = 7;

	static Scanner scanner = new Scanner(System.in);
	static StringArrayList stringArrayList = new StringArrayList();

	public static void main(String[] args) {
		runStringArrayList();
	}

	public static void runStringArrayList() {
		int option = 0;
		do {
			option = readMenuOption();
			switch (option) {
			case AddString:
				System.out.println("Enter a string to add: ");
				String str = scanner.nextLine();
				stringArrayList.addString(str);
				break;
			case DeleteString:
				System.out.println("Enter the index of the string to delete: ");
				int deleteIndex = scanner.nextInt();
				stringArrayList.deleteString(deleteIndex);
				break;
			case DisplayStrings:
				System.out.println("All strings:");
				stringArrayList.displayStrings();
				break;
			case PrintString:
				System.out.println("Enter the index of the string to print: ");
				int printIndex = scanner.nextInt();
				stringArrayList.printString(printIndex);
				break;
			case SearchString:
				System.out.println("Enter a string to search for: ");
				scanner.nextLine();
				String searchStr = scanner.nextLine();
				int index = stringArrayList.searchString(searchStr);
				if (index != -1) {
					System.out.println("String found at index " + index);
				} else {
					System.out.println("String not found.");
				}
				break;
			case Contains:
				System.out.println("Enter the String to check: ");
				String checkString = scanner.next();
				Boolean contains = stringArrayList.contains(checkString);
				if (contains) {
					System.out.println("The List contains string");
				} else {
					System.out.println("The List does not contain string");
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
		System.out.println("1 for Add a string");
		System.out.println("2 for Delete a string");
		System.out.println("3 for Display all strings");
		System.out.println("4 for Print a string");
		System.out.println("5 for Search for a string");
		System.out.println("6 for check if the list contains a string");
		System.out.println("7 for Exit");
		System.out.print("Enter Option: ");
		int option = scanner.nextInt();
		scanner.nextLine();
		return option;
	}
}
