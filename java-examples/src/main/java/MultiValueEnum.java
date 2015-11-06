
/**
 * Multi-value enum example 
 * from: http://stackoverflow.com/questions/19600684/java-enum-with-multiple-value-types
 * 
 * More enum examples:
 * from: http://examples.javacodegeeks.com/java-basics/java-enumeration-example/
 * 
 * @author gwmccort
 *
 */
public class MultiValueEnum {
	public static void main(String[] args) {
		System.out.println(States.IOWA);
		System.out.println(States.IOWA.getAbbreviatedName());
		for (States st : States.values()) {
			System.out.println(st + "\n\t" + st.isOriginallyColony());
		}
	}

}

enum States {
	// all 50 of those ..
    MASSACHUSETTS("Massachusetts",  "MA",   true),
    MICHIGAN     ("Michigan",       "MI",   false),
    IOWA ("Iowa", "IA", false); 

    private final String full;
    private final String abbr;
    private final boolean originallyColony;

    private States(String full, String abbr, boolean originallyColony) {
        this.full = full;
        this.abbr = abbr;
        this.originallyColony = originallyColony;
    }

    public String getFullName() {
        return full;
    }

    public String getAbbreviatedName() {
        return abbr;
    }

    public boolean isOriginallyColony(){
        return originallyColony;
    }
}
