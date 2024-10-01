package com.yj.utility;

public class Stack<T> {
	private Node<T> top;

	public void printStack() {
		Node<T> temp = top;
		while (temp != null) {
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}
	}

	public Node<T> getTop() {
		return top;
	}

	public void push(T value) {
		Node<T> newNode = new Node<>(value);
		newNode.setNext(top);
		top = newNode;
	}

	public Node<T> pop() {
		if (top == null)
			return null;

		Node<T> temp = top;
		top = top.getNext();
		temp.setNext(null);
		return temp;
	}
}
