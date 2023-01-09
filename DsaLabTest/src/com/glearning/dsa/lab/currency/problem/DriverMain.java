package com.glearning.dsa.lab.currency.problem;

import java.util.Scanner;

/**
 * This class is responsible to take number of denomination for a currency type
 * and amount which customer want to pay.
 * 
 * @author Dipanjan Das
 * @since 08-Jan-2023
 * @version 1.0
 *
 */
public class DriverMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of currency denominations");
		int sizeOfDemArray = scanner.nextInt();
		CurrencyDenominations currencyProblem = new CurrencyDenominations(sizeOfDemArray);

		System.out.println("Enter the currency denominations value");
		for (int i = 0; i < sizeOfDemArray; i++) {
			int input = scanner.nextInt();
			if (input > 0) {
				currencyProblem.addElement(i, input);
			} else {
				i--;
				System.out.println(
						"Denomination input can not be Zero or lesser than Zero." + " Please enter valid note.");
			}
		}

		System.out.println("Enter the amount you want to pay.");
		int amountToPay = scanner.nextInt();
		currencyProblem.determineDenomination(amountToPay);
		// Clearing Resources.
		scanner.close();
	}

}
