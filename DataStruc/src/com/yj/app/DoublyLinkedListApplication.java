package com.yj.app;

import java.util.Scanner;
import com.yj.utility.DoublyLinkedList;

public class DoublyLinkedListApplication {
    final static int Printlist = 1;
    final static int Append = 2;
    final static int Prepend = 3;
    final static int RemoveFirst = 5;
    final static int RemoveLast = 6;
    final static int InsertToIndex = 7;
    final static int SaveToFile = 8;
    final static int ReadFromFile = 9;
    final static int exit = 10;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runApplication();
    }

    public static void runApplication() {
        DoublyLinkedList<Integer> DLL = new DoublyLinkedList<>();
        DLL.readFromFile("dlinkedListFile.dat");

        int option = 0;
        do {
            option = readMenuOption();
            switch (option) {
                case Printlist:
                    System.out.println("linked list printing...");
                    DLL.printList();
                    break;
                case Append:
                    System.out.println("Enter value to insert...");
                    int data = scanner.nextInt();
                    DLL.append(data);
                    break;
                case Prepend:
                    System.out.println("Enter value to add at first...");
                    data = scanner.nextInt();
                    DLL.prepend(data);
                    break;
                case RemoveFirst:
                    System.out.println("LinkedList after first removal...");
                    DLL.removeFirst();
                    break;
                case RemoveLast:
                    System.out.println("LinkedList after last removal...");
                    DLL.removeLast();
                    break;
                case InsertToIndex:
                    System.out.println("Enter Index");
                    int index = scanner.nextInt();
                    System.out.println("Enter value");
                    data = scanner.nextInt();
                    DLL.insert(index, data);
                    break;
                case SaveToFile:
                    System.out.println("Saved to file..");
                    DLL.saveToFile("dlinkedListFile.dat");
                    break;
                case ReadFromFile:
                    System.out.println("Reading from file..");
                    DLL.readFromFile("dlinkedListFile.dat");
                    break;
                case exit:
                    System.out.println("Exited  !!!    Thank you...");
                    System.exit(0);
            }
        } while (10 != option);
    }

    private static int readMenuOption() {
        System.out.println("\nSelect Option:  ");
        System.out.println("1 for Printlist");
        System.out.println("2 for Append");
        System.out.println("3 for Prepend");
        System.out.println("5 for RemoveFirstElement");
        System.out.println("6 for RemoveLastElement");
        System.out.println("7 for InsertToIndex");
        System.out.println("8 for SaveToFile");
        System.out.println("9 for ReadFromFile");
        System.out.println("10 for Exit");
        System.out.println("Enter Option");
        int option = scanner.nextInt();
        return option;
    }
}
