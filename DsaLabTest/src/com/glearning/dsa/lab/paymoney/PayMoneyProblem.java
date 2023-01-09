package com.glearning.dsa.lab.paymoney;

/**
 * This class is an implementation class of PayMoney Problem's solution. This
 * class is responsible to take input of different transaction amount and
 * determine the target transaction for given transaction amount.
 * 
 * @author Dipanjan Das
 * @since 08-Jan-2023
 * @version 1.0
 *
 */
public class PayMoneyProblem {
	private int[] transactionArray;

	/**
	 * Parameterized constructor of this class. This constructor is responsible to
	 * create instance of array based on given size.
	 * 
	 * @param arraySize Integer value. Size of the array.
	 */
	public PayMoneyProblem(int arraySize) {
		super();
		this.transactionArray = new int[arraySize];
	}

	/**
	 * This method is responsible to determine number of transactions to achieve
	 * given transaction value.
	 * 
	 * @param amount Integer value. Transaction amount.
	 */
	public void determineTransaction(int amount) {
		try {
			int sum = 0;
			int counter = 0;
			boolean achieved = false;
			for (int i = 0; i < transactionArray.length; i++) {
				sum = sum + transactionArray[i];
				++counter;
				if (sum >= amount) {
					System.out.println("Target achieved after " + counter + " transactions");
					achieved = true;
					break;
				}
			}
			if (!achieved) {
				System.out.println("Given target is not achieved");
			}
		} catch (Exception e) {
			System.out.println("Unable to determing given target");
		}
	}

	/**
	 * This method is responsible to add transaction amount to the underneath array.
	 * 
	 * @param index Index of the underneath array.
	 * @param value Corresponding value in that index.
	 */
	public void addTransactionValue(int index, int value) {
		if (this.transactionArray != null) {
			this.transactionArray[index] = value;
		}
	}
}
