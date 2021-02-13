import java.util.NoSuchElementException;

public class BSTTest {
	public static void main(String[] args) {
		System.out.println("********************************** Test(1) Constructor\n");
		BST<Integer> B1 = new BST<>();
		System.out.print("Should print an empty BST: ");
		B1.inOrderPrint();
		BST<Integer> anotherB1 = new BST<>();
		System.out.println("Should print an empty BST: ");
		anotherB1.inOrderPrint();
		;

		System.out.println("********************************** Test(2) insert - without comparator \n");
		BST<Integer> B2 = new BST<>();
		B2.insert(5);
		B2.insert(4);
		B2.insert(6);

		System.out.print("Should print  4 5 6: ");
		B2.inOrderPrint();

		B2.insert(3);
		B2.insert(7);
		B2.insert(2);

		System.out.print("Should print  2 3 4 5 6 7: ");
		B2.inOrderPrint();
		System.out.println();

		System.out.println("********************************** Test(3) inOrderPrint \n");

		BST<Integer> B3 = new BST<>();
		B3.insert(4);
		B3.insert(6);
		B3.insert(5);
		System.out.print("Should print 4 5 6: ");
		B3.inOrderPrint();
		B3.insert(7);
		B3.insert(2);
		B3.insert(3);
		B3.insert(1);
		System.out.print("Should print 1 2 3 4 5 6 7: ");
		B3.inOrderPrint();

		System.out.println();

		System.out.println("********************************** Test(4) postOrderPrint \n");

		BST<Integer> B4 = new BST<>();
		B4.insert(4);
		B4.insert(6);
		B4.insert(5);
		System.out.print("Should print 5 6 4: ");
		B4.postOrderPrint();
		B4.insert(7);
		B4.insert(2);
		B4.insert(3);
		B4.insert(1);
		System.out.print("Should print 1 3 2 5 7 6 4: ");
		B4.postOrderPrint();

		System.out.println();

		System.out.println("********************************** Test(5) preOrderPrint \n");

		BST<Integer> B5 = new BST<>();
		B5.insert(4);
		B5.insert(6);
		B5.insert(5);
		System.out.print("Should print 4 6 5: ");
		B5.preOrderPrint();
		B5.insert(7);
		B5.insert(2);
		B5.insert(3);
		B5.insert(1);
		System.out.print("Should print 4 2 1 3 6 5 7: ");
		B5.preOrderPrint();

		System.out.println();

		System.out.println("********************************** Test(6) search -- without Comparator \n");

		BST<Integer> B6 = new BST<>();
		System.out.println("Should print false: " + B6.search(3));
		B6.insert(4);
		B6.insert(6);
		B6.insert(5);
		System.out.println("Should print true: " + B6.search(4));
		System.out.println("Should print false: " + B6.search(3));
		System.out.println();

		System.out.println("********************************** Test(7) isEmpty() \n");

		BST<Integer> B7 = new BST<>();
		System.out.println("Should print true: " + B7.isEmpty());
		B7.insert(1);
		B7.insert(2);
		System.out.println("Should print false: " + B7.isEmpty());
		System.out.println();

		System.out.println("********************************** Test(8) findMin() \n");
		BST<Integer> B8 = new BST<>();
		System.out.print("Should print error: ");
		try {
			B8.findMin();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		B8.insert(2);
		B8.insert(5);
		B8.insert(8);
		System.out.println("Should print 2: " + B8.findMin());
		System.out.println();

		System.out.println("********************************** Test(9) findMax() \n");
		BST<Integer> B9 = new BST<>();
		System.out.print("Should print error: ");
		try {
			B9.findMax();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		B9.insert(2);
		B9.insert(5);
		B9.insert(8);
		System.out.println("Should print 8: " + B9.findMax());
		System.out.println();

		System.out.println("********************************** Test(10) remove() \n");

		BST<Integer> B10 = new BST<>();
		System.out.print("Should print error: ");
		try {
			B10.remove(2);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		B10.insert(5);
		B10.insert(2);
		B10.insert(18);
		B10.insert(-4);
		B10.insert(3);
		B10.insert(21);
		B10.insert(19);
		B10.insert(25);

		B10.inOrderPrint();
		B10.remove(18);
		B10.inOrderPrint();

		System.out.println("********************************** Test(11) getRoot() \n");
		BST<Integer> B11 = new BST<>();
		try {
			B11.getRoot();
		} catch (NoSuchElementException e) {
			System.out.println("Should print error: " + e.getMessage());
		}

		B11.insert(2);
		B11.insert(3);
		System.out.println("Should print 2: " + B11.getRoot());
		System.out.println();

		System.out.println("********************************** Test(12) getSize() \n");
		BST<Integer> B12 = new BST<>();
		System.out.println("Should return 0: " + B12.getSize());
		B12.insert(5);
		B12.insert(4);
		B12.insert(5);
		B12.insert(7);
		B12.insert(3);

		System.out.println("Should return 5: " + B12.getSize());

		System.out.println();

		System.out.println("****************************************************** End of BSTTest");

	}
}
