package com.javacodegeeks.groovy.regex

import java.util.regex.Matcher
import java.util.regex.Pattern

class GroovyRegexExample {
	static String myString = "I love Groovy but to me Java is more lovely than Groovy!"

	static main(args) {
		def pattern
		System.in.withReader {
			print  'Enter a pattern: '
			pattern = it.readLine()
		}

		exactMatch(pattern)
		printMatcher(pattern)
	}

	/**
	 * Checks if there is an exact match.
	 * @param pattern Given pattern.
	 */
	static void exactMatch(pattern){
		def b = myString ==~ pattern
		if(b)
			println('Exact match!')
		else
			println('Not exact match!')
	}

	/**
	 * List all occurrences of the pattern.
	 * @param pattern Given pattern.
	 */
	static void printMatcher(pattern) {
		def matcher = myString =~ pattern
		while (matcher.find()) {
			System.out.format("Matching  text: " + " \"%s\" starting at " + "index %d and ending at index %d.%n",
					matcher.group(), matcher.start(), matcher.end())
		}
	}
}
