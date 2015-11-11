package lang;

import org.junit.Test;

import lang.StatesMultiValueEnum;

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
public class MultiValueEnumTest {
	// public static void main(String[] args) {
	// System.out.println(States.IOWA);
	// System.out.println(States.IOWA.getAbbreviatedName());
	// for (States st : States.values()) {
	// System.out.println(st + "\n\t" + st.isOriginallyColony());
	// }
	// }

	@Test
	public void testSomething() throws Exception {
		System.out.println("---- testSomething");
		System.out.println("output from testSomething");
	}

	@Test
	public void testMultiValueEnumStates() throws Exception {
		System.out.println("---- testMultiValueEnumStates");
		System.out.println(StatesMultiValueEnum.IOWA);
		System.out.println(StatesMultiValueEnum.IOWA.getAbbreviatedName());
		for (StatesMultiValueEnum st : StatesMultiValueEnum.values()) {
			System.out.println(st + "\n\t" + st.isOriginallyColony());
		}
	}

}
