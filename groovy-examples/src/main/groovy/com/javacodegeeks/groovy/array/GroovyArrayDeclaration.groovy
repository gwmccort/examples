package com.javacodegeeks.groovy.array

class GroovyArrayDeclaration {

	static main(args) {
		def birds = new String[3]
		birds[0] = "Parrot"
		birds.putAt(1, "Cockatiel")
		birds[2] = "Pigeon"
		
		println birds // [Parrot, Cockatiel, Pigeon]
		
		def birdArr = ["Parrot", "Cockatiel", "Pigeon"] as String[] // You say that this is an array of Strings
		
		println birdArr // [Parrot, Cockatiel, Pigeon]
	}

}
