package com.yj.utility;

import java.io.Serializable;

public class Node<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private T value;
	private Node<T> next;
	private T key;

	public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
	public T getValue() {
		return value;
	}
	public Node(T key, T value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }


	public void setValue(T value) {
		this.value = value;
	}

	public Node(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public void setPrev(Node<T> tail) {
		// TODO Auto-generated method stub
		
	}

	public Node<T> getPrev() {
		// TODO Auto-generated method stub
		return null;
	}

}
