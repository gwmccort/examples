package com.javacodegeeks.groovy.substring

class GroovyGetAt {

	static main(args) {
		def text1 = "crazy fox jumps over lazy dog"
		println text1.getAt(0..(text1.length() - 5)) // crazy fox jumps over lazy  
		
		def text2 = "keep calm and carry on"
		println text2.getAt(-1..5) // no yrrac dna mlac
	}

}
