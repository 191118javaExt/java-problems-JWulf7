package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/*
	 * Completed:1, 2, 3, 4, 5, 6, 7 not done yet- but not required, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
	 */
	
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		
		char[] answer = new char[string.length()];
		
		for(int i = 0; i < answer.length; i++) {
			answer[(answer.length) - (i+1)] = string.charAt(i);
		}
		
	
		return String.valueOf(answer);
		
		
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {

		String acr = new String("");
		acr += phrase.charAt(0);
		phrase = phrase.replace("-", " ");
		int bigIndex = 1;
		int indexDiff = 0;
		
		while((bigIndex + indexDiff) <= phrase.length()) {
			String remainder = phrase.substring(bigIndex);
			indexDiff = (bigIndex - (remainder.indexOf(" ")) * -1);
			acr += remainder.charAt((remainder.indexOf(" ") + 1));
			bigIndex += (remainder.indexOf(" ") +1);
			
		}
		return acr.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			
			if(((this.getSideOne()) == (this.getSideTwo()) && (this.getSideOne()) == (this.getSideThree()))) {
				return true;
			} else {
			return false;
			}
		}

		public boolean isIsosceles() {

			if(((this.getSideOne()) == (this.getSideTwo())) || ((this.getSideOne()) == (this.getSideThree())) || ((this.getSideTwo()) == (this.getSideThree()))) {
				return true;
			} else {
			return false;
			}
		}

		public boolean isScalene() {

			if(((this.getSideOne()) == (this.getSideTwo()) && (this.getSideOne()) == (this.getSideThree()))) {
				return false;
			} else {
			return true;
			}
			
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		//Initialize stuff
		Integer score = 0;
		Hashtable<Character, Integer> h = new Hashtable();
		h.put('A', 1); h.put('E', 1); h.put('I', 1); h.put('O', 1); h.put('U', 1); 
		h.put('L', 1); h.put('N', 1); h.put('R', 1); h.put('S', 1); h.put('T', 1); 
		h.put('D', 2); h.put('G', 2); h.put('B', 3); h.put('C', 3); h.put('M', 3); 
		h.put('P', 3); h.put('F', 4); h.put('H', 4); h.put('V', 4); h.put('W', 4); 
		h.put('Y', 4); h.put('K', 5); h.put('J', 8); h.put('X', 8); h.put('Q', 10); h.put('Z', 10); 
		
		String word = string.toUpperCase();
		
		for(int i = 0; i < word.length(); i++) {
			score += h.get(word.charAt(i));
		}
		return (int)score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		// argument exceptions not graded
		// PLAN:
		// iterate through every position of the string loop?
		// nest an if statement that only accept digits 0-9
			// create a new string with only numbers
		// 
		// 
		String number = new String();
		for(int i = 0; i < string.length(); i++) {
			if((string.charAt(i) == '0') || (string.charAt(i) == '1') || (string.charAt(i) == '2')
					|| (string.charAt(i) == '3') || (string.charAt(i) == '4') || (string.charAt(i) == '5')
					|| (string.charAt(i) == '6') || (string.charAt(i) == '7') || (string.charAt(i) == '8')
					|| (string.charAt(i) == '9'))  {
				number += string.charAt(i);
			}
		}
		
		if(number.length() > 11) {
			throw new IllegalArgumentException("This number is too long");
		}
		/*
		//now limit the number of digits
		String numberLimit = new String();
		for(int i = 0; i < 11 | i < numberLimit.length(); i++) {
			numberLimit += number.charAt(i);
		}
		*/
		return number;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		// create a Map variable (for return type) of HashMap which will store the answer
		Map<String, Integer> count = new HashMap<>();
		
		// isolate each word
		
		//String eachWord2 = string.replace("\n", " ");
		//String eachWord1 = eachWord2.replace(",", " ");
		// splits the string on everything not a word and creates a string array
		String[] eachWord = string.split("\\W+");
		
		//put each word into a map
		for(int i = 0; i < eachWord.length; i++) {
			if(count.containsKey(eachWord[i])) {
				count.put(eachWord[i], (count.get(eachWord[i])) +1);
			} else {
				count.put(eachWord[i], 1);
			}
			
		}
		
		return count;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	
	// 7 won't be graded
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {

		// take out and split on spaces
		String[] arr = string.split(" ");
		//maybe need a temp string holder?
		String string2 = "";
		String temp = "";
		String q = "";
		// iterate over each word
		for(int i = 0; i < arr.length; i++) {
			// conditional statements starting at most specific
			//q
			//if q - move char 0 and char 1 to end of word - starting substring 2
			if((arr[i].charAt(0) == 'q') || (arr[i].charAt(0) == 'Q')) {
				q += arr[i].charAt(0);
				q += arr[i].charAt(1);
				arr[i] = (arr[i].substring(2)) + q + "ay";
			}
			// now vowels - add on an 'ay' to end of word
			else if ((arr[i].charAt(0) == 'a') || (arr[i].charAt(0) == 'A') || (arr[i].charAt(0) == 'e') || (arr[i].charAt(0) == 'E') 
					|| (arr[i].charAt(0) == 'i') || (arr[i].charAt(0) == 'I') || (arr[i].charAt(0) == 'o') || (arr[i].charAt(0) == 'O')
					|| (arr[i].charAt(0) == 'u') || (arr[i].charAt(0) == 'U')) {
				arr[i] += "ay";
			} 
			// now the rest/consonants -- move each consonant to back of word , so iterate over word until hit a vowel
			// then at end tack on an 'ay' to end
			else {
				for (int j=0; j < arr[i].length(); j++) {
					if ((arr[i].charAt(j) == 'a') || (arr[i].charAt(j) == 'A') || (arr[i].charAt(j) == 'e') || (arr[i].charAt(j) == 'E') 
					|| (arr[i].charAt(j) == 'i') || (arr[i].charAt(j) == 'I') || (arr[i].charAt(j) == 'o') || (arr[i].charAt(j) == 'O')
					|| (arr[i].charAt(j) == 'u') || (arr[i].charAt(j) == 'U')) {
						// do something at the end here
						arr[i] = arr[i].substring(j) + temp + "ay";
						temp = "";
						break;
					}
					// what to do if letter is consonant
					else {
						temp += arr[i].charAt(j);
					}
				}
			}
			
		}
		// concat string back together to return a string
		string2 = String.join(" ", arr);
		return string2;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isArmstrongNumber(int input) {
		
		int length = Integer.toString(input).length();
		int x = input;
		int calc = 0;
		int z = 0;
		int y = 0;
		while(z < length) {
			y = input % 10;
			calc += (Math.pow(y, length));
			z++;
			input = input / 10;
		}
		if(calc == x) {
			return true;
		} else {
		return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// start a list
		List<Long> theList = new ArrayList<Long>();
		//instantiate original number
		Long orig = l;
		for(Long i=2L; i <= (orig/2) + 1; i++) {
			if(l%i == 0) {
				while(l%i == 0) {
					theList.add((theList.size()), i);
					l /= i;
				}
			} 
		}
		return theList;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {

			
			String rotated = "";
			// create some maps (2), 1 for grabbing an int from a char, one for grabbing a char from an int
			Map<Character, Integer> firstMap = new HashMap<>();
			Map<Integer, Character> secondMap = new HashMap<>();
			
			firstMap.put('a', 1); firstMap.put('b', 2); firstMap.put('c', 3); firstMap.put('d', 4); firstMap.put('e', 5); firstMap.put('f', 6); 
			firstMap.put('g', 7); firstMap.put('h', 8); firstMap.put('i', 9); firstMap.put('j', 10); firstMap.put('k', 11); firstMap.put('l', 12); 
			firstMap.put('m', 13); firstMap.put('n', 14); firstMap.put('o', 15); firstMap.put('p', 16); firstMap.put('q', 17); firstMap.put('r', 18); 
			firstMap.put('s', 19); firstMap.put('t', 20); firstMap.put('u', 21); firstMap.put('v', 22); firstMap.put('w', 23); firstMap.put('x', 24); 
			firstMap.put('y', 25); firstMap.put('z', 26);
			firstMap.put('A', 101); firstMap.put('B', 102); firstMap.put('C', 103); firstMap.put('D', 104); firstMap.put('E', 105); firstMap.put('F', 106); 
			firstMap.put('G', 107); firstMap.put('H', 108); firstMap.put('I', 109); firstMap.put('J', 110); firstMap.put('K', 111); firstMap.put('L', 112); 
			firstMap.put('M', 113); firstMap.put('N', 114); firstMap.put('O', 115); firstMap.put('P', 116); firstMap.put('Q', 117); firstMap.put('R', 118); 
			firstMap.put('S', 119); firstMap.put('T', 120); firstMap.put('U', 121); firstMap.put('V', 122); firstMap.put('W', 123); firstMap.put('X', 124); 
			firstMap.put('Y', 125); firstMap.put('Z', 126);
			
			
			secondMap.put(1, 'a'); secondMap.put(2,  'b'); secondMap.put(3, 'c'); secondMap.put(4,  'd'); secondMap.put(5, 'e'); secondMap.put(6,  'f'); 
			secondMap.put(7, 'g'); secondMap.put(8,  'h'); secondMap.put(9, 'i'); secondMap.put(10,  'j'); secondMap.put(11, 'k'); secondMap.put(12,  'l'); 
			secondMap.put(13, 'm'); secondMap.put(14,  'n'); secondMap.put(15, 'o'); secondMap.put(16,  'p'); secondMap.put(17, 'q'); secondMap.put(18,  'r'); 
			secondMap.put(19, 's'); secondMap.put(20,  't'); secondMap.put(21, 'u'); secondMap.put(22,  'v'); secondMap.put(23, 'w'); secondMap.put(24,  'x');
			secondMap.put(25, 'y'); secondMap.put(26,  'z');
			secondMap.put(101, 'A'); secondMap.put(102,  'B'); secondMap.put(103, 'C'); secondMap.put(104,  'D'); secondMap.put(105, 'E'); secondMap.put(106,  'F'); 
			secondMap.put(107, 'G'); secondMap.put(108,  'H'); secondMap.put(109, 'I'); secondMap.put(110,  'J'); secondMap.put(111, 'K'); secondMap.put(112,  'L'); 
			secondMap.put(113, 'M'); secondMap.put(114,  'N'); secondMap.put(115, 'O'); secondMap.put(116,  'P'); secondMap.put(117, 'Q'); secondMap.put(118,  'R'); 
			secondMap.put(119, 'S'); secondMap.put(120,  'T'); secondMap.put(121, 'U'); secondMap.put(122,  'V'); secondMap.put(123, 'W'); secondMap.put(124,  'X');
			secondMap.put(125, 'Y'); secondMap.put(126,  'Z');
			
			// eliminate no change rotations
			if(this.key == 0 || this.key == 26) {
				return string;
			}
			
			// begin iterating through the string
			for(int i = 0; i < string.length(); i++) {
				// iterate over non letters and throw them onto the new string 'rotated'
				if(string.charAt(i) == ' ' || string.charAt(i) == ','|| string.charAt(i) == '\'' ||
						string.charAt(i) == '.' || string.charAt(i) == '?'|| string.charAt(i) == '!' ||
						string.charAt(i) == '0' || string.charAt(i) == '1'|| string.charAt(i) == '2' ||
						string.charAt(i) == '3' || string.charAt(i) == '4'|| string.charAt(i) == '5' ||
						string.charAt(i) == '6' || string.charAt(i) == '7'|| string.charAt(i) == '8' ||
						string.charAt(i) == '9' || string.charAt(i) == '('|| string.charAt(i) == ')' ||
						string.charAt(i) == '\\' || string.charAt(i) == '/'|| string.charAt(i) == '\"' ||
						string.charAt(i) == '&' || string.charAt(i) == '%' || string.charAt(i) == '@') {
					rotated += string.charAt(i);
				} else {
					// apply rotation to the value of the character
					int x = (firstMap.get(string.charAt(i)) + this.key);
					// rotate around to the beginning 
					if((x >= 127) || ((x < 101) && (x > 26))) {
						x -= 26;
						rotated += secondMap.get(x);
					} else {
						// if don't need to rotate
						x = (firstMap.get(string.charAt(i)) + this.key);
						rotated += secondMap.get(x);
					}
				}
			}
			return rotated;
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public static int calculateNthPrime(int i) {
		// create an array of all primes in order
		List<Integer> primes = new ArrayList<>();
		// iterate over every number, starting at 2, and see whether it is prime, 
		// throw primes into 'primes' array, until primes.length = i-1
		if (i < 1) {throw new IllegalArgumentException("input must be positive");
		}
		
		for(int j = 2; primes.size() <= i; j++) {
			if(isPrime(j)) {
				primes.add(j);
				//System.out.println(primes);
			}
		} 
		return primes.get((i - 1));
	} 
	// helper method to determine if is prime
	public static boolean isPrime(int i) {
		boolean prime;
		int j = 2;
		while(j <= i/2) {
			if(i % j == 0) {
				return false;
			} else {
				j++;
			}
		}
		return true;
	}
	

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// make a map of all the reverse values
			// make a empty string to store output
			// iterate over input 'string', check if each value is contained in map, 
			//if(its contained) {retrieve value and concat onto string} else {skip}
			// also need to add spaces after every 5 letters
			String input = string.toLowerCase();
			String output = new String("");
			
			// map out the cipher
			Map<Character, Character> encodeIt = new HashMap<>();
			encodeIt.put('a', 'z'); encodeIt.put('b', 'y'); encodeIt.put('c', 'x'); encodeIt.put('d', 'w'); encodeIt.put('e', 'v'); 
			encodeIt.put('f', 'u'); encodeIt.put('g', 't'); encodeIt.put('h', 's'); encodeIt.put('i', 'r'); encodeIt.put('j', 'q'); 
			encodeIt.put('k', 'p'); encodeIt.put('l', 'o'); encodeIt.put('m', 'n'); encodeIt.put('n', 'm'); encodeIt.put('o', 'l'); 
			encodeIt.put('p', 'k'); encodeIt.put('q', 'j'); encodeIt.put('r', 'i'); encodeIt.put('s', 'h'); encodeIt.put('t', 'g'); 
			encodeIt.put('u', 'f'); encodeIt.put('v', 'e'); encodeIt.put('w', 'd'); encodeIt.put('x', 'c'); encodeIt.put('y', 'b');
			encodeIt.put('z', 'a'); encodeIt.put('0', '0'); encodeIt.put('1', '1'); encodeIt.put('2', '2'); encodeIt.put('3', '3');
			encodeIt.put('4', '4'); encodeIt.put('5', '5'); encodeIt.put('6', '6'); encodeIt.put('7', '7'); encodeIt.put('8', '8');
			encodeIt.put('9', '9');
			
			int space = 0;
			// iterate over every char of the input String, if it is in the map, add the value to output string
			for(int i = 0; i < input.length(); i++) {
				if(encodeIt.containsKey(input.charAt(i))) {
					output += encodeIt.get(input.charAt(i));
					space++;
					if(space % 5 == 0) {
						output += " ";
					}
				}
			}
			if((output.charAt((output.length() - 1))) == ' ') {
				output= output.substring(0, output.length() - 1);
			}
			return output;
		}
		
		public static String decode(String string) {
			// take out spaces
			// make a map of opposite values
			// iterate over every char of string and add value to output string
			String output = "";
			String input = string.replace(" ", "").toLowerCase();
			
			// create my map
			Map<Character, Character> decodeIt = new HashMap<>();
			decodeIt.put('z', 'a'); decodeIt.put('y', 'b'); decodeIt.put('x', 'c'); decodeIt.put('w', 'd'); decodeIt.put('v', 'e');
			decodeIt.put('u', 'f'); decodeIt.put('t', 'g'); decodeIt.put('s', 'h'); decodeIt.put('r', 'i'); decodeIt.put('q', 'j'); 
			decodeIt.put('p', 'k'); decodeIt.put('o', 'l'); decodeIt.put('n', 'm'); decodeIt.put('m', 'n'); decodeIt.put('l', 'o'); 
			decodeIt.put('k', 'p'); decodeIt.put('j', 'q'); decodeIt.put('i', 'r'); decodeIt.put('h', 's'); decodeIt.put('g', 't'); 
			decodeIt.put('f', 'u'); decodeIt.put('e', 'v'); decodeIt.put('d', 'w'); decodeIt.put('c', 'x'); decodeIt.put('b', 'y'); 
			decodeIt.put('a', 'z'); decodeIt.put('0', '0'); decodeIt.put('1', '1'); decodeIt.put('2', '2'); decodeIt.put('3', '3'); 
			decodeIt.put('4', '4'); decodeIt.put('5', '5'); decodeIt.put('6', '6'); decodeIt.put('7', '7'); decodeIt.put('8', '8'); 
			decodeIt.put('9', '9');
			
			//iterate over each char and decipher, concat onto 'output' string
			for(int i = 0; i < input.length(); i++) {
				output += decodeIt.get(input.charAt(i));
			}
			return output;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) % 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	
	public boolean isValidIsbn(String string) {
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

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// take out spaces
		// create a set with every letter as an element
		// if set == 26 good
		String input = string.replace(" ", "");

		Set<Character> abc = new HashSet<>();

		for (int i = 0; i < input.length(); i++) {
			abc.add(input.charAt(i));
		}
		if (abc.size() == 26) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		if(given instanceof LocalDate) {
			LocalDate date = LocalDate.of(((LocalDate) given).getYear(), ((LocalDate) given).getMonth(), ((LocalDate) given).getDayOfMonth());
			LocalDateTime dateTime = date.atStartOfDay();
			dateTime = dateTime.plusSeconds(1000000000L);
			return dateTime;
		}
		else if (given instanceof LocalDateTime) {
			LocalDateTime date = (LocalDateTime) given;
			date = date.plusSeconds(1000000000L);
			return date;
		}
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// initiate a total which is sum of all
		// iterate over each int value in the set
		// while multiple is < i {add multiples to total}
		Set<Integer> numsToAdd = new HashSet<>();
		
		int total = 0;
		for(int j = 0; j < set.length; j++) {
			int multiplier = 1;
			int add = 0;
			while((add + set[j]) < i) {
				add = set[j] * multiplier;
				multiplier++;
				numsToAdd.add(add);
			}
		}
		for(int j : numsToAdd) {
			total += j;
		}
		return total;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// remove dashes, remove spaces
		// check if all valid input (all numbers) if valid, proceed
		// get length, also maybe make some sort of counter that begins on index/length
		// of 1 from the right,
		// and decrements -2 each time
		// get every 2nd digit, starting at 1 from right, double it, if > 9, -9, throw
		// into a list
		// throw every 2nd digit, starting at the right, into the list
		// sum all
		// if sum % 10 == 0, valid

		string = string.replace(" ", "");
		List<Integer> toAdd = new ArrayList<>();
		int l = string.length();
		int f = l - 1;
		int sum = 0;
		
		// check for valid digits
		for (int i = 0; i < l; i++) {
			if ((string.charAt(i) == '0') || (string.charAt(i) == '1') || (string.charAt(i) == '2')
					|| (string.charAt(i) == '3') || (string.charAt(i) == '4') || (string.charAt(i) == '5')
					|| (string.charAt(i) == '6') || (string.charAt(i) == '7') || (string.charAt(i) == '8')
					|| (string.charAt(i) == '9')) {

			} else {
				return false;
			}
		}
		// so, all numbers are valid to this point
		// now grab the 2nd from right numbers, *2 with a condition less than 9, and add them to arraylist 'toAdd'
		while(f >= 1) {
			if((Integer.parseInt(String.valueOf(string.charAt(f - 1)))) * 2 > 9 ) {
				toAdd.add(((Integer.parseInt(String.valueOf(string.charAt(f - 1)))) * 2) -9);
				f -= 2;
			} 
			else {
				toAdd.add(((Integer.parseInt(String.valueOf(string.charAt(f - 1)))) * 2));
				f -= 2;
			}
		}
		// now grab the 2nd number starting at the end, and throw that value onto the array 'toAdd'
		f = l - 1;
		while(f >= 1) {
			toAdd.add(Integer.parseInt(String.valueOf(string.charAt(f))));
			f -= 2;
		}
		
		// sum all the numbers in the array 'toAdd'
		for(int i: toAdd) {
			sum += i;
		}
		
		// check sums validity
		if(sum % 10 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public static boolean numCheck(String string) {
		return string.matches("-?\\d+(\\.\\d+)?");
	}
	
	public int solveWordProblem(String string) {
		// break down the string to essentials
		String input = string.substring(8);
		input = input.replace("?", "");
		
		//get each element by itself
		String[] elements = input.split(" ");
		int[] numbers = new int[2];
		
		String operator = "";
		int j = 0;
		for(int i = 0; i < elements.length; i++) {
			if(numCheck(elements[i])) {
				numbers[j] = Integer.parseInt(elements[i]);
				j++;
			} 
			else if ((!numCheck(elements[i])) && !(elements[i].equals("by"))) {
				operator += elements[i];
			}
			else { 
			}
		}
		switch (operator) {
		case "plus" :
			return (numbers[0] + numbers[1]);
		case "minus" :
			return (numbers[0] - numbers[1]);
		case "multiplied" :
			return (numbers[0] * numbers[1]);
		case "divided" :
			return (numbers[0] / numbers [1]);
		}
		return 0;
	}

}
