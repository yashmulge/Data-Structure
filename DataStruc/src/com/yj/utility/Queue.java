package com.yj.utility;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    public void printQueue() {
        Node<T> temp = front;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public Node<T> getFront() {
        return front;
    }

    public Node<T> getRear() {
        return rear;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public Node<T> dequeue() {
        if (front == null)
            return null;

        Node<T> temp = front;
        front = front.getNext();

        if (front == null) {
            // If the queue becomes empty after dequeue
            rear = null;
        }

        temp.setNext(null);
        return temp;
    }
}
