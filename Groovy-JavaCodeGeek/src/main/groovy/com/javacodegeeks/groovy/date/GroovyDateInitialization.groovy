package com.javacodegeeks.groovy.date

import static java.util.Calendar.*

class GroovyDateInitialization {

	static main(args) {
		def date = new Date()
		println date // Sat Sep 26 19:22:50 EEST 2015
		
		def calendar = Calendar.instance
		println calendar // java.util.GregorianCalendar[time=1443284933986,areFieldsSet=true ...
	}

}
