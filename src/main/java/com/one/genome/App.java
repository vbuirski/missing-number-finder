package com.one.genome;

import java.util.Arrays;

/**
 * @author vbuirski
 *
 */
public class App {

	public int findNumber(int[] input) {

		int sumTotal = 0;
		int sumInput = 0;
		
		int len = validateInput(input);
	
		sumTotal = len * (len + 1) / 2;
		sumInput = Arrays.stream(input).sum();

		// Check for no missing digits
		if (Utils.noMissingDigits(sumTotal, sumInput, len))
			return -1;

		return sumTotal - sumInput;

	}

	private int validateInput(int[] input) {
		
		int len = input.length;
		
		if (len < 1)
			throw new IllegalStateException("Invalid input");

		if (Utils.containsDuplicates(input))
			throw new IllegalArgumentException("Input contains duplicates");

		if (!Utils.containsZero(input)) {
			len++;
		}

		if (Utils.multipleMissingNumbers(input, len - 1))
			throw new IllegalArgumentException("Input contains more than one missing number");

		return len;
	}
	
	private static int[] convertToIntArray(String input) {

		String[] items = input.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

		int[] array = new int[items.length];

		for (int i = 0; i < items.length; i++) {
			array[i] = Integer.parseInt(items[i]);

		}

		return array;
	}
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {

		App app = new App();

		while (true) {

			System.out.print("Enter Array in format [x,y,z] (q to quit): ");
			String text = System.console().readLine();

			if ("q".equals(text)) {
				System.out.println("Exiting..");
				System.exit(0);
			}

			try {
				int[] input = convertToIntArray(text);
				int result = app.findNumber(input);
				if (result == -1) {
					System.out.println("No missing numbers, please retry");
				} else {
					System.out.println("Missing number = " + app.findNumber(input));
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid input, please retry");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}


}
