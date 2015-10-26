package webquery

import geb.Browser

class WebqueryTest {
	static main(args) {

//		def b = new Browser(baseUrl: "http://nile:8008/webquery")
//		b.go()
//		println "wq title: $b.title"

		Browser.drive {
			//			go "http://nile.8008/webquery"
			go "http://beaver:8003/webquery/Login.html"
			//faile cpd check?? go 'http://beaver:8003/webquery/FrameLoader.html'
			println "wq title: $title"
		}
	}

}
