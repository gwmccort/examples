package com.javacodegeeks.groovy.closure

class ClosureDelegation {

	class Inner {
		Closure cl = { this }
	}
	
	static main(args) {
		def inner = new ClosureDeclaration().new Inner()
		println inner
	}

}
