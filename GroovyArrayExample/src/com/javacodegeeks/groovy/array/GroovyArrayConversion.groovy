package com.javacodegeeks.groovy.array

class GroovyArrayConversion {

	static main(args) {
		
		def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]
		
		def birdList = birds.toList()
		
		println birdList.class.name // java.util.ArrayList
		
		def birdsAgain = birdList as String[]
		
		println birdsAgain.class.name // [Ljava.lang.String;
 	}

}
