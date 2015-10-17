package music

import geb.Browser

class JamBase {

	static main2(args) {
		println 'Junk.main()'
		Browser b = new Browser()
		b.driver.setProxy("proxy", 9090)
		b.go("http://jambase.com")
		println b.title
	}

	static main(args) {
		Browser.drive() {
			driver.setProxy("proxy", 9090)
			go "http://jambase.com"
			println title
		}
	}

}
