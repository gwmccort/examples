	package com.javacodegeeks.groovy.array
	
	class GroovyArrayAccessItem {
	
		static main(args) {
			
			def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]
			
			println birds[0] // Parrot
			println birds[2] // Pigeon
			println birds.getAt(1) // Cockatiel
			
			println birds[-1] // Pigeon
			println birds[-3] // Parrot
		}
	
	}
