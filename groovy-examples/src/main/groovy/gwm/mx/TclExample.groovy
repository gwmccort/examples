package gwm.mx

import groovy.transform.ToString
import groovy.util.logging.Slf4j

@Slf4j
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

		def relationships = readRelationships()

		println "rels size: $relationships.size"

		//		rels.each { println it }
		//
		printGraph(relationships)
	}

	private static printGraph(List relationships) {
		new File('graph.dot').withWriter { out ->
			out.println 'digraph {'

			relationships.each { rel ->
				//				if (rel.name == 'Affected Item') {

				boolean isPrint = false
				String printType = 'Organization'

				rel.totype.each { to ->

					if (to == printType) {
						log.info 'rel:{} to:{}', rel.name, to
						isPrint = true
					}

					rel.fromtype.each { from ->
						if (isPrint || from == printType) {
							log.info 'rel:{} isPrint:{} from:{}', rel.name, isPrint, from
							out.println "  \"$to\" -> \"$from\"[label=\"$rel.name\"];"
						}
					}
				}

				//				}

			}

			out.println '}'
		}
	}

	static List readRelationships() {
		def rels = []
		def rel

		def keyValueRegex = ~/^\s+(?<key>.*) = (?<value>.*)$/
		new File(/C:\Users\Glen\Downloads\rel.txt/).eachLine {
			//		new File(/H:\Project_Files\PdmUpgrade\Schema\relationship.txt/).eachLine {
			//			println "---------- $it"
			def m = (it =~ keyValueRegex)
			if (m.matches()) {
				//				println "${m.group('key')} : ${m.group('value')}"
				def key = m.group('key')
				def value = m.group('value')
				switch (key) {
					case 'name':
					// add rel to list
						if (rel) {
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
		return rels
	}

}

@ToString
class Relationship {
	String name
	List totype = []
	List fromtype = []
}
