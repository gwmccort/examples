package com.javacodegeeks.groovy.collect

class GroovyCollectWithCollectorDistinct {

	static main(args) {
		def fruits = ["Banana", "Apple", "Grape", "Pear", "Banana"]
		def distinctFruits = fruits.collect(new HashSet(), { it })
		
		println distinctFruits // [Apple, Pear, Grape, Banana]
	}

}
