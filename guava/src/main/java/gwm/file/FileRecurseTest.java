package gwm.file;

import java.io.File;
import java.nio.file.Path;

import com.google.common.io.Files;

/**
 * from: http://stackoverflow.com/questions/14882820/google-guava-iterate-all-files-starting-from-a-begin-directory
 * @author gwmccort
 *
 */
public class FileRecurseTest {

	public static void main(String[] args) {
		File rootDir = new File("c:/users/gwmccort/downloads"); //this is your root directory
		for (File f : Files.fileTreeTraverser().preOrderTraversal(rootDir)) {
		    // do whatever you need with the file/directory
			System.out.println("file:" + f);

		    // if you need the relative path, with respect to rootDir
		    Path relativePath = rootDir.toPath().getParent().relativize(f.toPath());
		}

	}

}
