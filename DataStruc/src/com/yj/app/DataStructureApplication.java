package com.yj.app;

import java.util.Scanner;

public class DataStructureApplication {
    final static int LinkedList = 1;
    final static int Stack = 2;
    final static int Queue = 3;
    final static int BinarySearchTree = 4;
    final static int exit = 5;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BinarySearchTreeApplication myBSTApp = new BinarySearchTreeApplication();
        LinkedListApplication linkedListApp = new LinkedListApplication();
        QueueApplication queueApp = new QueueApplication();
        StackApplication stackApp = new StackApplication();
        int option = 0;
        do {
            option = readMenuOption();
            switch (option) {
                case LinkedList:
                    System.out.println("Linked List..");
                    linkedListApp.runApplication();
                    break;
                case Stack:
                    System.out.println("Stack..");
                    stackApp.runApplication();
                    break;
                case Queue:
                    System.out.println("Queue..");
                    queueApp.runApplication();
                    break;
                case BinarySearchTree:
                    System.out.println("Binary Search Tree..");
                    myBSTApp.runBinarySearchTree();
                    break;
                case exit:
                    System.out.println("Thank you, visit again..");
                    break;
            }
        } while (option != exit);
    }

    private static int readMenuOption() {
        System.out.println("\nSelect one Data Structure:  ");
        System.out.println("1 for LinkedList");
        System.out.println("2 for Stack");
        System.out.println("3 for Queue");
        System.out.println("4 for BinarySearchTree");
        System.out.println("5 for Exit");
        System.out.println("Enter Option: ");
        int option = scanner.nextInt();
        return option;
    }
}
