package music
import org.ccil.cowan.tagsoup.Parser

/**
 * Read JamBase artist pages and write artists to file.
 */

url = 'http://www.jambase.com/Artists/default.aspx?pg='
artistFile = 'outputs/jambase-artists.txt'

artists = [] as Set

// set proxy for work
workHost = 'CRP22627'
if (workHost==InetAddress.localHost.hostName) {
	System.properties << [proxyHost:'usproxy', proxyPort:'9090']
}

// read input file
artistsFile = new File(artistFile)
if (artistsFile.exists()) {
	new File(artistFile).eachLine { artists << it }
}

// read jambase artist pages
slurper = new XmlSlurper(new Parser())
for (pageNum in 1..5) {
	html = slurper.parse("$url$pageNum")
	html.'**'.find{ it.name()=='div' && it.@class=='topSearches' }.ol.li.each {
		artists << it.toString().replaceFirst(/\d+ - /, '')
	}
}

// write output file
artistsFile.withWriter { out ->
	artists.sort().each {
		out.println it
	}
}
