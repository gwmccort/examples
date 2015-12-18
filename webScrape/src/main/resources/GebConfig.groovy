import org.openqa.selenium.htmlunit.HtmlUnitDriver

//println "in GebConfig driver: $driver $driver.dump()"

// set geb reports dir
reportsDir = "build/geb-reports"

// enable javascript in htmlunit
driver = {
	def driver = new HtmlUnitDriver()
	driver.javascriptEnabled = true
	driver
}

//println "end GebConfig driver: $driver $driver.dump()"