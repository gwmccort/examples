/**
 * from: https://gr8fanboy.wordpress.com/2010/04/30/groovy-enums-example/
 */

enum NANPCodeGroup {
    USA(3), Canada(4), Carribean(5), USPacific(6)
    NANPCodeGroup(int value) {this.value = value}
    private final int value
    public int value() {return value}
}
NANPCodeGroup.each{println "1: $it"}
NANPCodeGroup.each{println "2: ${it.value()}"}
println "3: ${NANPCodeGroup.values()}"
NANPCodeGroup.values().each{println "4: $it"}
println "5: ${NANPCodeGroup.USA.value()}"
println "6: ${NANPCodeGroup.USA}"
x = NANPCodeGroup.grep{it.value() == 3}[0]?:''
println "7: $x , ${x.class}"


// from http://blog.andresteingress.com/2013/12/12/groovy-quick-tip-string-to-enum-coercion/
enum Day {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
}

// from http://stackoverflow.com/questions/6667243/using-enum-values-as-string-literals
public enum Modes {
    mode1 ("Mode1"),
    mode2 ("Mode2"),
    mode3 ("Mode3");

    private final String name;

    private Modes(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}

println Modes.mode1.class

