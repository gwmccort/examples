package gwm.lang;
/**
 * How to create Immutable class in java
 * from: http://examples.javacodegeeks.com/core-java/create-immutable-class-java/
 * @author Glen
 *
 */
public final class ImmutableClass {

    private final String[] array;

    public ImmutableClass(String[] arr){
        this.array = arr.clone(); //KEY: clone the input so it can't be changed!
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Characters in array are: ");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] array = {"a","b"};
        ImmutableClass immutableClass = new ImmutableClass(array) ;
        System.out.println("Before constructing " + immutableClass);
        array[1] = "c"; // change (i.e. mutate) the element
        System.out.println("After constructing " + immutableClass);
    }
}
