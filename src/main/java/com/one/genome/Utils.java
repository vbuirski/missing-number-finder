package com.one.genome;

import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;

public class Utils {

	public static boolean containsDuplicates(int[] input) {

		Set<Integer> set = new HashSet<>();

		for (int x : input) {
			if (set.add(x) == false) {
				return true;
			}
		}

		return false;
	}

	public static boolean containsZero(int[] input) {

		return IntStream.of(input).anyMatch(x -> x == 0);
	}

	public static boolean noMissingDigits(int x, int y, int len) {

		if ((x - y) == len)
			return true;

		return false;
	}

	/**
	 * @param input
	 * @param len
	 * @return
	 */
	public static boolean multipleMissingNumbers(int[] input, int len) {

		OptionalInt highest = IntStream.of(input).max();

		if (highest.getAsInt() - len >= 2)
			return true;

		return false;
	}
}
