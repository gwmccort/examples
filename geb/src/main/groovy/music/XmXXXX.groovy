package music

import geb.Browser


/**
 * print title of webquery
 */
class XmXXXX {
	static main(args) {
		Browser.drive {
			//			go "http://nile.8008/webquery"
			go 'http://beaver:8003/webquery/FrameLoader.html'
			println "wq title: $title"
		}
	}
}


