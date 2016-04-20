package gwm.regexp;

/**
 * @author Glen
 * @see <a href="http://groovyconsole.appspot.com/script/5141952697729024">Named
 *      group</a>
 * @see <a href="http://stackoverflow.com/questions/15664318/are-there-named-groups-in-groovy-regex-pattern-matches">stackoverflow question</a>
 * @see <a href="https://blogs.oracle.com/xuemingshen/entry/named_capturing_group_in_jdk7">Named Capturing Group in JDK7 RegEx</a>
 */
public class NamedGroups {

	public static void main(String[] args) {
		def matcher = "John 19" =~ /(?<name>\w+) (?<age>\d+)/
		if( matcher.matches() ) {
			println "Matches"
			assert matcher.group( 'name' ) == 'John'
			assert matcher.group( 'age' ) == '19'
		}
		else {
			println "No Match"
		}
	}
}
