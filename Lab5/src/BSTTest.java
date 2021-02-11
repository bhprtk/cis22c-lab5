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

		System.out.println("****************************************************** End of BSTTest");

	}
}