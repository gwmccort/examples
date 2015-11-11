package lang;

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
public enum StatesMultiValueEnum {
	// all 50 of those ..
    MASSACHUSETTS("Massachusetts",  "MA",   true),
    MICHIGAN     ("Michigan",       "MI",   false),
    IOWA ("Iowa", "IA", false); 

    private final String full;
    private final String abbr;
    private final boolean originallyColony;

    private StatesMultiValueEnum(String full, String abbr, boolean originallyColony) {
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
