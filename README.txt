Project: 		Garvan Institute Submission
Author: 		Vonita Buirski
Date:		 	Jan 2018

Requirements:
	Given an array with consecutive numbers from 0 to 100, find the number missing from the array with the least amount of permutations.

Assumptions:
	Array contains no duplicates
	Array is unsorted
	Array starts with index of either of either 0 or 1
	If the input array contains no missing numbers, then return -1
	
Build Tools:
	Java 1.8
	JUnit 4.12
	Eclipse Java EE IDE for Web Developers Version: Neon.3 Release (4.6.3)
	Maven 3.0.2

Solution Design:
	
 	The solution has been written using a TDD (Test Driven Development) process.
 
 	The missing number is calculated using the following algorithm:
 	
	 	1. Calculate the sum of natural numbers between 0 and N, where N is the greatest number in the input array
	 	
		2. Calculate the sum of numbers appearing in the input array
		
		3. Subtract the two values to reveal the missing number
 		
 	Space complexity:
 		The problem is solved with O(1).
 	
 	Time complexity:
 		The problem is solved in O(n). (There can be overflow if n is large).

Build:
The application is built using Maven. The build command is as follows:
	mvn install
	
	For example:
		C:\Users\vbuirski\workspace\MissingNumberFinder>mvn install
		
		(see maven.PNG under main folder)
		

Execute:
	java -jar target/MissingNumberFinder-0.0.1-SNAPSHOT.jar
	
	For example:
		C:\Users\vbuirski\workspace\MissingNumberFinder>java -jar target/MissingNumberFinder-0.0.1-SNAPSHOT.jar
		
		(see java.png under main folder)
 
 

