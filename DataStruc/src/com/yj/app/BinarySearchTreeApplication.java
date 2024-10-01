package com.yj.app;

import java.util.Scanner;

import com.yj.utility.BinarySearchTree;

public class BinarySearchTreeApplication {

    final static int Insert = 1;
    final static int Contains = 2;
    final static int Inorder = 3;
    final static int Preorder = 4;
    final static int Postorder = 5;
    final static int exit = 6;
    static Scanner scanner = new Scanner(System.in);
    static BinarySearchTree myBST = new BinarySearchTree(); // Declare myBST as a class-level variable

    public static void main(String[] args) {
        runBinarySearchTree();
    }

    public static void runBinarySearchTree() {
        int option = 0;
        do {
            option = readMenuOption();
            switch (option) {
                case Insert:
                    System.out.println("Enter the value to insert...");
                    int data = scanner.nextInt();
                    myBST.insert(data);
                    break;
                case Contains:
                    System.out.println("Enter value to check...");
                    data = scanner.nextInt();
                    System.out.println(myBST.contains(data));
                    break;
                case Inorder:
                    System.out.println("Tree InOrder..");
                    myBST.inOrderTraversal();
                    break;
                case Preorder:
                    System.out.println("Tree PreOrder..");
                    myBST.preOrderTraversal();
                    break;
                case Postorder:
                    System.out.println("Tree PostOrder..");
                    myBST.postOrderTraversal();
                    break;
                case exit:
                    System.out.println("Exited  !!!    Thank you...");
                    System.exit(0);
            }
        } while (option != exit);
    }

    private static int readMenuOption() {
        System.out.println("\nSelect Option:  ");
        System.out.println("1 for Insert");
        System.out.println("2 for Check For value");
        System.out.println("3 for Tree InOrder");
        System.out.println("4 for Tree PreOrder");
        System.out.println("5 for Tree PostOrder");
        System.out.println("6 for Exit");
        System.out.println("Enter Option");
        int option = scanner.nextInt();
        return option;
    }
}
