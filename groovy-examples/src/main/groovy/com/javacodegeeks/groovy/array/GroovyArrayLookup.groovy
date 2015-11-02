package com.javacodegeeks.groovy.array

class GroovyArrayLookup {

	static main(args) {
		
		def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]
		
		def revertedBirds = birds.collect { it.reverse() }
		
		println revertedBirds // [torraP, leitakcoC, noegiP]
		
		def founded = birds.find { it =~ /Cockatiel/ }
		
		println founded // Cockatiel
 	}

}
