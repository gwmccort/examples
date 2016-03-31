package test

/**
 * Read input from console (stdin)
 *
 * @author gwmccort
 *
 */
class StdInTest {

	static main(args) {
		System.in.eachLine() { line ->
			if(line.equals("exit"))
				System.exit(1)
			else
				println "you entered: $line"
		}
	}
}
