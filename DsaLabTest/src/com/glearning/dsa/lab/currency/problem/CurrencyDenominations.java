package com.glearning.dsa.lab.currency.problem;

/**
 * This class is responsible to hold random denomination of a particular
 * currency and provide method to identify number of different notes required to
 * pay given amount.
 * 
 * @author Dipanjan Das
 * @since 08-Jan-2023
 * @version 1.0
 *
 */
public class CurrencyDenominations {
	private int[] notes;
	private StringBuffer mStringBuffer;

	/**
	 * Constructor of this class. Creating instance of array with given size.
	 * 
	 * @param sizeOfArray
	 */
	public CurrencyDenominations(int sizeOfArray) {
		super();
		notes = new int[sizeOfArray];
		mStringBuffer = new StringBuffer();
	}

	/**
	 * This method is responsible to arrange input denomination in descending order.
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	private void mergeSort(int arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	/**
	 * This method is responsible to combine all sorted array in sorted sub arrays.
	 * 
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	public void merge(int array[], int left, int mid, int right) {
		int leftArrLength = mid - left + 1;
		int rightArrLength = right - mid;

		int leftArray[] = new int[leftArrLength];
		int rightArray[] = new int[rightArrLength];

		for (int i = 0; i < leftArrLength; i++) {
			leftArray[i] = array[left + i];
		}
		for (int j = 0; j < rightArrLength; j++) {
			rightArray[j] = array[mid + 1 + j];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = left;

		while (i < leftArrLength && j < rightArrLength) {
			if (leftArray[i] >= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < leftArrLength) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightArrLength) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

	/**
	 * This method is responsible to find number of notes.
	 * 
	 * @param amount
	 * @param denomination
	 * @return
	 */
	private int denomination(int amount, int denomination) {
		try {
			return (amount / denomination);
		} catch (ArithmeticException e) {
			return 0;
		}
	}

	/**
	 * This method is responsible to make count of different notes to pay given
	 * amount.
	 * 
	 * @param amount
	 */
	public void determineDenomination(int amount) {
		mergeSort(notes, 0, (notes.length - 1));
		boolean isFinished = false;
		for (int i = 0; i < notes.length; i++) {
			int noOfNotes = denomination(amount, notes[i]);
			if (noOfNotes > 0) {
				this.addPair(notes[i] + ":" + noOfNotes);
				amount = amount % notes[i];
			}
			if (amount == 0) {
				isFinished = true;
				break;
			}
		}
		if (isFinished) {
			System.out.println(mStringBuffer.toString());
		} else {
			System.out.println("Not possible to make a payment with available denomination.");
		}
		mStringBuffer.setLength(0);
	}

	private void addPair(String pair) {
		mStringBuffer.append(pair);
		mStringBuffer.append("\n");
	}

	public void addElement(int index, int value) {
		notes[index] = value;
	}
}
