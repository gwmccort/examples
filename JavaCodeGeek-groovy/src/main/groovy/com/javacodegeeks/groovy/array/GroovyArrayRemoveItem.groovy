package com.javacodegeeks.groovy.array

class GroovyArrayRemoveItem {

	static main(args) {
		
		def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]
		
		def birdsWithoutParrot = birds - "Parrot"
		
		println birds // [Parrot, Cockatiel, Pigeon]
		
		println birdsWithoutParrot // [Cockatiel, Pigeon]
	}

}
