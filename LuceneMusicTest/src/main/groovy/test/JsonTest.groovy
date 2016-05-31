package test

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.transform.ToString

import java.nio.file.Path
import java.nio.file.Paths

@ToString(includeNames=true)
class JsonTest {
	String name
	String artist
	Path path

	JsonTest(String name, String artist, Path path) {
		this.name = name
		this.artist = artist
		this.path = path
	}

	String toJson() {
		JsonBuilder builder = new JsonBuilder()
		builder{
//			car {
				name name
				artist artist
				path path.toString()
//			}
		}
		String json = JsonOutput.prettyPrint(builder.toString())
		JsonOutput.toJson(builder)
	}


	static main(args) {
		def t = new JsonTest('name string', 'artist', Paths.get('build.gradle'))
		println t
//		try {
//			println new JsonBuilder(t).toPrettyString()
//		}
//		catch(ex){
//			ex.printStackTrace()
//		}
		
		println t.toJson()
	}
}
