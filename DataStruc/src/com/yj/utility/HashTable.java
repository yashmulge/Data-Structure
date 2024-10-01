package com.yj.utility;

import java.util.Scanner;

class HashTable {
	private int size;
	private Node[] table;

	HashTable(int size) {
		this.size = size;
		this.table = new Node[size];
	}

	private int hashFunction(String key) {
		return Math.abs(key.hashCode() % size);
	}

	void add(String key, String value) {
		int index = hashFunction(key);
		if (table[index] == null) {
			table[index] = new Node<String>(key, value);
		} else {
			Node<String> current = table[index];
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new Node<String>(key, value));
		}
	}

	void delete(String key) {
		int index = hashFunction(key);
		Node<String> current = table[index];
		Node<String> prev = null;

		while (current != null && !current.getKey().equals(key)) {
			prev = current;
			current = current.getNext();
		}

		if (current != null) {
			if (prev == null) {
				table[index] = current.getNext();
			} else {
				prev.setNext(current.getNext());
			}
		}
	}

	String search(String key) {
		int index = hashFunction(key);
		Node current = table[index];

		while (current != null) {
			if (current.getKey().equals(key)) {
				return (String) current.getValue();
			}
			current = current.getNext();
		}

		return null;

	}

	void display() {
		for (int i = 0; i < size; i++) {
			Node current = table[i];
			while (current != null) {
				System.out.println("Key: " + current.getKey() + ", Value: " + current.getValue());
				current = current.getNext();
			}
		}
	}
}
