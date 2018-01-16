package com.one.genome;

import java.util.stream.IntStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest {

	private int[][] input;
	
	private App app;

	@BeforeClass
	public static void runOnceBeforeClass() {

	}

	@AfterClass
	public static void runOnceAfterClass() {

	}

	@Before
	public void runBeforeTestMethod() {

		app = new App();

		input = new int[11][];
		
		input[0] = new int[0];

		// No missing integer
		input[1] = IntStream.rangeClosed(0, 100).toArray();

		// Missing integer in sorted list
		input[2] = IntStream.concat(IntStream.rangeClosed(0, 4), IntStream.rangeClosed(6, 100)).toArray();

		// Missing integer in unsorted list
		input[3] = IntStream.concat(IntStream.rangeClosed(6, 100), IntStream.rangeClosed(0, 4)).toArray();

		// Contains duplicates
		input[4] = IntStream.concat(IntStream.rangeClosed(0, 100), IntStream.rangeClosed(0, 100)).toArray();
		
		// Array starts with 1
		input[5] =  IntStream.concat(IntStream.rangeClosed(1, 4), IntStream.rangeClosed(6, 100)).toArray();
		
		// Array starts with 1 and no missing digits
		input[6] = IntStream.rangeClosed(1, 100).toArray();
		
		// Two missing numbers
		input[7] = new int[]{0,1,3,4,6};
		
		// Two missing numbers starting from 1
		input[8] = new int[]{1,3,4,6};
		
		input[9] = new int[]{0,1,2,3,4};
		
		// Test single number array
		input[10] = new int[]{999999999};

	}

	@After
	public void runAfterTestMethod() {

	}

	@Test(expected = IllegalStateException.class)
	public void test_method_1_empty_array() {
		System.out.println("@Test - test_method_1_empty_array");

		app.findNumber(input[0]);

	}

	@Test
	public void test_method_2_no_missing_digit() {
		System.out.println("@Test - test_method_2_no_missing_digit");

		// In case of no missing numbers, set the value to the length of the input array 
		Assert.assertEquals(-1, app.findNumber(input[1]));
	}

	@Test
	public void test_method_3_missing_digit_in_sorted_list() {
		System.out.println("@Test - test_method_3_missing_digit_in_sorted_list");

		Assert.assertEquals(5, app.findNumber(input[2]));

	}

	@Test
	public void test_method_4_missing_digit_in_unsorted_list() {
		System.out.println("@Test - test_method_4_missing_digit_in_unsorted_list");
		
		Assert.assertEquals(5, app.findNumber(input[3]));
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_method_5_contains_duplicates() {
		System.out.println("@Test - test_method_5_contains_duplicates");
		
		app.findNumber(input[4]);		
		
	}
	
	@Test
	public void test_method_6_starts_from_one() {
		System.out.println("@Test - test_method_6_starts_from_one");
		
		Assert.assertEquals(5, app.findNumber(input[5]));	
		
	}
	
	@Test
	public void test_method_7_starts_from_one_no_missing_digits() {
		System.out.println("@Test - test_method_7_starts_from_one_no_missing_digits");
		
		Assert.assertEquals(-1, app.findNumber(input[6]));	
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_method_8_two_missing_digits() {
		System.out.println("@Test - test_method_8_two_missing_digits");
		
		app.findNumber(input[7]);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_method_9_two_missing_digits_starting_from_one() {
		System.out.println("@Test - test_method_9_two_missing_digits_starting_from_one");
		
		app.findNumber(input[8]);
		
	}
	
	@Test
	public void test_method_10() {
		
		System.out.println("@Test - test_method_10");
		
		Assert.assertEquals(-1, app.findNumber(input[9]));
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_method_11_single_number_array() {
		
		System.out.println("@Test - test_method_11");
		
		Assert.assertEquals(-1, app.findNumber(input[10]));
		
	}
	
}
