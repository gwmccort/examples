package com.javacodegeeks.groovy.closure

class ClosureDeclaration {

	static main(args) {
		def myClosure = { println "Hello World!" }
		myClosure.call() // Hello World!
		myClosure() // Hello World!
	}

}
