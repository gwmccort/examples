package com.javacodegeeks.groovy.closure

class ClosureVarArgs {

	static main(args) {
		def combine = { String... names ->
			names.join(',') 
		}
		
		println combine('John', 'Doe', 'Betty') // John,Doe,Betty
	}

}
