package music.home

import geb.Browser

class JamBase {

	static main(args) {
		Browser.drive() {
			go "http://jambase.com"
			println title
		}
	}

}
