import geb.Browser


/**
 * print title of webquery
 */
class WqTitle {
		String url = "http://nile.8008/webquery"
//	String url = "http://beaver:8003/webquery"

	static main(args) {
		Browser.drive {
			//			go "http://nile.8008/webquery"
			go "http://beaver:8003/webquery/Login.html"
			//faile cpd check?? go 'http://beaver:8003/webquery/FrameLoader.html'
			println "wq title: $title"
		}
	}

	// static main2(args) {
	// 	def b = new Browser(baseUrl: "http://nile:8008/webquery")
	// 	b.go()
	// 	println "wq title: $b.title"
	// }
}


