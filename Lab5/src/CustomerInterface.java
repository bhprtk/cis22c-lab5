
/**
* CustomerInterface.java
* @author Naqib Khan
* @author Pratik Bhandari
* CIS 22C, Lab 5
*/
import java.io.*;
import java.util.Scanner;

public class CustomerInterface {
	/**
	 * Populates the list of funds from the given file
	 * 
	 * @param funds List of funds to populate from file
	 * @postcondition The list of funds has been populated
	 */
	private static void inputFile(List<MutualFund> funds) {
		Scanner input;
		File file = new File("mutual_funds.txt");
		String mutualName, ticker;
		double sharePrice;
		try {
			input = new Scanner(file);
			while (input.hasNextLine()) {
				mutualName = input.nextLine();
				ticker = input.nextLine();
				sharePrice = Double.parseDouble(input.nextLine());
				funds.addLast(new MutualFund(mutualName, ticker, sharePrice));
			}
			input.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Adds number of shares or inserts new funds to BST
	 * 
	 * @param input           Scanner object to input user input
	 * @param funds           List of funds populated from the file
	 * @param account_name    BST for funds sorted by name
	 * @param account_value   BST form funds sorted by value
	 * @param nameComparator  NameComparator class to compare BST values
	 * @param valueComparator ValueComparator class to compare BST values
	 */
	private static void purchaseFunds(Scanner input, List<MutualFund> funds, BST<MutualFundAccount> account_name,
			BST<MutualFundAccount> account_value, NameComparator nameComparator, ValueComparator valueComparator) {
		double numShares;
		int fundChoice;
		if (funds.isEmpty()) {
			System.out.println("\nYou don't have any funds to display at this time.\n");
		} else {
			System.out.println("\nPlease select from the following options:\n");
			funds.printNumberedList();
			while (true) {
				System.out.print("Enter your choice: (1-" + funds.getLength() + "): ");
				fundChoice = input.nextInt();
				if (fundChoice < 0 || fundChoice > funds.getLength()) {
					System.out.println("Index is out of bounds!");
				} else {
					System.out.print("\nEnter the number of shares to purchase: ");
					numShares = input.nextDouble();
					funds.iteratorToIndex(fundChoice);
					MutualFundAccount fundAccToBuy = new MutualFundAccount(funds.getIterator(), numShares);
					MutualFundAccount fundAccInBST = account_name.search(fundAccToBuy, nameComparator);
					// Add number of shares if the fund already exists
					if (fundAccInBST != null) {
						// If Account already exists
						// Update shares in account_name
						fundAccInBST.updateShares(numShares);
						// Remove account in account_value
						account_value.remove(fundAccInBST, nameComparator);
						// Add the account with updated shares in account_value
						account_value.insert(fundAccInBST, valueComparator);
					} else {
						// If account doesn't exist yet
						// Insert new node in account_name BST
						account_name.insert(fundAccToBuy, nameComparator);
						// Insert new node in account_value BST
						account_value.insert(fundAccToBuy, valueComparator);
						// Insert new node in fundsOwned List
					}
					break;
				}
			}
		}
	}

	/**
	 * Subtracts number of shares or remove funds from BST
	 * 
	 * @param input           Scanner object to input user input
	 * @param account_name    BST for funds sorted by name
	 * @param account_value   BST form funds sorted by value
	 * @param nameComparator  NameComparator class to compare BST values
	 * @param valueComparator ValueComparator class to compare BST values
	 */
	private static void sellFunds(Scanner input, BST<MutualFundAccount> account_name,
			BST<MutualFundAccount> account_value, NameComparator nameComparator, ValueComparator valueComparator) {
		if (account_name.isEmpty()) {
			System.out.println("\nYou don't have any funds to sell at this time.");
		} else {
			String sellName, sellSharesStr;
			System.out.print("\nYou own the following mutual funds:");
			account_name.inOrderPrint();
			while (true) {
				System.out.print("\nEnter the name of the fund to sell: ");
				// Clear input buffer
				input.nextLine();
				// Get mutual fund account name from user
				sellName = input.nextLine();
				System.out.print("Enter the number of shares to sell or \"all\" to sell everything: ");
				// Get the total shares to sell from the user
				sellSharesStr = input.nextLine();
				MutualFundAccount fundAccToSell = account_name.search(new MutualFundAccount(new MutualFund(sellName)),
						nameComparator);

				if (sellSharesStr.compareTo("all") == 0) {
					// Sell all shares
					// Remove from account_value BST
					account_name.remove(fundAccToSell, nameComparator);
					// Remove from account_name BST
					account_value.remove(fundAccToSell, nameComparator);
					break;
				} else {
					double sellShares = Double.parseDouble(sellSharesStr);
					if (Double.compare(sellShares, fundAccToSell.getNumShares()) <= -1) {
						// Sell
						// Update numShares in account_name BST
						fundAccToSell.updateShares(-sellShares);
						// Remove fundAccToSell in account_value BST
						account_value.remove(fundAccToSell, nameComparator);
						// Insert fundAccToSell with updated numShares in account_value BST
						account_value.insert(fundAccToSell, valueComparator);
					} else if (Double.compare(sellShares, fundAccToSell.getNumShares()) == 0) {
						// Sell all shares
						// Remove from account_value BST
						account_name.remove(fundAccToSell, nameComparator);
						// Remove from account_name BST
						account_value.remove(fundAccToSell, nameComparator);
					} else {
						// Cannot sell because not enough shares
						System.out.println("\nCannot sell! Not enough shares!");
					}
					break;
				}

			}

		}
	}

	/**
	 * Displays funds inOrder from the BST
	 * 
	 * @param input         Scanner object to input user input
	 * @param account_name  BST for funds sorted by name
	 * @param account_value BST form funds sorted by value
	 */
	private static void displayFunds(Scanner input, BST<MutualFundAccount> account_name,
			BST<MutualFundAccount> account_value) {
		if (account_name.isEmpty()) {
			System.out.println("\nYou don't have any funds to display at this time.");
		} else {
			int displayChoice;
			System.out.println("\nView Your Mutual Funds By:.\n");
			System.out.println("1. Name");
			System.out.println("2. Value");
			System.out.print("\nEnter your choice (1 or 2): ");
			displayChoice = input.nextInt();
			if (displayChoice == 1) {
				account_name.inOrderPrint();
			} else if (displayChoice == 2) {
				account_value.inOrderPrint();
			} else {
				System.out.println("\nInvalid choice!");
			}
		}
	}

	public static void main(String[] args) {
		NameComparator nameComparator = new NameComparator();
		ValueComparator valueComparator = new ValueComparator();
		List<MutualFund> funds = new List<>();
		BST<MutualFundAccount> account_value = new BST<>();
		BST<MutualFundAccount> account_name = new BST<>();

		String menuChoice = "";

		inputFile(funds);

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Mutual Fund InvestorTrack (TM)!");

		while (true) {
			System.out.println("\nPlease select from the following options:\n");
			System.out.println("A. Purchase a Fund");
			System.out.println("B. Sell a Fund");
			System.out.println("C. Display Your Current Funds");
			System.out.println("X. Exit\n");

			System.out.print("Enter your choice: ");
			menuChoice = input.next();

			if (menuChoice.equals("A")) {
				purchaseFunds(input, funds, account_name, account_value, nameComparator, valueComparator);
			} else if (menuChoice.equals("B")) {
				sellFunds(input, account_name, account_value, nameComparator, valueComparator);
			} else if (menuChoice.equals("C")) {
				displayFunds(input, account_name, account_value);
			} else if (menuChoice.equals("X")) {
				System.out.println("\nGoodbye!");
				break;
			} else {
				System.out.println("\nInvalid menu option. Please enter A-C or X to exit.");
			}

		}
		input.close();

	}

}