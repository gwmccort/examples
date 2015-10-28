package com.javacodegeeks.groovy.closure

class ClosureComposition {

	static main(args) {
		
		def sum = { a, b -> return a + b }
		def square = { it * it }
		def squareOfSum = square << sum
		
		println squareOfSum(2, 3) // 25
		
	}

}
