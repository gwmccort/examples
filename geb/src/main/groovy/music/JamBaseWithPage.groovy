package music

import geb.Browser
import geb.Page

import java.util.logging.Level
import java.util.logging.Logger

/**
 * Get shows from JamBase
 * Created by gwmccort on 10/20/2015.
 */
class JamBaseWithPage {
    static main(args) {
        println 'main...'

        //todo shutoff htmlunit warnings, is there a better way
        //from: http://software-testing-tutorials-automation.blogspot.com/2015/05/hide-comgargoylesoftwarehtmlunit.html
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.OFF);


        Browser.drive(baseUrl: "http://jambase.com") {

            //TODO auto set proxy, is there better way
            def workHost = 'CRP22627'
            if (workHost == InetAddress.localHost.hostName) {
                driver.setProxy("proxy", 9090)
            }

            to JamBasePage

//            println $('table', class: 'showList').text()
//            println $('div', id:"ctl00_MainContent_ctlByDay_showList").text()

            // get all bands
            def bands = []
            $('div', id:"ctl00_MainContent_ctlByDay_showList").$('td', class:'artistCol').each {
//                println it.text()
//                println '-------'
                bands.addAll(it.text().split(/\n/))
            }
            println "bands: $bands"



        }

        println 'finished!'
    }
}

class JamBasePage extends Page {

    //http://www.jambase.com/shows/Shows.aspx?ArtistID=0&VenueID=0&City=Cedar%20Rapids&State=IA&Zip=52403&radius=0&StartDate=10/20/2015&EndDate=10/20/2016&Rec=False&pagenum=1&pasi=50
// http://jambase.com/shows/Shows.aspx?Zip=52403

    // url of page
//    static url = '/shows/Shows.aspx?'
    static url = '/shows/Shows.aspx?Zip=52403'

    // check page is opened
    static at = { title.startsWith('Shows Around ') }

//    static content = {
//        bands {
//            // 2nd table, rows with bands, 2nd cell (i.e. band)
//            $('table', 1).$('tr', 3..52).collect { it.$('td', 1).text() }.unique()
//        }
//    }

//
//    // convert parameter arguments
//    //TODO add date range
//    String convertToPath(Object[] args) {
//        args ? '?channel=' + args[0] : ""
//    }
}
