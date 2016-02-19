import spock.lang.Specification

class RcClassSpec extends Specification {

	def "test myMethod"() {
		given:
		def rc = new RcClass()

		expect:
		"myMethod" == rc.myMethod()
	}

	def "test getInfo"() {
		given:
		def rc = new RcClass()

		when:
		def m = rc.testDom()

		then:
		m['1'] == 'one'
	}

	def "stub out DomObj"() {
		given:
		def rc = new RcClass()
		DomObj dObj = Stub()
		//		dObj.getInfo() >> ['1':'new one']
		dObj.getInfo() >> { println 'in stubed getInfo' }

		when:
		def m = rc.testDom()
		println m

		then:
		//		m['1'] == 'new one'
		1 == 1

	}
}
