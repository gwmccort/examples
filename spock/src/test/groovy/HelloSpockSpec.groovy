import spock.lang.*

@Unroll("#name length is #length")
class HelloSpockSpec extends spock.lang.Specification {

	def "simple test"() {
		expect:
		"hello" == 'hello'
	}

//	@Unroll("#name length is #length")
    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }
}