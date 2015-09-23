package groovy.web.console.list

// from: http://groovyconsole.appspot.com/script/5082964677361664

def leftCollection = [1,2,5,7]
def rightCollection = [1,5]
def onlyLeftCollection = leftCollection - rightCollection 

println "Items exclusive to leftCollection: " + onlyLeftCollection 
println "Total items exclusive to leftCollection: " + onlyLeftCollection.size()
