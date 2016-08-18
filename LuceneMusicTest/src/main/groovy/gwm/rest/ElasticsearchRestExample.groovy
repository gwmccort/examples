package gwm.rest

import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import groovy.json.JsonOutput
import groovyx.net.http.HTTPBuilder


/**
 * Connect to docker ElasticSearch server and get information
 * 
 * @author gwmccort
 *
 */
class ElasticsearchRestExample {

	static main(args) {
		HTTPBuilder http = new HTTPBuilder('http://192.168.99.100:9200') // docker es server

		http.get(path: '/') { resp, json ->
			println resp.status
			println json
			println JsonOutput.prettyPrint(JsonOutput.toJson(json))
			println "cluster_name: ${json.cluster_name}"
		}


		http.request(POST, JSON) {
			uri.path = '/music/_search'
			body = [
				query : [
					match : [
						name : 'World'
					]
				]
			]

			response.success = { resp, json ->
				println resp.status
				println json
				println JsonOutput.prettyPrint(JsonOutput.toJson(json))
				println "hits: ${json.hits}"
			}
		}
	}

}
