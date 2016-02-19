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

}
