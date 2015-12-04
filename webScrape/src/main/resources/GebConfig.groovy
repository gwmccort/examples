import org.openqa.selenium.htmlunit.HtmlUnitDriver

println 'in GebConfig'

// set geb reports dir
reportsDir = "build/geb-reports"

// enable javascript in htmlunit
driver = {
	def driver = new HtmlUnitDriver()
	driver.javascriptEnabled = true
	driver
}