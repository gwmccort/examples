

import geb.Browser
import geb.Page

import java.util.logging.Level
import java.util.logging.Logger

/**
 * Get bands from Xm playlist using Geb Page object
 * Created by gwmccort on 10/20/2015.
 */
class XmPlaylist {

    static main(args) {
        println 'main...'

		// shutoff htmlunit warnings, is there a better way???
		// from: http://software-testing-tutorials-automation.blogspot.com/2015/05/hide-comgargoylesoftwarehtmlunit.html
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);

		Channels.each {
			Set bands = [] as Set

			// get bands
			bands.addAll(getBands(it.channelNumber))

			// update sorted bands to file
			String fileName = it.fileName
			String[] origBands = new File(fileName)
			bands.addAll(origBands)
			new File(fileName).withWriter { out ->
				bands.sort().each {
					out.println it
				}
			}
		}

        println 'finished!'
    }

    private static Set getBands(channel) {
        Set results = [] as Set
        Browser.drive(baseUrl: 'http://dogstarradio.com') {

//			println "driver: $it.getDriver()"

            //TODO auto set proxy better way
            def workHost = 'CRP22627'
            if (workHost == InetAddress.localHost.hostName) {
                driver.setProxy("proxy", 9090)
            }

            to XmPlaylistPage, channel
			//TODO get rid of this method & is assert needed???
            assert at(XmPlaylistPage)
            results = bands
        }
        results
    }
}

class XmPlaylistPage extends Page {

    // url of page
    static url = '/search_xm_playlist.php'

    // check page is opened
    static at = { title == 'XM Playlist Search - XM Satellite Radio - DogstarRadio.com' }

    static content = {
        bands {
			//TODO rows are hard coded length

			// make sure rows size ok
			def playListRows = $('table', 1).$('tr')
			if (playListRows.size() == 54) {
				// 2nd table, rows with bands, 2nd cell (i.e. band)
//				return $('table', 1).$('tr', 3..52).collect { it.$('td', 1).text() }.unique()
				return playListRows[(3..52)].collect { it.$('td', 1).text() }.unique()
			}
			else {
				return []
			}
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
    JAM_ON('29', 'output/jamon.txt'),
	BLUEGRASS('61', 'output/bluegrass.txt')

    final String channelNumber
	final String fileName

    private Channels(String cn, String fn) {
        channelNumber = cn;
		fileName = fn
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : channelNumber.equals(otherName);
    }

    public String toString() {
        return this.channelNumber;
    }
}


