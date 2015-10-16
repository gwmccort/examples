import geb.spock.GebReportingSpec

class EnoviaSpec extends GebReportingSpec {

	def setup() {
		browser.driver.javascriptEnabled = true
	}

	def "can get to enovia login"() {
		when:
		go "http://nile:8006/enovia/emxLogin.jsp"

		then:
		title == 'ENOVIA'
	}

	def "can get to enovia welcome"() {
		when:
		go "http://nile:8006/enovia"

		then:
		title == 'ENOVIA'
		currentUrl == "http://nile:8006/enovia/emxLogin.jsp"
	}

}
