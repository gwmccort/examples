package gwm.logging

import groovy.util.logging.Slf4j

@Slf4j
class LogginAnnotation {

	static main(args) {
		log.info "info test"
		log.info 'one:{} two:{}', 1, 2
		
	
	}

}
