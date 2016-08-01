package jsoup

import org.jsoup.*

/*
 * from: http://glaforge.appspot.com/article/web-scraping-and-rest-api-calls-on-app-engine-with-jsoup-and-groovy-wslite?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+glaforge+%28Guillaume+Laforge%27s+blog+feed%29
 */

// set proxy for work
//System.setProperty("http.proxyHost", "proxy")
//System.setProperty("http.proxyPort", "9090")
workHost = 'CRP22627'
if (workHost==InetAddress.localHost.hostName) {
	System.properties << ['http.proxyHost':'proxy', 'http.proxyPort':'9090']
}

def url = 'http://www.jambase.com/shows?mode=all&start=20160728&address=Cedar+Rapids&region=US-IA&country=US&radius=60'
def doc = Jsoup.connect(url)
		.userAgent('Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0')
		.get()
println doc.select('.jbshow').size()
doc.select('.jbshow').each() { println it.attr('data-show-tracking-title')}
