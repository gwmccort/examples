package music

import geb.Page
import geb.Browser

/**
 * Get ageists from Xm playlist using Geb Page object
 * Created by gwmccort on 10/20/2015.
 */
class XmJamOnWithPage {

    static main(args) {
        println 'main...'
        Browser.drive() {
            driver.setProxy("proxy", 9090)//why do i need this for file url???
            to XmJamOnPage
            assert at(XmJamOnPage)

            println bands
        }

        println 'finished!'
    }
}

class XmJamOnPage extends Page {
    // url of page
//    static url = "file:///H:/Project_Files/bit-bucket/examples/geb/XmJamOn.html"
    static url = 'http://dogstarradio.com/search_xm_playlist.php?channel=29'

    // check page is opened
    static at = { title == 'XM Playlist Search - XM Satellite Radio - DogstarRadio.com' }

    static content = {
        bands {
            // 2nd table, rows with bands, 2nd cell (i.e. band)
            $('table', 1).$('tr', 3..52).collect { it.$('td', 1).text() }.unique()
        }
    }
}
