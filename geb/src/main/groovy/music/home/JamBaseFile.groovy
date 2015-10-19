package music.home

import geb.Browser

class JamBaseFile {

	static main(args) {
		Browser.drive() {
			go "file:///H:/Project_Files/bit-bucket/examples/geb/JamBase.html"
			println title
			println 'first channel class:' + $('td', 0, class: 'channel').text()
		}
	}

}
