package com.javacodegeeks.groovy.closure

/**
 *
 * @author akin akin.kaldiroglu@javacodegeeks.com
 */
class EvenNumberCalculationsWithClosure {

	static main(args) {
		def obj = new EvenNumberCalculationsWithClosure()
		obj.pickEvenNumbers(10, { println it })
		
		def total = 0
		obj.pickEvenNumbers(10) { total += it }
		println('Total: ' + total)
		
		def product = 1
		obj.pickEvenNumbers(10) { product *= it }
		println('Product: ' + product)
		
		def squared = []
		obj.pickEvenNumbers(10) { squared << it ** 2 }
		println('Squared: ' + squared)
	}

	def pickEvenNumbers(n, block) {
		for(int i = 2; i <= n; i += 2) {
			block(i)
		}
	}
}
