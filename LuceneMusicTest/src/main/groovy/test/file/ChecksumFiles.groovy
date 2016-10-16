package test.file

import java.nio.file.Path
import java.nio.file.Paths
import java.util.zip.Adler32
import java.util.zip.Checksum

import au.com.bytecode.opencsv.CSVWriter

/**
 * Create csv file of mp3 file with adler32 checksum
 */
class ChecksumFiles {

	static final Path musicPath = Paths.get(/C:\Users\Glen\Music/)
	static final int BUFFER_SIZE = 1024 * 4
	static	Checksum checksum = new Adler32()

	static main(args) {
		println 'starting...'
		CSVWriter writer = new CSVWriter(new FileWriter('music-check.csv'))

		musicPath.eachFileRecurse() { path ->
			if (path.toString() ==~ /.*\.mp3/) {
				long checksum = getChecksum(path)
				String[] rec = [checksum, path.toString()] as String[]
				writer.writeNext(rec)
			}
		}
		writer.close()
		println 'finished!'
	}

	static long getChecksum(Path path) {
		checksum.reset()
		new FileInputStream(path.toString()).eachByte(BUFFER_SIZE) { buffer, nRead ->
			checksum.update(buffer, 0, nRead)
		}
		return checksum.getValue()
	}

	static main2(args) {
		musicPath.eachFileRecurse() { path ->
			if (path.toString() ==~ /.*\.mp3/) {
				print path

				InputStream fis = new FileInputStream(path.toString())
				Checksum checksum = new Adler32()
				byte[] dataBytes = new byte[1024]

				int nread = 0;
				while ((nread = fis.read(dataBytes)) != -1) {
					checksum.update(dataBytes, 0, nread)
				}
				fis.close()

				println '\t' +checksum.getValue()
			}
		}
	}
}
