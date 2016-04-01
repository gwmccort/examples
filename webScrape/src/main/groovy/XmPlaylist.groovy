import geb.Browser
import geb.Page
import groovy.util.logging.Slf4j

import java.util.logging.Level
import java.util.logging.Logger

/**
 * Get bands from Xm playlist using Geb Page object
 *<p>
 * <b>Issues:</b>
 * <ul>
 *     <li>output isn't being sorted
 * </ul>
 *
 * @author Created by gwmccort on 10/20/2015.
 */
@Slf4j
class XmPlaylist {

	static main(args) {
		println 'XmPlaylist.main...'
		log.trace 'main'

		// shutoff htmlunit warnings, is there a better way???
		// from: http://software-testing-tutorials-automation.blogspot.com/2015/05/hide-comgargoylesoftwarehtmlunit.html
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);

		Channels.each {
			log.info('channel:{}', it.channelNumber)
			Set bands = [] as Set



			// get bands
			bands.addAll(getBands(it.channelNumber))

			//XXX
//			println "channel:$it bands:${bands}"

			// update sorted bands to file
			String fileName = it.fileName
			String[] origBands = new File(fileName)
			bands.addAll(origBands)
			new File(fileName).withWriter { out ->
				bands.each { out.println it }
			}
		}

		println 'finished!'
		log.trace 'main finished!'
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
//			assert at(XmPlaylistPage)
			//            results = bands
			//            results = bands ?: []
			if (bands == null) {
				results = []
//				println 'bands null'
			}
			else {
				results = bands
//				println "bands: $bands"
			}
		}
		results
	}
}

/**
 * Geb Page object for dogstar radio search results
 */
@Slf4j
class XmPlaylistPage extends Page {

	/** url of page */
	static url = '/search_xm_playlist.php'

	/** check page is opened */
	static at = { title == 'XM Playlist Search - XM Satellite Radio - DogstarRadio.com' }

    /** context of page */
	static content = {
		bands {
			//TODO rows are hard coded length to 54 entries per page!!!

			// make sure rows size ok
			def playListTbl = $('table', 1) //second table
			try {
//								println "size: $playListRows.size() class: ${playListRows.class}"
//								println "in try class: ${playListRows.class}"
//								println "pl text:" + playListRows.text()

				int tableSize = playListTbl.$('tr').size()
                log.debug("payListTbl rows: {}", tableSize)

				//needed to add size???
//				if (playListTbl.$('tr').size() == 54) {
				if (tableSize>5) {
//					println 'tr == 54'
//					return playListTbl.$('tr', 3..52).collect { it.$('td', 1).text() }.unique()
					return playListTbl.$('tr', 3..tableSize-2).collect { it.$('td', 1).text() }.unique()
				}
				else {
//					println 'tr != 54 return blank list'
					return []
				}
			}
			catch (e) {
				println e
			}
			//			return $('table', 1).$('tr', 3..52).collect { it.$('td', 1).text() }.unique()

			//			if (playListRows.size() == 54) {
			//				// 2nd table, rows with bands, 2nd cell (i.e. band)
			////				return $('table', 1).$('tr', 3..52).collect { it.$('td', 1).text() }.unique()
			//				return playListRows[(3..52)].collect { it.$('td', 1).text() }.unique()
			//			}
			//			else {
			//				return []
			//			}

		}
	}

	// convert parameter arguments
	//TODO add date range
	String convertToPath(Object[] args) {
		args ? '?channel=' + args[0] : ""
	}
}

/**
 * XM Channel definition for Jam On and Blugrass Junction
 * TODO is this the best way to get constants
 */
public enum Channels {
	JAM_ON('29', 'jamon.txt'),
	BLUEGRASS('61', 'bluegrass.txt')

	final String channelNumber
	final String fileName
	final static String outDir = 'output/'

	private Channels(String cn, String fn) {
		channelNumber = cn;
		fileName = outDir + fn
	}

	public boolean equalsName(String otherName) {
		return (otherName == null) ? false : channelNumber.equals(otherName);
	}

	public String toString() {
		return this.channelNumber;
	}
}
