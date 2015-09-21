package com.javacodegeeks.groovy.array

class GroovyArrayLength {

	static main(args) {
		def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]
		
		println birds.length // 3
		
		println birds.size() // 3
	}

}
