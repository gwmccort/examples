package goodness.logging

import groovy.util.logging.Log

@Log
class LogAnnotation {

	static main(args) {
		log.info('This is info.')
		log.fine('This is an fine.')
		log.warning('This is an warning.')
		log.severe('This is sever')
	}

}

/*
// from: http://mrhaki.blogspot.com/2011/04/groovy-goodness-inject-logging-using.html
// File: LogSlf4j.groovy
// Add dependencies for Slf4j API and Logback
@Grapes([
	@Grab(group='org.slf4j', module='slf4j-api', version='1.6.1'),
	@Grab(group='ch.qos.logback', module='logback-classic', version='0.9.28')
])
import org.slf4j.*
import groovy.util.logging.Slf4j

// Use annotation to inject log field into the class.
@Slf4j
class HelloWorldSlf4j {
	def execute() {
		log.debug 'Execute HelloWorld.'
		log.info 'Simple sample to show log field is injected.'
	}
}

def helloWorld = new HelloWorldSlf4j()
helloWorld.execute()
*/
