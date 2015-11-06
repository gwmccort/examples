package com.javacodegeeks.groovy.lang

/**
 * Example of groovy safe navigator expression.
 * from: https://tedvinke.wordpress.com/2015/09/25/avoid-nullpointerexception-safe-navigation-with-groovy/
 *
 * @author gwmccort
 *
 */
class SafeNavigation {
	static main(args) {
		def animal = new Animal(name: "Bella") // no parent

		def parentName
		try {
			// BLAM! java.lang.NullPointerException:
			// Cannot get property 'name' on null object
			parentName = animal.parent.name
		}
		catch (Exception ex) {
			println 'Caught null pointer trying to access parent.name'
			println ex
		}

		parentName = animal?.parent?.name
		println parentName

	}
}

class Animal {
	String name
	Animal parent
}
