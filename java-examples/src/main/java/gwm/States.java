package gwm;



public enum States {
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
