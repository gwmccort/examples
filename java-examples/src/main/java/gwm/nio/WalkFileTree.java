package gwm.nio;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

import com.google.common.collect.ArrayListMultimap;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * Shows how to use nio file visitor, guava multi-map and csv file writer.
 * @author gwmccort
 *
 */
public class WalkFileTree {
	private static final String CRC_CSV_FILE = "crc.csv";
	// private static final String DIR_PATH = "h:/Project_Files/src";
//	private static final String DIR_PATH = "c:/users/gwmccort/.gradle";
	private static final String DIR_PATH = "c:/users/glen/.gradle";

	public static void main(String[] args) throws Exception {
		Path path = Paths.get(DIR_PATH);
		CrcFileVisitor visitor = new CrcFileVisitor();

		try {
			Files.walkFileTree(path, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayListMultimap<Long, Path> filesMultiMap = ArrayListMultimap
				.create();
		CRC32 crc32 = new CRC32();
		for (Path path2 : visitor.getPaths()) {
			try {
				crc32.update(Files.readAllBytes(path2));
				long crc = crc32.getValue();
				crc32.reset();
				filesMultiMap.put(crc, path2);
			} catch (Exception exp) {
				System.out.println("exception:" + exp.getMessage());
			}
		}

		CSVWriter writer = new CSVWriter(new FileWriter(CRC_CSV_FILE));
		for (Long crc : filesMultiMap.keySet()) {
			int size = filesMultiMap.get(crc).size();
			if (size > 1) {
				List<Path> fiList = filesMultiMap.get(crc);
				String[] data = new String[size * 2 + 2];
				int i = 0;
				data[i++] = crc.toString();
				boolean isFirst = true;
				for (Path fi : fiList) {
					if (isFirst) {
						isFirst = false;
						data[i++] = String.valueOf(Files.size(fi));
					}
					data[i++] = fi.getFileName().toString();
					data[i++] = fi.toString();
				}
				writer.writeNext(data);
			}
		}
		writer.close();
	}

}

class CrcFileVisitor extends SimpleFileVisitor<Path> {
	public List<Path> paths = new ArrayList<>();

	public List<Path> getPaths() {
		return paths;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		paths.add(file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		// ignore access denied
		return FileVisitResult.SKIP_SUBTREE;
	}
}
