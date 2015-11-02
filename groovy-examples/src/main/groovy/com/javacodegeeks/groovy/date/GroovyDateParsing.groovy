package com.javacodegeeks.groovy.date

import static java.util.Calendar.*

class GroovyDateParsing {

	static main(args) {
		def date = new Date().parse("dd.MM.yyy", '18.05.1988')
		println date // Wed May 18 00:00:00 EEST 1988
		
		def extendedDate = new Date().parse("dd.MM.yyy HH:mm:ss", '18.05.1988 12:15:00')
		println extendedDate // Wed May 18 12:15:00 EEST 1988
	}

}
