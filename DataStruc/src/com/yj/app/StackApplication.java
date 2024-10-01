package com.yj.app;

import java.util.Scanner;
import com.yj.utility.Stack;

public class StackApplication {
    final static int PrintStack = 1;
    final static int Push = 2;
    final static int Pop = 3;
    final static int exit = 4;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runApplication();
    }

    public static void runApplication() {
        Stack<Integer> stack = new Stack<Integer>();

        int option = 0;
        do {
            option = readMenuOption();
            switch (option) {
                case PrintStack:
                    System.out.println("Stack is printing...");
                    stack.printStack();
                    break;
                case Push:
                    System.out.println("Enter value to push...");
                    int data = scanner.nextInt();
                    stack.push(data);
                    break;
                case Pop:
                    System.out.println("Pop complete...");
                    stack.pop();
                    break;
                case exit:
                    System.out.println("Exited  !!!    Thankyou...");
                    System.exit(0);
            }
        } while (4 != option);
    }

    private static int readMenuOption() {
        System.out.println("\nSelect Option:  ");
        System.out.println("1 for PrintStack");
        System.out.println("2 for Push");
        System.out.println("3 for Pop");
        System.out.println("4 for Exit");
        System.out.println("Enter Option");
        int option = scanner.nextInt();
        return option;
    }
}
