package com.javacodegeeks.groovy.date

import static java.util.Calendar.*

class GroovyDateFormatting {

	static main(args) {
		def date = new Date().parse("dd.MM.yyy", '18.05.1988')
		def formattedDate = date.format("dd/MM/yyy")
		println formattedDate // 18/05/1988
	}

}
