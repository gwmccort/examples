import geb.spock.GebReportingSpec
import webquery.LoginPage

class WebQuerySpec extends GebReportingSpec {

	def "can get to welcome page"() {
		when: "at webquery home"
		go "http://nile:8008/webquery"

		then:
		title == "PDM WebQuery"
	}

	def "can get to login page"() {
		when:
		go "http://nile:8080/webquery/Login.html"

		then:
		title == "PDM WebQuery"

		println $("div", 0)
	}

	def 'use page'() {
		when:
		to LoginPage

		then:
		title == 'PDM on the Web'
	}
}
