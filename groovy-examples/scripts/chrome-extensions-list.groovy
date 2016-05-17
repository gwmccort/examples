/**
 * process text copies from chrome extension page
 */

String[] lines = new File('chrome-extensions.txt')

// get first extension
def exts = [lines[1]]

// get extension two lines after 'Enabled' line
for (i=2; i<lines.size(); i++) {
	if (lines[i] == 'Enabled'){
		i = i+2
		exts << lines[i] 
	}
}

// remove last item
exts = exts.dropRight(1)

exts.each {
	println it
}