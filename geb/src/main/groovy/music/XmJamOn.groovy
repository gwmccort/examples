package music

import geb.Browser

class XmJamOn {

	static main2(args) {
		println 'Junk.main()'
		Browser b = new Browser()
		b.driver.setProxy("proxy", 9090)
		b.go("http://jambase.com")
		println b.title
	}

	static main(args) {
		Browser.drive() {
			driver.setProxy("proxy", 9090)
			go 'http://dogstarradio.com/search_xm_playlist.php?channel=29'
//			go "file:///H:/Project_Files/bit-bucket/examples/geb/XmJamOn.html"

			println 'title:' + title
//			println 'first channel class:' + $('td', 0, class: 'channel').text()
//
//			println 'all tds channel class:' + $('td', class: 'channel').text()
//			def x = $('td', class: 'channel')
//			println "x size: " + x.size()
//			x.each { println "it: $it text: ${it.text()}"}
//
//			println 'parent.next:' + $('td', 0, class: 'channel').parent().next().text() + ' size:' + $('td', 0, class: 'channel').parent().next().size()
//			println $('td', 0, class: 'channel').parent().text()
//			println $('td', 0, class: 'channel').parent().parent().text()
//
//			println $('td', 0, class: 'channel').parent().size()
//
//            println 'table size:' + $('table').size()
//            println 'table text:' + $('table', 1).text()
//
//            x = $('table', 1).children()
//            println 'x:' + x.text()
//
//            println '--------------- each'
//            $('table', 1).children().each {
//                println 'it: ' + it
//                println 'it.text:' + it.text()
//            }
//
//            println '--------------------'
//            println $('table tbody tr').text()
//            $('table tbody tr', 1..-1).each { println it.text() }

//            println '-------------------------'
//            println $('table', 1).$('td')
//            $('table', 1).$('td').each {
//                println it.text()
//            }

//            println '---------eachWithIndex----------------'
//            $('table', 1).$('td').eachWithIndex { it2, index ->
////                println "$index : ${it2.text()}"
//                if (index > 8 && index < 260)
//                    println it2.text()
//            }

			println '--------- each row -------------'
////            $('table', 1).$('tr').each { println it.text()}
//            def rows = $('table', 1).$('tr')
////            rows.each {println it.text()}
////            rows.$('td', 1).each { println it.text() }
//            rows.$('td').each { println 'td: ' + it.text() }
//            println rows.$('td', 1).text()

            // WORKS - get band names
            def gr = $('table', 1).$('tr', 3..52)
            gr.each { println it.$('td', 1).text()}

            // 2nd table, 'real' rows, 2nd cell (i.e. band)
            def bands = $('table', 1).$('tr', 3..52).collect { it.$('td', 1).text()}.unique()
            println 'bands:' + bands

		}
	}

}
