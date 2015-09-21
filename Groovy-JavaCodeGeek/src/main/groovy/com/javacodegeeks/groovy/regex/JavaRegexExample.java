package com.javacodegeeks.groovy.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegexExample {
	private static String myString = "I love Groovy but to me Java is more lovely than Groovy!";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a pattern: ");
		Pattern pattern = Pattern.compile(scanner.next());
		Matcher matcher = pattern.matcher(myString);
		printMatcher(matcher);
	}

	/**
	 * List all occurrences of the pattern.
	 * @param matcher Matcher object built upon the pattern and string.
	 */
	private static void printMatcher(Matcher matcher) {
		boolean found = false;
		while (matcher.find()) {
			found = true;
			System.out.format("Matching  text: " + " \"%s\" starting at " + "index %d and ending at index %d.%n",
					matcher.group(), matcher.start(), matcher.end());
		}
		if (!found)
			System.out.println("No match found!");
	}
}
