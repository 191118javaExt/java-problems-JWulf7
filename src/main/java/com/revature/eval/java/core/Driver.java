package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

	// write code to test method here

	public static boolean isValidIsbn(String string) {
		// remove dashes
		// check to make sure all 0-9 and also X - if not return false
		// when on the last iteration, check if x, if so, replace with a "10", somehow..
		// or increase the output digit that you % 11 to check boolean by 10
		int sum = 0;
		int counter = 10;

		String number = string.replace("-", "");

		for (int i = 0; i < number.length(); i++)

			if ((number.charAt(i) == '0') || (number.charAt(i) == '1') || (number.charAt(i) == '2')
					|| (number.charAt(i) == '3') || (number.charAt(i) == '4') || (number.charAt(i) == '5')
					|| (number.charAt(i) == '6') || (number.charAt(i) == '7') || (number.charAt(i) == '8')
					|| (number.charAt(i) == '9') || (number.charAt(i) == 'X')) {
				{
					if (number.charAt(i) == 'X') {
						sum += 10;
						counter--;
					} else {
						sum += (Integer.parseInt(String.valueOf((number.charAt(i))))   * counter);
						counter--;
					}
				}
			} else {
				return false;
			}

		if (sum % 11 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		// test-run your method here
/*
		System.out.println(isValidIsbn("3-598-21508-8"));
		System.out.println(isValidIsbn("3-598-21508-9"));
		System.out.println(isValidIsbn("3-598-21507-X"));
		System.out.println(isValidIsbn("3-598-21507-A"));
		System.out.println(isValidIsbn("3-598-2K507-0"));
*/
	}

}
