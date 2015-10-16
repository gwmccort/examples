import geb.*

/**
 * print title of webquery
 */
class WqTitle {
	static main(args) {
		def b = new Browser(baseUrl: "http://nile:8008/webquery")
		b.go()
		println "wq title: $b.title"
	}
}


