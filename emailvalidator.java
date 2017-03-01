/* emailvalidator.java
 * CSCI3130 Assignment 3
 * Part 1
 * 
 * By Connor Foran
 * B00649015
 */

import java.util.Scanner;

public class emailvalidator{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String input = "";
		int rulesPassed;
		
		System.out.println("--CSCI3130 Assignment 3: Stage 1--");
		System.out.print("Please enter a string to check: ");
		input = scanner.nextLine(); //Get user input
		
		rulesPassed = validate(input); //Call validation function
		
		//Print result
		System.out.println("This string passed "+rulesPassed+" rules.");
		if(rulesPassed >= 2)
			System.out.println("This string passes the validation check.");
		else
			System.out.println("This string did not pass the validation check.");
		
		scanner.close();
	}
	
	public static int validate(String input)
	{
		//Rule #1: The string has at least one '.'
		//Rule #2: The string has a single '@'
		boolean dotFound = false;
		boolean atFound = false;
		char c;
		int rulesPassed = 0;
		
		for(int i=0; i<input.length(); i++) //Parse the string
		{
			c = input.charAt(i);
			if(c == '.' && dotFound == false) //Found a '.'
			{
				dotFound = true;
				rulesPassed++;
			}
			else if(c == '@') //Found an '@'
			{
				if(atFound) //If an @ was already found, it does not pass the rule
				{
					rulesPassed--;
					break;
				}
				else
				{
					atFound = true;
					rulesPassed++;
				}
			}
		}
		
		return rulesPassed;
	}
}