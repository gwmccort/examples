package music

import org.ccil.cowan.tagsoup.Parser

/**
 * Get's a list of artists from XM Playlist site using tagsoup
 */

//url = 'http://dogstarradio.com/search_xm_playlist.php?artist=&title=&channel=29&month=&date=&shour=&sampm=&stz=&ehour=&eampm='
//url = 'http://dogstarradio.com/search_xm_playlist.php?channel=61'
baseUrl = 'http://dogstarradio.com/search_xm_playlist.php?channel='

//channels numbers
channels = [JamOn:29, Bluegrass:61]

// set proxy for work
workHost = 'CRP22627'
if (workHost==InetAddress.localHost.hostName) {
	System.properties << [proxyHost:'proxy', proxyPort:'9090']
}

// turn off tagsoup namespace
// http://stackoverflow.com/questions/5780225/extracting-parts-of-html-with-groovy/5781193#5781193
tsParser = new Parser()
tsParser.setFeature(Parser.namespacesFeature, false)
slurper = new XmlSlurper(tsParser)

channels.each { name, number ->
	artists = [] as Set

	// read input file
	artistsFile = new File("output/xm${name}.txt")
	if (artistsFile.exists()) {
		artistsFile.eachLine { artists << it }
	}

	// process web page
	html = slurper.parse(baseUrl + number)
	table = html.body.'**'.findAll{it.name()=='table'}[1]
	table.tr.each {
		if (it.children().size()==5 && !(it.td[1].text()=='Artist' || it.td[1].text().startsWith('fb.com'))){
			artists << it.td[1].text()
		}
	}

	// write output file
	artistsFile.withWriter { out ->
		artists.sort().each {
			out.println it
		}
	}

}
