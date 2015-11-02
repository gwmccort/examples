package com.javacodegeeks.groovy.collect

class GroovyCollectWithCollector {

	static main(args) {
		def initialFruits = ["Orange", "Lemon"]
		def fruits = ["Banana", "Apple", "Grape", "Pear"]
		def totalFruits = fruits.collect(initialFruits, { it.toUpperCase() })
		
		println totalFruits // [Orange, Lemon, BANANA, APPLE, GRAPE, PEAR]
		println initialFruits // [Orange, Lemon, BANANA, APPLE, GRAPE, PEAR]
	}

}
