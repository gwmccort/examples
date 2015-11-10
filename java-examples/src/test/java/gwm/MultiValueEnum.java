package gwm;

import org.junit.Test;

/**
 * Multi-value enum example from:
 * http://stackoverflow.com/questions/19600684/java-enum-with-multiple-value-
 * types
 *
 * More enum examples: from:
 * http://examples.javacodegeeks.com/java-basics/java-enumeration-example/
 *
 * @author gwmccort
 *
 */
public class MultiValueEnum {
	// public static void main(String[] args) {
	// System.out.println(States.IOWA);
	// System.out.println(States.IOWA.getAbbreviatedName());
	// for (States st : States.values()) {
	// System.out.println(st + "\n\t" + st.isOriginallyColony());
	// }
	// }

	@Test
	public void testSomething() throws Exception {
		System.out.println("in testSomething");
	}

	@Test
	public void testMultiValueEnumStates() throws Exception {
		System.out.println(States.IOWA);
		System.out.println(States.IOWA.getAbbreviatedName());
		for (States st : States.values()) {
			System.out.println(st + "\n\t" + st.isOriginallyColony());
		}
	}

}
