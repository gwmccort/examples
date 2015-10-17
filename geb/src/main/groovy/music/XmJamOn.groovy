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
			println 'title:' + title
			println 'first channel class:' + $('td', 0, class: 'channel').text()
			println 'parent.next:' + $('td', 0, class: 'channel').parent().next().text() + ' size:' + $('td', 0, class: 'channel').parent().next().size()
			println $('td', 0, class: 'channel').parent().text()
			println $('td', 0, class: 'channel').parent().parent().text()

			println $('td', 0, class: 'channel').parent().size()
		}
	}

}
