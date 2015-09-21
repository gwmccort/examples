package com.javacodegeeks.groovy.substring

class GroovySubsequence {

	static main(args) {
		def log = "Exception on saving user with username:johntheripper"
		def username = log.subSequence(log.lastIndexOf(":") + 1, log.length())
		println username // johntheripper
	}

}
