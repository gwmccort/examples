package gwm.mx

import groovy.json.JsonSlurper

class TclExample {

	static main(args) {
		def jsonSlurper = new JsonSlurper()
		def object = jsonSlurper.parseText('{{relationship type} {Affected Item}} ')
		println object
	}

}
