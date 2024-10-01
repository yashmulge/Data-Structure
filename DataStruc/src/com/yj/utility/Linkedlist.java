package com.yj.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Linkedlist<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Node<T> head;


	/**
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}

	public void printList() {
		Node<T> temp = getHead();
		while (temp != null) {
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}
	}

	public void prepend(T value) {
		Node<T> newNode = new Node<>(value);
		if (getHead() == null) {
			setHead(newNode);
		} else {
			newNode.setNext(getHead());
			setHead(newNode);
		}
	}

	public void append(T value) {
		Node<T> newNode = new Node<>(value);
		if (getHead() == null) {
			setHead(newNode);
			return;
		} else {
			Node<T> temp = getHead();
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
	}

	public Node<T> removeLast() {
		if (getHead() == null)
			return null;

		Node<T> temp = getHead();
		Node<T> prev = null;

		while (temp.getNext() != null) {
			prev = temp;
			temp = temp.getNext();
		}

		if (prev == null) {
			// If there is only one node in the list
			setHead(null);
		} else {
			prev.setNext(null);
		}

		return temp;
	}

	public Node<T> removeFirst() {
		if (getHead() == null)
			return null;
		Node<T> temp = getHead();
		setHead(getHead().getNext());
		temp.setNext(null);
		return temp;
	}

	public Node<T> get(int index) {
		if (index < 0)
			return null;
		Node<T> temp = getHead();
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
		Node<T> temp = get(index - 1);
		if (temp == null)
			return false;
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
		return true;
	}

	public Node<T> remove(int index) {
		if (index < 0)
			return null;
		if (index == 0)
			return removeFirst();
		Node<T> prev = get(index - 1);
		if (prev == null || prev.getNext() == null)
			return null;
		Node<T> temp = prev.getNext();
		prev.setNext(temp.getNext());
		temp.setNext(null);
		return temp;
	}

	public void reverse() {
		Node<T> prev = null;
		Node<T> current = getHead();
		Node<T> next = null;

		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		setHead(prev);
	}

	public void saveToFile(String linkedListFile) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(linkedListFile))) {
			oos.writeObject(this);
			System.out.println("Saved to file: " + linkedListFile);
		} catch (IOException e) {
			System.out.println("An error occurred while saving to file: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void readFromFile(String linkedListFile) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(linkedListFile))) {
			Linkedlist<T> loadedList = (Linkedlist<T>) ois.readObject();
			this.setHead(loadedList.getHead());
			System.out.println("Read from file: " + linkedListFile);

			// Print the contents of the loaded list
			loadedList.printList();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("An error occurred while reading: " + e.getMessage());
		}
	}


}
