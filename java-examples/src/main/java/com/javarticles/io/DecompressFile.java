package com.javarticles.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Uncompress a zip file
 * 
 * @see <a href=
 *      "http://javarticles.com/2015/11/java-decompressing-files-example.html">
 *      Java Decompressing Files Example</a>
 * @author gwmccort
 *
 */
public class DecompressFile {
	private static final int BUFFER = 2048;

	public static void main(String[] args) throws IOException {
		DecompressFile decompressFile = new DecompressFile();
		decompressFile.decompress("allFiles.zip");
	}

	public long decompress(String fileName) throws IOException {
		BufferedOutputStream dest = null;
		FileInputStream fis = new FileInputStream("allFiles.zip");
		CheckedInputStream checksum = new CheckedInputStream(fis, new Adler32());
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(checksum));
		try {
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				System.out.println("Extracting: " + entry);
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				FileOutputStream fos = new FileOutputStream(entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				try {
					while ((count = zis.read(data, 0, BUFFER)) != -1) {
						dest.write(data, 0, count);
					}
				} finally {
					dest.flush();
					dest.close();
				}
			}
			return checksum.getChecksum().getValue();
		} finally {
			zis.close();
		}
	}
}
