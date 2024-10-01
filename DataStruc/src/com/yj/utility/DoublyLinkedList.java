package com.yj.utility;

import java.io.*;

public class DoublyLinkedList<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void printList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public Node<T> removeLast() {
        if (head == null)
            return null;
        Node<T> temp = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
            temp.setPrev(null);
        }
        return temp;
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public Node<T> removeFirst() {
        if (head == null)
            return null;
        Node<T> temp = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
            temp.setNext(null);
        }
        return temp;
    }

    public Node<T> get(int index) {
        if (index < 0) {
            return null;
        }
        Node<T> temp = head;
        for (int i = 0; i < index && temp != null; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public boolean set(int index, T value) {
        Node<T> temp = get(index);
        if (temp != null) {
            temp.setValue(value);
            return true;
        }
        return false;
    }

    public boolean insert(int index, T value) {
        if (index < 0)
            return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        Node<T> newNode = new Node<>(value);
        Node<T> before = get(index - 1);
        if (before == null)
            return false;

        Node<T> after = before.getNext();
        newNode.setPrev(before);
        newNode.setNext(after);
        before.setNext(newNode);

        if (after != null) {
            after.setPrev(newNode);
        } else {
            // If inserting at the end of the list
            tail = newNode;
        }

        return true;
    }

    public Node<T> remove(int index) {
        if (index < 0)
            return null;

        if (index == 0)
            return removeFirst();

        Node<T> temp = get(index);

        if (temp == null)
            return null;

        Node<T> prev = temp.getPrev();
        Node<T> next = temp.getNext();

        if (prev != null) {
            prev.setNext(next);
        } else {
            // If removing the first node
            head = next;
        }

        if (next != null) {
            next.setPrev(prev);
        } else {
            // If removing the last node
            tail = prev;
        }

        temp.setPrev(null);
        temp.setNext(null);

        return temp;
    }

    public void reverse() {
        Node<T> temp = head;
        head = tail;
        tail = temp;

        while (temp != null) {
            Node<T> next = temp.getNext();
            temp.setNext(temp.getPrev());
            temp.setPrev(next);
            temp = next;
        }
    }

    public void saveToFile(String dlinkedListFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dlinkedListFile))) {
            oos.writeObject(this);
            System.out.println("Saved to file: " + dlinkedListFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
	public void readFromFile(String dlinkedListFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dlinkedListFile))) {
            Object object = ois.readObject();
            if (object instanceof DoublyLinkedList<?>) {
                DoublyLinkedList<T> loadedList = (DoublyLinkedList<T>) object;
                // Copy the data from the loaded list to the current list
                this.head = loadedList.head;
                this.tail = loadedList.tail;
                System.out.println("Read from file: " + dlinkedListFile);
                loadedList.printList();
            } else {
                System.err.println("Error: Loaded object is not of type DoublyLinkedList");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}