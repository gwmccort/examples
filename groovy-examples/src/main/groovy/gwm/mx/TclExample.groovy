package gwm.mx

import groovy.transform.ToString

class TclExample {

	/*
	 MQL<17>print rel "Affected Item" select totype fromtype tcl;
	 {{relationship type} {Affected Item} {{totype} {{totype} {Part}} {{totype} {CAD Drawing}} {{totype} {CAD Model}} {{totype} {Drawing Print}} {{totype} {Part Specification}}} {{fromtype} {{fromtype} {Change}}}}
	 MQL<19>print rel "Affected Item" select totype fromtype ;
	 relationship type   Affected Item 
	 totype = Part
	 totype = CAD Drawing
	 totype = CAD Model
	 totype = Drawing Print
	 totype = Part Specification
	 fromtype = Change
	 */

	static main55(args) {
		new File('x.dot').withWriter { out ->
			out.println 'digraph {'
			out.println 'a -> b[label="rel1"];'
			out.println 'b -> c[label="rel2"];'
			out.println 'c -> a[label="rel3"];'
			out.println '}'
		}
	}

	static main6(args) {
		def rels = []
		rels << new Relationship(name: 'rel1', totype:['Part', 'Part2'], fromtype:['Part3', 'Part4'])
		rels << new Relationship(name: 'rel1', totype:['Part5', 'Part2'], fromtype:['Part6', 'Part7'])

		new File('graph.dot').withWriter { out ->
			out.println 'digraph {'
			rels.each { rel ->
				rel.totype.each { to ->
					rel.fromtype.each { from ->  out.println "$to -> $from[label=\"$rel.name\"];" }
				}
			}
			out.println '}'
		}
	}


	static main(args) {

		// read tcl as json
		//		def jsonSlurper = new JsonSlurper()
		//		def object = jsonSlurper.parseText('{{relationship type} {Affected Item}}')
		//		println object

		// read string into a list
		//		def s = '[ [type], [name] ]'
		//		def s = '[10, 1, 9]'
		//		def s = "['name', 'type']"
		//		def l = Eval.me(s)
		//		println l


		//		def s = '{{relationship type} {Affected Item}}'

		//		def j = '{"relationship type":"Affected Item", "totype":["Part", "CAD Draing"], "fromtype":["Change"]}'
		////				def j = '{"firstName":"John", "lastName":"Doe"}'
		//		def js = new JsonSlurper()
		//		def o = js.parseText(j)
		//		println o
		////		println o.firstName
		//		println o.'relationship type'
		//		println o.totype
		//		println o.fromtype


		def s = '''
		relationship type   Affected Item
		totype = Part
		totype = CAD Drawing
		totype = CAD Model
		totype = Drawing Print
		totype = Part Specification
		fromtype = Change
		'''
		//
		//		s.eachLine {
		////			println "-- $it"
		//			def m = it =~ /^\s+(?<name>.*) = (?<value>.*)$/
		//			if (m.matches()) {
		////				println 'Matches'
		//				println "name: '${m.group('name')}'"
		//				println "value: '${m.group('value')}'"
		//			}
		//			else {
		////				println 'No Match'
		//			}
		//		}

		def rels = []
		def rel

		def regex = ~/^\s+(?<key>.*) = (?<value>.*)$/
		new File(/C:\Users\Glen\Downloads\rel.txt/).eachLine {
			//			println "---------- $it"
			def m = (it =~ regex)
			if (m.matches()) {
				//				println "${m.group('key')} : ${m.group('value')}"
				def key = m.group('key')
				def value = m.group('value')
				switch (key) {
					case 'name':
					//						println rel
					//						println !rel
					//						System.exit(0)
						if (rel) {
							//							println 'adding $rel'
							rels << rel
						}
						rel = new Relationship(name: value)
						break
					case 'totype':
						rel.totype << value
						break
					case 'fromtype':
						rel.fromtype << value
						break
				}

			}
			//			else println "----------NO MATCH: $it"
		}

		println "rels size: $rels.size"

		rels.each { println it }
		
		new File('graph.dot').withWriter { out ->
			out.println 'digraph {'
			rels.each { rel2 ->
				rel2.totype.each { to ->
					rel2.fromtype.each { from ->  out.println "  \"$to\" -> \"$from\"[label=\"$rel.name\"];" }
				}
			}
			out.println '}'
		}
	}
}

@ToString
class Relationship {
	String name
	List totype = []
	List fromtype = []
}
