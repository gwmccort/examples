package webquery

import geb.Page

class LoginPage extends Page {
	static url = 'http://beaver:8003/webquery/Login.html'
	static at = { title == 'PDM on the Web' }
}
