package com.yj.app;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTableApplication {
    final static int Add = 1;
    final static int Delete = 2;
    final static int Display = 3;
    final static int Search = 4;
    final static int Exit = 5;

    static Scanner scanner = new Scanner(System.in);
    static Hashtable<String, String> hashTable = new Hashtable<>(10);

    public static void main(String[] args) {
        runHashTable();
    }

    public static void runHashTable() {
        int option = 0;
        do {
            option = readMenuOption();
            switch (option) {
                case Add:
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter value: ");
                    String value = scanner.nextLine();
                    hashTable.put(key, value);
                    System.out.println("Added successfully!");
                    break;
                case Delete:
                    System.out.print("Enter key to delete: ");
                    key = scanner.nextLine();
                    hashTable.remove(key);
                    break;
                case Display:
                    System.out.println("Hashtable:");
                    hashTable.forEach((k, v) -> System.out.println(k + " - " + v));
                    break;
                case Search:
                    System.out.print("Enter key to search: ");
                    key = scanner.nextLine();
                    value = hashTable.get(key);
                    if (value != null) {
                        System.out.println("Value found: " + value);
                    } else {
                        System.out.println("Key not found.");
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
        System.out.println("1 for Add");
        System.out.println("2 for Delete");
        System.out.println("3 for Display");
        System.out.println("4 for Search");
        System.out.println("5 for Exit");
        System.out.print("Enter Option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return option;
    }
}
