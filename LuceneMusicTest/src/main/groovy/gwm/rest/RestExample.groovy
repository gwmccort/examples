package gwm.rest

import groovyx.net.http.HTTPBuilder


class RestExample {

	static main(args) {

		//		def http = new HTTPBuilder( 'http://api.openweathermap.org/data/2.5/' )
		//
		//		http.get( path: 'weather', query: [q: 'London'] ) { resp, json ->
		//
		//			println resp.status
		//
		//			println "It is currently ${json.weather.main[0]} in London."
		//			println "The temperature is ${json.main.temp} degrees Kelvin"
		//		}

		//		HTTPBuilder http = new HTTPBuilder('http://192.168.99.100:9200/?pretty')
		HTTPBuilder http = new HTTPBuilder('http://192.168.99.100:9200')

		def html = http.get(path: '/') { resp, json ->

			println resp.status

			println "cluster_name: ${json.cluster_name}"

			println json
		}

	}

	static main2(args) {
		HTTPBuilder http = new HTTPBuilder('http://www.google.com')

		def html = http.get( path : '/search', query : [q:'Groovy'] )

		println html
	}
}
