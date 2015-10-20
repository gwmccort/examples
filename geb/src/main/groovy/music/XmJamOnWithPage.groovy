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

        Browser.drive(baseUrl: 'http://dogstarradio.com') {

            //TODO auto set proxy better way
            def workHost = 'CRP22627'
            if (workHost==InetAddress.localHost.hostName) {
                driver.setProxy("proxy", 9090)
            }

//            to XmJamOnPage, Channels.JAMON
            to XmJamOnPage, Channels.BLUEGRASS
            assert at(XmJamOnPage)

            println bands
        }

        println 'finished!'
    }
}

class XmJamOnPage extends Page {

    // url of page
    static url = '/search_xm_playlist.php'

    // check page is opened
    static at = { title == 'XM Playlist Search - XM Satellite Radio - DogstarRadio.com' }

    static content = {
        bands {
            // 2nd table, rows with bands, 2nd cell (i.e. band)
            $('table', 1).$('tr', 3..52).collect { it.$('td', 1).text() }.unique()
        }
    }

    // convert parameter arguments
    //TODO add date range
    String convertToPath(Object[] args) {
        args ? '?channel=' + args[0] : ""
    }
}

//TODO is this the best way to get constants
public enum Channels {
    JAMON('29'), BLUEGRASS('61')

    private final String channelNumber

    private Channels(String s) {
        channelNumber = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : channelNumber.equals(otherName);
    }

    public String toString() {
        return this.channelNumber;
    }
}


