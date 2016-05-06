package music
import org.ccil.cowan.tagsoup.Parser

/**
 * Read JamBase schedule for Cedar Rapids area.
 */

url = 'http://www.jambase.com/shows/Shows.aspx?Zip=52403&radius=50&pasi=1500'

// set proxy for work
workHost = 'CRP17843'
if (workHost==InetAddress.localHost.hostName) {
	System.properties << [proxyHost:'usproxy', proxyPort:'9090']
}

// read jambase schedule page
slurper = new XmlSlurper(new Parser())
html = slurper.parse(url)
//html.'**'.find{ it.name()=='table' && it.@class=='showList' }.tr.td.each {
//	//println "class: ${it.@class}"
//	if (it.@class=='') println "date: $it"
//	if (it.@class=='artistCol') println "artist: $it"
//	if (it.@class=='venueCol') println "venue: $it"
//	if (it.@class=='locationCol') println "location: $it"
//}

date = ''
artist = ''
venue = ''
loc = ''
html.'**'.find{ it.name()=='table' && it.@class=='showList' }.tr.each {
//		println "tag: ${it.name()} value: $it class: '${it.@class}'"
	if (it.@class=='dateRow') {
		//println "date: ${it.td}"
		date = it.td
		artist = venue = loc = ''
	}
	else {

//		it.td.findAll{it.@class=='artistCol' || it.@class=='venueCol' || it.@class=='locationCol'}.each {
//			println "class ${it.@class} $it"
//		}

		//works
		it.td.each {
			switch (it.@class) {
				case 'artistCol':
					artist = it
					break
				case 'venueCol':
					venue = it
					break
				case 'locationCol':
					loc = it
					println "date:$date art:$artist venue:$venue loc:$loc"
					break
//				default:
//					println "date:$date art:$artist venue:$venue loc:$loc"
//					break
			}
		}


	}
}
