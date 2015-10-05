package com.javacodegeeks.groovy.collect

class GroovyCollect {

	static main(args) {
		def fruits = ["Banana", "Apple", "Grape", "Pear"]
		def upperCaseFruits = fruits.collect { it.toUpperCase() }
		println upperCaseFruits // [BANANA, APPLE, GRAPE, PEAR]
	}

}
