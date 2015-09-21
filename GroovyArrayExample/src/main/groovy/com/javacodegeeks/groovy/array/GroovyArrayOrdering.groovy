package com.javacodegeeks.groovy.array

class GroovyArrayOrdering {

	static main(args) {
		
		def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]
		
		println birds.reverse() // [Pigeon, Cockatiel, Parrot]
		
		println birds.sort() // [Cockatiel, Parrot, Pigeon]
	}

}
