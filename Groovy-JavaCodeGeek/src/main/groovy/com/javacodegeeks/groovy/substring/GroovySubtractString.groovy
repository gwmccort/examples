package com.javacodegeeks.groovy.substring

class GroovySubtractString {

	static main(args) {
		def text1 = "Sorry, I need to separate from you"
		println text1 - " you" // Sorry, I need to separate from
		
		def text2 = "Minus string usage"
		println text2.minus(" usage") // Minus string
	}

}
