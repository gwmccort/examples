package com.javacodegeeks.groovy.collect

import groovy.transform.ToString

class GroovyCollectForClass {

	static main(args) {
		def fruits = ["Banana", "Apple", "Grape", "Pear"]
		def fruitObjects = fruits.collect { new Fruit(name: it) }
		println fruitObjects // [com.javacodegeeks.groovy.collect.Fruit(name:Banana, amount:0), com.javacodegeeks.groovy.collect.Fruit(name:Apple, amount:0), com.javacodegeeks.groovy.collect.Fruit(name:Grape, amount:0), com.javacodegeeks.groovy.collect.Fruit(name:Pear, amount:0)]
	}

}

@ToString(includeNames = true)
class Fruit {
	def name
	def amount = 0
}
