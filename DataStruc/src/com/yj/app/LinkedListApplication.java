package com.yj.app;

import java.util.Scanner;
import com.yj.utility.Linkedlist;

public class LinkedListApplication {
    final static int Printlist = 1;
    final static int Append = 2;
    final static int Prepend = 3;
    final static int Reverse = 4;
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
        Linkedlist<String> linkedList = new Linkedlist<String>();
        linkedList.readFromFile("linkedListFile.dat");

        int option = 0;
        do {
            option = readMenuOption();
            switch (option) {
                case Printlist:
                    System.out.println("linked list printing...");
                    linkedList.printList();
                    break;
                case Append:
                    System.out.println("Enter value to insert...");
                    String data = scanner.next();
                    linkedList.append(data);
                    break;
                case Prepend:
                    System.out.println("Enter value to add at first...");
                    data = scanner.next();
                    linkedList.prepend(data);
                    break;
                case Reverse:
                    System.out.println("LinkedList Reversed...");
                    linkedList.reverse();
                    linkedList.printList();
                    break;
                case RemoveFirst:
                    System.out.println("LinkedList after first removal...");
                    linkedList.removeFirst();
                    break;
                case RemoveLast:
                    System.out.println("LinkedList after last removal...");
                    linkedList.removeLast();
                    break;
                case InsertToIndex:
                    System.out.println("Enter Index");
                    int index = scanner.nextInt();
                    System.out.println("Enter value");
                    data = scanner.next();
                    linkedList.insert(index, data);
                    break;
                case SaveToFile:
                    System.out.println("Saved to file..");
                    linkedList.saveToFile("linkedListFile.dat");
                    break;
                case ReadFromFile:
                    System.out.println("Reading from file..");
                    linkedList.readFromFile("linkedListFile.dat");
                    break;
                case exit:
                    System.out.println("Exited  !!!    Thankyou...");
                    System.exit(0);
            }
        } while (10 != option);
    }

    private static int readMenuOption() {
        System.out.println("\nSelect Option:  ");
        System.out.println("1 for Printlist");
        System.out.println("2 for Append");
        System.out.println("3 for Prepend");
        System.out.println("4 for reverse");
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
