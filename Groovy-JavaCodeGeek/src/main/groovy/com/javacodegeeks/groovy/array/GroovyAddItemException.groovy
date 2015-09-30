package com.javacodegeeks.groovy.array

class GroovyAddItemException {

	static main(args) {
		def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]

		try {
			birds << "Eagle" // MissingMethodException
		} catch (Exception e) {
			println 'MissingMethodException'
			println e
			//			e.printStackTrace()
		}

		println ''

		try {
			birds.putAt(3, "Owl") // ArrayIndexOutOfBoundsException
		} catch (Exception e) {
			println 'ArrayIndexOutOfBoundsException'
			println e
			//			e.printStackTrace()
		}
	}

}
