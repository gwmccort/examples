package gwm.plantuml

import net.sourceforge.plantuml.SourceStringReader

import org.bitbucket.novakmi.plantumlbuilder.PlantUmlBuilder

/**
 * PlantUML example 
 * @see <a href="https://bitbucket.org/novakmi/plantumlbuilder>groovy plantumlbuilder</a>
 * 
 * @author Glen
 *
 */
class PlantUmlExample {

	static main(args) {
		// create new builder
		def builder = new PlantUmlBuilder()
		// plantuml element is a root element of PlantUML
		builder.plantuml {
					plant('A->B') // plant  only puts text to the output
					plant('activate B')
					plant('B->C')
					plant('activate C')
					plant('C-->B')
					plant('deactivate C')
					plant('A-->B')
					plant('deactivate B')
		}
		
		println builder.getText() // get PlantUML text
		println ''
		println 'Without @startuml/@enduml'
		println builder.getText(plainPlantUml: true)  // get PlantUML text without @startuml and @enduml
		
		// use plantUML to create png file from plantuml text
		SourceStringReader s = new SourceStringReader(builder.getText())
		FileOutputStream file = new FileOutputStream('./example1.png')
		s.generateImage(file)
		file.close()
	}

}
