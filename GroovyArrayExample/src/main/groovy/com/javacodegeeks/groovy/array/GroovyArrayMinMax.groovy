package com.javacodegeeks.groovy.array

class GroovyArrayMinMax {

	static main(args) {
		
		def numbers = [32, 44, 12, 9, 100, 180]
		
		println numbers.max() // 180
		println numbers.min() // 9
		
		def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]
		
		println birds.max { it.size() } // Cockatiel
		println birds.min { it.size() } // Parrot
	}

}
