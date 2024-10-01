package com.yj.utility;

public class BinarySearchTree {

	Node root;

	class Node {
		int value;
		Node left;
		Node right;

		private Node(int value) {
			this.value = value;
		}

	}

	public boolean insert(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return true;
		}
		Node temp = root;
		while (true) {
			if (newNode.value == temp.value)
				return false;
			if (newNode.value < temp.value) {
				if (temp.left == null) {
					temp.left = newNode;
					return true;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					temp.right = newNode;
					return true;
				}
				temp = temp.right;
			}
		}

	}

	public boolean contains(int value) {
		Node temp = root;
		while (temp != null) {
			if (value < temp.value) {
				temp = temp.left;
			} else if (value > temp.value) {
				temp = temp.right;
			} else {
				return true;
			}
		}
		return false;
	}
	public void inOrderTraversal() {
	    inOrderTraversal(root);
	}

	private void inOrderTraversal(Node node) {
	    if (node != null) {
	        inOrderTraversal(node.left);
	        System.out.print(node.value + " ");
	        inOrderTraversal(node.right);
	    }
	}

	public void preOrderTraversal() {
	    preOrderTraversal(root);
	}

	private void preOrderTraversal(Node node) {
	    if (node != null) {
	        System.out.print(node.value + " ");
	        preOrderTraversal(node.left);
	        preOrderTraversal(node.right);
	    }
	}

	public void postOrderTraversal() {
	    postOrderTraversal(root);
	}

	private void postOrderTraversal(Node node) {
	    if (node != null) {
	        postOrderTraversal(node.left);
	        postOrderTraversal(node.right);
	        System.out.print(node.value + " ");
	    }
	}

}
