
/**
* BSTTest.java
* @author Naqib Khan
* @author Pratik Bhandari
* CIS 22C Lab 5
*/

import java.util.NoSuchElementException;

public class BSTTest {
	public static void main(String[] args) {
		NameComparator nameComparator = new NameComparator();
		ValueComparator valueComparator = new ValueComparator();
		System.out.println(
				"***************************************************** Constructor, insert(), inOrderPrint()\n");
		BST<MutualFundAccount> B_name = new BST<>();
		BST<MutualFundAccount> B_value = new BST<>();
		BST<MutualFundAccount> B_empty = new BST<>();

		B_name.insert(new MutualFundAccount(new MutualFund("Banana", "BNNA", 60), 20), nameComparator);
		B_name.insert(new MutualFundAccount(new MutualFund("Apple", "AAPL", 20), 20), nameComparator);

		B_name.insert(new MutualFundAccount(new MutualFund("Carrot", "CRRT", 10), 20), nameComparator);
		System.out.println("Should print Apple Banana Carrot: ");
		B_name.inOrderPrint();

		B_value.insert(new MutualFundAccount(new MutualFund("Banana", "BNNA", 60), 20), valueComparator);
		B_value.insert(new MutualFundAccount(new MutualFund("Apple", "AAPL", 20), 20), valueComparator);

		B_value.insert(new MutualFundAccount(new MutualFund("Carrot", "CRRT", 10), 20), valueComparator);
		System.out.println("Should print Carrot Apple Banana: ");
		B_value.inOrderPrint();

		System.out.println("**************************************************** preOrderPrint()\n");

		System.out.println("Should print Banana Apple Carrot: ");
		B_name.preOrderPrint();
		System.out.println("Should print Banana Apple Carrot: ");
		B_value.preOrderPrint();

		System.out.println("**************************************************** postOrderPrint()\n");

		System.out.println("Should print Apple Carrot Banana: ");
		B_name.postOrderPrint();

		System.out.println("Should print Carrot Apple Banana: ");

		B_value.postOrderPrint();

		System.out.println("**************************************************** search()\n");

		MutualFundAccount temp = new MutualFundAccount(new MutualFund("Carrot", "CRRT", 10), 20);
		MutualFundAccount temp2 = new MutualFundAccount(new MutualFund("Dance", "DNNC", 5), 20);
		System.out.println("Should print Carrot: " + B_name.search(temp, nameComparator));

		System.out.println("Should print null: " + B_name.search(temp2, nameComparator));

		System.out.println("\n**************************************************** isEmpty()\n");

		System.out.println("Should print true: " + B_empty.isEmpty());
		System.out.println("Should print false: " + B_name.isEmpty());

		System.out.println("\n**************************************************** findMin()\n");

		System.out.println("Should print Apple: " + B_name.findMin());
		System.out.println("Should print Carrot: " + B_value.findMin());
		try {
			B_empty.findMin();
		} catch (NoSuchElementException e) {
			System.out.println("Should print error: " + e.getMessage());
		}

		System.out.println("\n**************************************************** findMax()\n");
		System.out.println("Should print Carrot: " + B_name.findMax());
		System.out.println("Should print Banana: " + B_value.findMax());
		try {
			B_empty.findMax();
		} catch (NoSuchElementException e) {
			System.out.println("Should print error: " + e.getMessage());
		}

		System.out.println("\n**************************************************** remove()\n");

		B_name.remove(temp, nameComparator);
		System.out.print("Should print Apple Banana: ");
		B_name.inOrderPrint();
		B_name.insert(temp, nameComparator);

		B_value.remove(temp, valueComparator);
		System.out.print("Should print Apple Banana: ");
		B_value.inOrderPrint();
		B_value.insert(temp, valueComparator);

		System.out.println("\n**************************************************** getRoot()\n");
		System.out.println("Should print Banana: " + B_name.getRoot());
		try {
			B_empty.getRoot();
		} catch (NoSuchElementException e) {
			System.out.println("Should print error: " + e.getMessage());
		}

		System.out.println("\n**************************************************** getSize()\n");
		System.out.println("Should print 3: " + B_name.getSize());
		System.out.println("Should print 0: " + B_empty.getSize());

		System.out.println("\n**************************************************** getHeight()\n");

		System.out.println("Should print 1: " + B_name.getHeight());
		System.out.println("Should print -1: " + B_empty.getHeight());
		System.out.println("Should print 2: " + B_value.getHeight());

		System.out.println("\n**************************************************** Copy Constructor\n");
		BST<MutualFundAccount> B_nameCopy = new BST<>(B_name, nameComparator);
		BST<MutualFundAccount> B_valueCopy = new BST<>(B_value, valueComparator);

		System.out.println("Should print Apple Banana Carrot: ");
		B_nameCopy.inOrderPrint();

		System.out.println("Should print Carrot Apple Banana: ");
		B_valueCopy.inOrderPrint();

		System.out.println("****************************************************** End of BSTTest");

	}
}
