package gwm.lang


/**
 * Test adding Iterable to class to get all properties
 * <pre>
 * * http://mrhaki.blogspot.com/2013/11/groovy-goodness-enhancements-for.html
 * * http://naleid.com/blog/2008/12/01/groovy-makes-iteration-easy
 * * http://stackoverflow.com/questions/1477706/groovy-property-iteration
 * @author gwmccort
 *
 */
class ClassIterable implements Iterable {
	Integer maxValue
	String name
	private Integer counter = 0

	// Return new Iterator instance.
	@Override
	Iterator iterator() {
		[hasNext: { counter <= maxValue },
		 next: { counter++ }] as Iterator
	}

	static main(args) {
		def counter = new ClassIterable(maxValue: 10, name: 'glen')
		println counter.sum()

		println counter.properties

		counter.properties.each { prop, value ->
			println "prop: $prop"
			println "value: $value"
		}

		println counter.properties.collect() { prop, val ->
			if(prop in ["metaClass","class"]) return
			val
		}
	}

}
