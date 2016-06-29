package test.file

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.attribute.FileTime

class FileAttributes {

	static main(args) {
		Path  path   = Paths.get("build.gradle");
		println path
		
		BasicFileAttributes bfa  = Files.readAttributes(path, BasicFileAttributes.class);
		FileTime lastModifiedTime  = bfa.lastModifiedTime();
		println lastModifiedTime
		
		long  size = bfa.size();
		println size
		
	}

}
