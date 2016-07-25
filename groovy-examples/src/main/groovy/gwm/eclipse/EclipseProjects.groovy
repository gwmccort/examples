package gwm.eclipse

import static groovy.io.FileType.DIRECTORIES
import groovy.transform.ToString

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.opencsv.CSVWriter

/**
 * Eclipse utility to find workspaces and project location
 * @author gwmccort
 * @see <a href="http://mrhaki.blogspot.com/2014/04/groovy-goodness-converting-byte-array.html">Groovy Goodness: Converting Byte Array to Hex String</a>
 *
 * <p>
 * eclipse project location:<br>
 * http://stackoverflow.com/questions/5119008/where-are-project-stored-in-eclipse
 * http://stackoverflow.com/questions/251116/where-in-an-eclipse-workspace-is-the-list-of-projects-stored
 */
class EclipseProjects {

	static main(args) {

		//		readBytes(new File(/H:\Project_Files\Workspaces\bitbucket-examples\.metadata\.plugins\org.eclipse.core.resources\.projects\java-examples\.location/))

		//		List projects = getProjects(path)
		//		projects.each() { println it }

		//		// get projects in workspace
		//		Path path = Paths.get(/H:\Project_Files\Workspaces\bitbucket-examples/)
		//		List projs = Project.getProjects(path)
		//		projs.each() { println it }


		// get workspaces
		//		Path path = Paths.get(/H:\Project_Files\Workspaces/)
		Path path = Paths.get(/H:\Project_Files\Workspaces\bitbucket-examples/)
		List<Workspace> workspaces = Workspace.getWorkspaces(path)

		// create csv file
		CSVWriter writer = new CSVWriter(new FileWriter("eclipse-workspaces.csv"))
		//		writer.with() {
		workspaces.each() { ws ->
			ws.toStringArray().each() { line ->
				writer.writeNext(line)
			}
		}
		writer.close()
		//		}
	}

	static List<Path> getProjects(Path path) {
		def PROJ_LOCATION = '.metadata\\.plugins\\org.eclipse.core.resources\\.projects'
		List projs = []

		path.eachFileRecurse(DIRECTORIES) { dir ->
			if (dir.toString().endsWith(PROJ_LOCATION)){
				projs << dir
			}
		}

		//		for (p in projs) {
		//			println "${p.class} $p"
		//			//			new File("/your/path/").listFiles(File::isDirectory)
		//			//			new File(p.toFile()).eachDir() {
		//			//				println it
		//			//			}
		//			p.toFile().eachDir() {
		//				println it
		//				readBytes(new File(it, '.location'))
		//			}
		//		}
		return projs
	}

	static readBytes(File file) {
		if (file.exists()) {
			byte[] bytes = file.getBytes()

			for (b in bytes) {
				println b
			}

			println '------ bytes ----------'
			println bytes

			println '\n-------- hex --------'
			println bytes.encodeHex().toString()

			println '\n------- ascii ----------'
			String sb = new String(bytes)
			println "sb: $sb"

			// get uri of project location
			def x = (sb =~ /URI\/\/(\p{Print}*)/)[0][1]
			println "x: $x"
		}
		else println "-------- $file doesn't exist!!!"
	}
}

/**
 * Eclipse project
 */
@ToString(includeNames=true, includePackage=false)
class Project {
	String name
	String uri
	boolean isLocal

	static final String PROJ_LOCATION = '.metadata\\.plugins\\org.eclipse.core.resources\\.projects'

	/**
	 * Recursively get Eclipse Projects
	 *
	 * @param path to Workspace Project metadata
	 * @return list of Project objects
	 */
	static List<Project> getProjects(Path path) {
		List results = []
		Path projPath = Paths.get(path.toString(), PROJ_LOCATION)

		try {
			projPath.eachFile(DIRECTORIES) { dir ->

				// skip .org.eclipse.jdt.core.external.folders folder
				if (dir.getFileName().toString() != '.org.eclipse.jdt.core.external.folders') {
					Path locPath = Paths.get(dir.toString(), '.location')
					if (Files.exists(locPath)) {
						results << new Project(name: dir.getFileName(),  uri: getProjectLocation(locPath), isLocal: false)
					}
					else {
						results << new Project(name: dir.getFileName(), isLocal: true)
					}
				}
			}
			return results
		}
		catch (Exception e) {
			println "getProjects path: $path"
			e.printStackTrace()
		}
	}

	private static String getProjectLocation(Path path) {
		try {
			//TODO make this more clear
			return (new String(path.getBytes()) =~ /URI\/\/(\p{Print}*)/)[0][1]
		}
		catch (Exception e) {
			println "getProjectLocation path: $path"
			e.printStackTrace()
		}
	}

	List<String[]> toStringArray() {
		return ([name, uri, isLocal] as String[])
	}
}

/**
 * Eclipse workspace
 */
@ToString(includeNames=true, includePackage=false)
class Workspace {
	String name
	Path path
	List<Project> projects = []

	static final METADATA = ".metadata"

	/**
	 * Recursively get Eclipse Workspaces
	 *
	 * @param path to start searching for workspaces
	 * @return list of Workspace objects
	 */
	static List<Workspace> getWorkspaces(Path path) {
		List results = []

		path.eachFileRecurse(DIRECTORIES) { dir ->
			if (dir.toString().endsWith(METADATA)) {
				Path wsPath = dir.getParent()

				//TODO get projects
				results << new Workspace(name: wsPath.getFileName(), path: wsPath, projects: Project.getProjects(wsPath))
			}
		}
		return results
	}

	List<String[]> toStringArray() {
		List results = []
		for (proj in projects) {
			results << (([name, path] + proj.toStringArray()) as String[])
		}
		return results
	}
}
