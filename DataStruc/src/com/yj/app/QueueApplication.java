package com.yj.app;

import java.util.Scanner;
import com.yj.utility.Queue;

public class QueueApplication {
    final static int Printlist = 1;
    final static int Enqueue = 2;
    final static int Dequeue = 3;
    final static int exit = 4;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runApplication();
    }

    public static void runApplication() {
        Queue<Integer> queue = new Queue<Integer>();
        int option = 0;
        do {
            option = readMenuOption();
            switch (option) {
                case Printlist:
                    System.out.println("Queue is printing...");
                    queue.printQueue();
                    break;
                case Enqueue:
                    System.out.println("Enter value to Enqueue...");
                    int data = scanner.nextInt();
                    queue.enqueue(data);
                    break;
                case Dequeue:
                    System.out.println("Dequeue complete...");
                    queue.dequeue();
                    break;
                case exit:
                    System.out.println("Exited  !!!    Thankyou...");
                    System.exit(0);
            }
        } while (4 != option);
    }

    private static int readMenuOption() {
        System.out.println("\nSelect Option:  ");
        System.out.println("1 for PrintQueue");
        System.out.println("2 for Enqueue");
        System.out.println("3 for Dequeue");
        System.out.println("4 for Exit");
        System.out.println("Enter Option");
        int option = scanner.nextInt();
        return option;
    }
}
