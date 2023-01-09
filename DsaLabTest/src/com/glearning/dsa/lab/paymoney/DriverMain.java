package com.glearning.dsa.lab.paymoney;

import java.util.Scanner;

/**
 * This is a driver class which is resposible to take input from user for
 * PayMoney Problem and calls required method to show output of PayMoney
 * problem.
 * 
 * @author Dipanjan Das
 * @since 08-Jan-2023
 * @version 1.0
 *
 */
public class DriverMain {

	/**
	 * This is the entry point of this program. This method is called by JVM with
	 * the help of main thread.
	 * 
	 * @param args String array for command line arguments.
	 */
	public static void main(String[] args) {
		//Opening scanner instance to take input from user.
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of transaction array");
		int sizeOfArray = scanner.nextInt();

		PayMoneyProblem payMoneyProblem = new PayMoneyProblem(sizeOfArray);
		System.out.println("Enter the values of array");
		for (int i = 0; i < sizeOfArray; i++) {
			payMoneyProblem.addTransactionValue(i, scanner.nextInt());
		}

		System.out.println("Enter the total no of targets that needs to be achieved");
		int totalNoOfTarget = scanner.nextInt();

		for (int i = 0; i < totalNoOfTarget; i++) {
			System.out.println("Enter the value of target");
			int transAmount = scanner.nextInt();
			payMoneyProblem.determineTransaction(transAmount);
		}
		//Closing scanner instance to release resources as program is ending.
		scanner.close();
	}

}
