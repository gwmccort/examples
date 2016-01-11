import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


final Path newFile = Paths.get('output.txt')

println "file exists: ${Files.exists(newFile)}"
