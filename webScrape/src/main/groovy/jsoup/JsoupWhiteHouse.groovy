package jsoup

import org.jsoup.*

/*
 * from: http://glaforge.appspot.com/article/web-scraping-and-rest-api-calls-on-app-engine-with-jsoup-and-groovy-wslite?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+glaforge+%28Guillaume+Laforge%27s+blog+feed%29
 */

// set proxy for work
System.setProperty("https.proxyHost", "proxy")
System.setProperty("https.proxyPort", "9090")

def url = 'https://www.whitehouse.gov/the-press-office/2016/07/17/statement-president-shootings-baton-rouge-louisiana'
def doc = Jsoup.connect(url)
		.userAgent('Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0')
		.get()
println doc.select('.forall-body .field-item p').collect { it.text() }.join('\n\n')
