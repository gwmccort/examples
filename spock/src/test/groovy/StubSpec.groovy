import spock.lang.Specification;

/*
 * http://thejavatar.com/testing-with-spock/
 * https://kousenit.wordpress.com/2011/08/20/i-think-i-get-spock-mocks-now/
 */

class StubSpec extends Specification {
	
	def "stub list"() {
		given:
		List list = Stub()
		list.size() >> 3
		
		expect:
		list.size() == 3
	}
	
	def "stub TestClass"() {
		when:
		TestClass tc = Stub()
		tc.getInfo() >> 'from stub'
		
		then:
		tc.getInfo() == 'from stub'
	}
	
	def "stub StubClass"() {
		when:
		StubClass sc = Stub()
		sc.getMessage() >> 'from spock stub'
		
		and:
		TestClass tc = new TestClass()
		tc.setSc(sc)
		
		then:
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

}
