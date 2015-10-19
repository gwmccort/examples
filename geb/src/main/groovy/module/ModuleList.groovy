package module

import geb.Browser
import geb.Page
import geb.Module

/**
 * from: http://adhockery.blogspot.com/2010/11/modelling-repeating-structures-with-geb.html
 */
class ModuleList {


    static main(args) {
        Browser.drive() {
//            go "file:///H:/Project_Files/bit-bucket/examples/geb/ModuleList.html"
            to ModuleListPage

            println "at: " + at(ModuleListPage)
            assert at(ModuleListPage)

            println '-------booksModule.recentBooks--------'
            println booksModule.recentBooks
//            println content

            println '-----booksFromPage--------'
            println booksFromPage

            println '-----bookResults--------'
            println bookResults(0).title
            println bookResults(3).price
            println bookResults(0)

//            {module Books}.each{println it}
        }
    }
}

class Books extends Module {
    static content = {
        recentBooks { $("ol#recent-books li")*.text() }
    }

//    static base = {
//        recentBooks { $("ol#recent-books li")*.text() }
//    }
}

class BookRow extends Module {
    static content = {
        cell { i -> $("td", i) }
        title { cell(0).text() }
        author { cell(1).text() }
        format { cell(2).text() }
        price { cell(3).text()[1..-1].toDouble() }
        releaseDate { cell(4).text() }
    }
}

class ModuleListPage extends Page {
    // url of page
    static url = "file:///H:/Project_Files/bit-bucket/examples/geb/ModuleList.html"

    // check page is opened
//    static at = { $('h1', text: contains('Module List')) }
    static at = { title == 'Module List' }

    static content = {
        booksModule { module Books }
        booksFromPage { $("ol#recent-books li")*.text() }
        bookResults { i -> module BookRow, $("table#book-results tbody tr", i) }
    }
//    static content = { module Books }

}