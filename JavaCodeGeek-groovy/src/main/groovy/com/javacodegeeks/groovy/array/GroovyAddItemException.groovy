package com.javacodegeeks.groovy.array

class GroovyAddItemException {

	static main(args) {
		def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]
		
		birds << "Eagle" // MissingMethodException
		
		birds.putAt(3, "Owl") // ArrayIndexOutOfBoundsException
	}

}
