
import geb.Browser

Browser.drive {

	//TODO auto set proxy, is there better way
	def workHost = 'CRP22627'
	if (workHost == InetAddress.localHost.hostName) {
		driver.setProxy("proxy", 9090)
	}

    go "http://gebish.org"

    assert title == "Geb - Very Groovy Browser Automation"

    $("#sidebar .sidemenu a", text: "jQuery-like API").click()

    assert $("#main h1")*.text() == ["Navigating Content", "Form Control Shortcuts"]
    assert $("#sidebar .sidemenu a", text: "jQuery-like API").parent().hasClass("selected")
}