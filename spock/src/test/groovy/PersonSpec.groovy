import spock.lang.Specification

class PersonSpec extends Specification {

	def "always pass nul = null"() {
		expect:
		null == null
	}

	def "person created ok"() {
		given: 'a person'
		def p = new Person(name: 'glen', age: 54)

		expect: 'name & age same'
		p.name == 'glen'
		p.age == 54
	}

	def "person equality"() {
		expect:
		new Person(name: 'glen', age: 54) == new Person(name: 'glen', age: 54)
	}

	def "toString annotation"() {
		given:
		def p = new Person(name: 'glen', age: 54)

		expect:
		p.toString() == 'Person(glen, 54)'
	}

}
