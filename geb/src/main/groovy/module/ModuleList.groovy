package module

import geb.Browser
import geb.Page
import geb.Module

class ModuleList {


    static main(args) {
        Browser.drive() {
//            go "file:///H:/Project_Files/bit-bucket/examples/geb/ModuleList.html"
            to ModuleListPage

            println "at: " + at(ModuleListPage)
            assert at(ModuleListPage)


            println books.recentBooks
//            println content

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

class ModuleListPage extends Page {
    // url of page
    static url = "file:///H:/Project_Files/bit-bucket/examples/geb/ModuleList.html"

    // check page is opened
//    static at = { $('h1', text: contains('Module List')) }
    static at = { title == 'Module List' }

    static content = { books { module Books }}
//    static content = { module Books }

}