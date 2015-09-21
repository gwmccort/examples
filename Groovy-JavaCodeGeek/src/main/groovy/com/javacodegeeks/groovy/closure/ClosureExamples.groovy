package com.javacodegeeks.groovy.closure

/**
 *
 * @author akin  akin.kaldiroglu@javacodegeeks.com 
 */
class ClosureExamples {

	static main(args) {
		//		callSimpleClosures();
		//		callAClosure1();
		//		callAClosure2()
		//		callAClosure3()
		//		closureForCollections()
		//		callAMethod();
	}

	public static callSimpleClosures(){

		def aString = { "hello" }.call();

		println aString;

		{ it -> println it }.call(5);

		{ name -> println name }.call("Java");

		{double x, double y -> println Math.pow(x, y)}.call(2, 8);
	}

	def static callAClosure1(){
		def closure = { 10 }       // Defining a closure of value "10"
		println(closure.call())    // Will print out "10"
		assert closure() == 10     // Assertion holds true

		def b = closure instanceof Closure
		println(b)                 // Prints true
	}

	def static callAClosure2(){
		def closure2 = { print 10 }     // Defining a closure to print "10"
		closure2.call()         		// Will print out "10"
	}

	def static callAClosure3(){
		def closure3 = { println it }   // Defining a closure to print the passed parameter
		closure3.call(5)         		// Will print out "5"
		closure3.call() ;        		// Will print out "null"
		{ it -> println it }.call(5)    // Will print out "5"
	}

	def static closureForCollections(){
		def List numbers = [1, 2, 3, 5, 8, 13, 21]
		for(n in numbers)
			print n
		println("\nUsing closures")
		numbers.each {print it + ', '}

		println ""

		def found = numbers.find {it % 2 == 0}
		println(found)

		List foundNumbers = numbers.findAll {it % 2 == 0}
		println(foundNumbers)
	}

	def static callAMethod(){

		def aClosure = { it -> println it }

		aMethod(10, aClosure);

		aMethod(10, { it -> println it })

		aMethod(10) { it -> println it }

		aMethod(23, aClosure);
	}

	def static aMethod(int i, closure){
		println"Here is the output of passed closure:"
		closure(i)
	}
}
