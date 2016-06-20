package gwm.mx

import groovy.transform.ToString

@ToString
class Collections {
	String name
	def toType = []
	
	static main(args) {
		def l = []
		l << new Collections(name: 'name1', toType: ['t1', 't2'])
		l << new Collections(name: 'name2', toType: ['t1', 't3'])
		
		def l2 = l.findAll {
//			it.name == 'name1'
			it.toType.contains('t3')
		}
		
		println l2
		
	
	}

}

