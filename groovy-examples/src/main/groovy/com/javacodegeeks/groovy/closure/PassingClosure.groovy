package com.javacodegeeks.groovy.closure

class PassingClosure {

	static main(args) {
		def funcClosure = { x, func ->
			func(x)
		}
		
		println funcClosure([1, 2, 3], { it.size()}) // 3
	}

}
