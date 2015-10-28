package com.javacodegeeks.groovy.closure

class ClosureParameters {

	static main(args) {
		
		def squareWithImplicitParameter = { it * it }
		println squareWithImplicitParameter(4) // 16
		
		def sumWithExplicitTypes = { int a, int b -> return a + b }
		println sumWithExplicitTypes(11, 8) // 19
		
		def sumWithOneExplicitOneOptionalTypes = { int a, b -> return a + b }
		println sumWithOneExplicitOneOptionalTypes(20, 13) // 33
		
		def sumWithDefaultParameterValue = { a, b = 5 -> return a + b }
		println sumWithDefaultParameterValue(4)  // 9
		
	}

}
