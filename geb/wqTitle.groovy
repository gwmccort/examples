import geb.*
//b = new Browser(baseUrl: "http://nile:8008/webquery") //intg
b = new Browser(baseUrl: "http://beaver:8003/webquery") //qa
b.go()
b.title
