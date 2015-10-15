package com.mrhaki.spock

//@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.Specification
import spock.lang.Subject

/**
 * Spocklight: Mocks And Stubs Returning Sequence of Values
 * from: Spocklight: Mocks And Stubs Returning Sequence of Values
 *
 * @author gwmccort
 *
 */

class SampleSpec extends Specification {

    @Subject
    def util = new StringUtil()

    def "Calculate sizes of String values"() {
        given:
        def calculator = Mock(Calculator)
        util.calculator = calculator

        when:
        def total = util.size('one', 'two', 'three', 'four', 'five')

        then:
        5 * calculator.calculateSize(_) >>> [1,3,4]

        total == 1 + 3 + 4 + 4 + 4
    }

}

class StringUtil {
    def calculator

    int size(final String[] s) {
        s.sum { calculator.calculateSize(it) }
    }
}

interface Calculator {
    int calculateSize(final String s)
}