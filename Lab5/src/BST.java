
/**
* BST.java
* @author Naqib Khan
* @author Pratik Bhandari
* CIS 22C Lab 5
*/

import java.util.NoSuchElementException;
import java.util.Comparator;

public class BST<T extends Comparable<T>> {
	private class Node {
		private T data;
		private Node left;
		private Node right;

		public Node(T data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	private Node root;

	/*** CONSTRUCTORS ***/

	/**
	 * Default constructor for BST sets root to null
	 */
	public BST() {
		root = null;
	}

	/**
	 * Copy constructor for BST
	 * 
	 * @param bst the BST of which to make a copy.
	 * @param c   the way the tree is organized
	 */
	public BST(BST<T> bst, Comparator<T> c) {
		// fill in here
	}

	/**
	 * Helper method for copy constructor
	 * 
	 * @param node the node containing data to copy
	 * @param c    the way the tree is organized
	 */
	private void copyHelper(Node node, Comparator<T> c) {
		// fill in here
	}

	/*** ACCESSORS ***/

	/**
	 * Returns the data stored in the root
	 * 
	 * @precondition !isEmpty()
	 * @return the data stored in the root
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getRoot() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("getRoot(): " + "BST is empty. Cannot get root!");
		}
		return root.data;
	}

	/**
	 * Determines whether the tree is empty
	 * 
	 * @return whether the tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Returns the current size of the tree (number of nodes)
	 * 
	 * @return the size of the tree
	 */
	public int getSize() {
		return -1;
	}

	/**
	 * Helper method for the getSize method
	 * 
	 * @param node the current node to count
	 * @return the size of the tree
	 */
	private int getSize(Node node) {
		return -1;
	}

	/**
	 * Returns the height of tree by counting edges.
	 * 
	 * @return the height of the tree
	 */
	public int getHeight() {
		return -1;
	}

	/**
	 * Helper method for getHeight method
	 * 
	 * @param node the current node whose height to count
	 * @return the height of the tree
	 */
	private int getHeight(Node node) {
		return -1;
	}

	/**
	 * Returns the smallest value in the tree
	 * 
	 * @precondition !isEmpty()
	 * @return the smallest value in the tree
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public T findMin() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("findMin(): " + "BST is empty, cannot find min!");
		}
		return findMin(root);
	}

	/**
	 * Recursive helper method to findMin method
	 * 
	 * @param node the current node to check if it is the smallest
	 * @return the smallest value in the tree
	 */
	private T findMin(Node node) {
		if (node.left != null) {
			return findMin(node.left);
		}
		return node.data;
	}

	/**
	 * Returns the largest value in the tree
	 * 
	 * @precondition !isEmpty()
	 * @return the largest value in the tree
	 * @throws NoSuchElementException when the precondition is violated
	 */
	public T findMax() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("findMax(): " + "BST is empty, cannot find min!");
		}
		return findMax(root);
	}

	/**
	 * Recursive helper method to findMax method
	 * 
	 * @param node the current node to check if it is the largest
	 * @return the largest value in the tree
	 */
	private T findMax(Node node) {
		if (node.right != null) {
			return findMax(node.right);
		}
		return node.data;
	}

	/**
	 * Searches for a specified value in the tree
	 * 
	 * @param data   the value to search for
	 * @param update whether to update the node's data with the given data
	 * @param c      the Comparator that indicates the way the data in the tree was
	 *               ordered
	 * @return the data stored in that Node of the tree is found or null otherwise
	 */
//   public T search(T data, Comparator<T> c) {
	public boolean search(T data) {
		if (root == null) {
			return false;
		} else {
			return search(data, root);
		}
	}

	/**
	 * Helper method for the search method
	 * 
	 * @param data the data to search for
	 * @param node the current node to check
	 * @param c    the Comparator that determines how the BST is organized
	 * @return the data stored in that Node of the tree is found or null otherwise
	 */
//   private T search(T data, Node node, Comparator<T> c) {
	private boolean search(T data, Node node) {
		if (data.compareTo(node.data) == 0) {
			return true;
		} else if (data.compareTo(node.data) < 0) {
			// smaller
			if (node.left == null) {
				// value not found
				return false;
			} else {
				// go left
				search(data, node.left);
			}
		} else {
			// bigger: go right
			if (node.right == null) {
				// value not found
				return false;
			} else {
				// go right
				search(data, node.right);
			}
		}
		return false;
	}

	/*** MUTATORS ***/

	/**
	 * Inserts a new node in the tree
	 * 
	 * @param data the data to insert
	 * @param c    the Comparator indicating how data in the tree is ordered
	 */
//   public void insert(T data, Comparator<T> c) {
	public void insert(T data) {
		if (root == null) {
			root = new Node(data);
		} else {
			insert(data, root);
		}
	}

	/**
	 * Helper method to insert Inserts a new value in the tree
	 * 
	 * @param data the data to insert
	 * @param node the current node in the search for the correct location to insert
	 * @param c    the Comparator indicating how data in the tree is ordered
	 */
//   private void insert(T data, Node node, Comparator<T> c) {
	private void insert(T data, Node node) {
		if (data.compareTo(node.data) >= 1) {
			// bigger - insert to right
			if (node.right == null) {
				node.right = new Node(data);
				return;
			}
			insert(data, node.right);
		} else {
			// smaller or equal - insert to left
			if (node.left == null) {
				node.left = new Node(data);
				return;
			}
			insert(data, node.left);
		}
	}

	/**
	 * Removes a value from the BST
	 * 
	 * @param data the value to remove
	 * @param c    the Comparator indicating how data in the tree is organized Note:
	 *             updates nothing when the element is not in the tree
	 * @precondition !isEmpty()
	 * @precondition the data is located in the tree
	 * @throws NoSuchElementException when the precondition is violated
	 */
//	public void remove(T data, Comparator<T> c) throws NoSuchElementException {
	public void remove(T data) throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("remove(): " + "BST is empty. Cannot remove!");
		}
		remove(data, root);
	}

	/**
	 * Helper method to the remove method
	 * 
	 * @param data the data to remove
	 * @param node the current node
	 * @param c    the Comparator indicating how data in the tree is organized
	 * @return an updated reference variable
	 */
//	private Node remove(T data, Node node, Comparator<T> c) {
	private Node remove(T data, Node node) {
		if (node == null) {
			return node;
		} else if (data.compareTo(node.data) < 0) {
			// data < node.data
			node.left = remove(data, node.left);
		} else if (data.compareTo(node.data) > 0) {
			// data > node.data
			node.right = remove(data, node.right);
		} else {
			if (node.right == null && node.left == null) {
				// leaf node
				node = null;
			} else if (node.left != null && node.right == null) {
				// has left child but no right child
				node = node.left;
			} else if (node.left == null && node.right != null) {
				// has right child but no left child
				node = node.right;
			} else {
				// has both child
				T minRight = findMin(node.right);
				node.data = minRight;
				node.right = remove(minRight, node.right);
			}
		}
		return node;
	}

	/*** ADDITONAL OPERATIONS ***/

	/**
	 * Prints the data in pre order to the console followed by a new line
	 */
	public void preOrderPrint() {
		preOrderPrint(root);
		System.out.println();
	}

	/**
	 * Helper method to preOrderPrint method Prints the data in pre order (node ->
	 * left -> right) to the console followed by a new line
	 */
	private void preOrderPrint(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrderPrint(node.left);
		preOrderPrint(node.right);
	}

	/**
	 * Prints the data in sorted order to the console followed by a new line
	 */
	public void inOrderPrint() {
		// fill in here
		inOrderPrint(root);
		System.out.println();
	}

	/**
	 * Helper method to inOrderPrint method Prints the data in sorted order to the
	 * console followed by a new line
	 */
	private void inOrderPrint(Node node) {
		if (node == null) {
			return;
		}
		inOrderPrint(node.left);
		System.out.print(node.data + " ");
		inOrderPrint(node.right);
	}

	/**
	 * Prints the data in post order to the console followed by a new line
	 */
	public void postOrderPrint() {
		postOrderPrint(root);
		System.out.println();
	}

	/**
	 * Helper method to postOrderPrint method Prints the data in post order to the
	 * console
	 */
	private void postOrderPrint(Node node) {
		// fill in here
		if (node == null)
			return;
		postOrderPrint(node.left);
		postOrderPrint(node.right);
		System.out.print(node.data + " ");
	}
}