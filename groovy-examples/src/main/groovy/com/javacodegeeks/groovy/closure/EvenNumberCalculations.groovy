package com.javacodegeeks.groovy.closure

/**
 * 
 * @author akin akin.kaldiroglu@javacodegeeks.com
 */
class EvenNumberCalculations {

	static main(args) {
		def obj = new EvenNumberCalculations()
		
		obj.printEvenNumbers(10)
		
		def result = obj.calculateSumOfEvenNumbers(10);
		println('Total: ' + result)

		result = obj.calculateProductOfEvenNumbers(10);
		println('Product: ' + result)
		
		result = obj.calculateSquareOfEvenNumbers(10);
		println('Squared: ' + result)
	}
	
	def printEvenNumbers(int n){
		for(int i = 2; i <= n; i += 2) {
			println(i)
		}
	}

	int calculateSumOfEvenNumbers(int n){
		def sum = 0;
		for(int i = 2; i <= n; i += 2) {
			sum += i
		}
		return sum;
	}

	int calculateProductOfEvenNumbers(int n){
		def product = 1;
		for(int i = 2; i <= n; i += 2) {
			product *= i
		}
		return product;
	}

	int[] calculateSquareOfEvenNumbers(int n){
		def squared = []
		for(int i = 2; i <= n; i += 2) {
			squared << i ** 2
		}
		return squared;
	}
}
