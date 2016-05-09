package bookmarks

import groovy.xml.XmlUtil

/**
 * Use CyberNeko to parse html
 * @see <a herf="http://stackoverflow.com/questions/3025655/groovy-pretty-print-xmlslurper-output-from-html">stackoverflow</a>
 * @author gwmccort
 */
class CyberNekoExample {

	static main(args) {
		//http://mrhaki.blogspot.com/2012/10/groovy-goodness-pretty-print-xml.html
		def prettyXml = '''<?xml version="1.0" encoding="UTF-8"?><languages>
  <language id="1">Groovy</language>
  <language id="2">Java</language>
  <language id="3">Scala</language>
</languages>
'''


	  // Pretty print a non-formatted XML String.
	  def xmlString = '<languages><language id="1">Groovy</language><language id="2">Java</language><language id="3">Scala</language></languages>'
	  assert XmlUtil.serialize(xmlString) == prettyXml
	}
	static main2(args) {
		//		//		def html=new XmlSlurper(new org.cyberneko.html.parsers.SAXParser()).parseText('input/delicious.html')
		//		def html=new XmlSlurper(new SAXParser()).parse('input/delicious.html')
		//
		//		//		new XmlNodePrinter(preserveWhitespace:true).print(html)
		//
		//		println XmlUtil.serialize(html)

		def xml = "<rss><channel><title></title><description>" +
				"</description><link></link><item></item></channel></rss>"

		println XmlUtil.serialize(xml)
	}
}
