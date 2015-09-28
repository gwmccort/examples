package com.javacodegeeks.groovy.date

import static java.util.Calendar.*

class GroovyDateSubscriptOperators {

	static main(args) {
		def date = new Date().parse("dd.MM.yyy", '18.05.1988')
		
		println date[YEAR] // 1988
		println date[MONTH] // 4
		println date[DATE] // 18
		
		date[YEAR] = 1999
		date[MONTH] = 7
		date[DATE] = 20
		
		println date // Fri Aug 20 00:00:00 EEST 1999
	}

}
