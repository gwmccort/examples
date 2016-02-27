package pdm
import spock.lang.Specification

/*
 * http://thejavatar.com/testing-with-spock/
 * https://kousenit.wordpress.com/2011/08/20/i-think-i-get-spock-mocks-now/
 */

class PdmSpec extends Specification {

	def "stub list"() {
		given: "stub a list"
		List list = Stub()
		list.size() >> 3

		expect: "size from stub"
		list.size() == 3
	}

	def "stub DomObj"() {
		when: "create stub"
		DomObj doStub = Stub()
		doStub.getMessage() >> 'from stub'
		doStub.getMap() >> ['1':'one stub']

		then: "method output from stub"
		doStub.getMessage() == 'from stub'
		doStub.getMap()['1'] == 'one stub'
	}

	def "part message with DomObj stubbed and set"() {
		when:
		DomObj domObj = Stub()
		domObj.getMessage() >> 'from stub'

		and:
		Part part = new Part()
		part.setDomObj(domObj)

		then:
		part.getPartMessage() == 'from stub'
	}

	def "part message with DomObj stubbed in constructor"() {
		when:
		DomObj domObj = Stub()
		domObj.getMessage() >> 'from stub'

		and:
		Part part = new Part(domObj)

		then:
		part.getPartMessage() == 'from stub'
	}

	def "part map with DomObj stubbed"() {
		when:
		DomObj domObj = Stub() {
			getMap() >> ['1':'one stub']
		}

		and:
		Part part = new Part(domObj)

		then:
		part.getPartMap()['1'] == 'one stub'
	}
	/*
	 def "stub StubClass"() {
	 when: "creating a stub"
	 StubClass sc = Stub()
	 sc.getMessage() >> 'from spock stub'
	 and: "injecting stub into TestClass"
	 TestClass tc = new TestClass()
	 tc.setSc(sc)
	 then: "get's message from stub"
	 tc.getStubClassInfo() == 'from spock stub'
	 }
	 def "stub with map"() {
	 when:
	 StubClass sc = Stub()
	 sc.getMap() >> ['1':'stub one']
	 and:
	 TestClass tc = new TestClass()
	 tc.setSc(sc)
	 then:
	 tc.getStubClassMap()['1'] == 'stub one'
	 }
	 def "non-stub test"() {
	 when: "creat non stub'ed StubClass"
	 TestClass tc2 = new TestClass()
	 tc2.setSc(new StubClass())
	 then: "get's message from real class"
	 tc2.getStubClassInfo() == 'from StubClass.getMessage'
	 }
	 */
}
