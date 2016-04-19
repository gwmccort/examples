package gwm.lang;

/* regular javadoc
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

/**
 * = StateMultiValueEnum
 *
 * Multi-value enum example of states
 * 
 * from: http://stackoverflow.com/questions/19600684/java-enum-with-multiple-value-types
 *
 * More enum examples: 
 * from: http://examples.javacodegeeks.com/java-basics/java-enumeration-example
 * 
 * Sample comments that include `source code`.
 *
 * [source,java]
 * --
 * public class Asciidoclet extends Doclet {
 *     private final Asciidoctor asciidoctor = Asciidoctor.Factory.create();
 *
 *     @SuppressWarnings("UnusedDeclaration")
 *     public static boolean start(RootDoc rootDoc) {
 *         new Asciidoclet().render(rootDoc);
 *         return Standard.start(rootDoc);
 *     }
 * }
 * --
 *
 * @author https://github.com/gwmccort[Glen McCort]
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
