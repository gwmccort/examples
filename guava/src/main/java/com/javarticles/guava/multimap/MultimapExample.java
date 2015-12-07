package com.javarticles.guava.multimap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


/* - plain javadoc
 * Multimap example
 * from: http://javarticles.com/2015/11/guava-multimap-example.html
 * 
 * @author Glen
 *
 */

/**
 * = MultimapExample
 *
 * Sample comments that include `source code`.
 * 
 * from: http://javarticles.com/2015/11/guava-multimap-example.html
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
 * @author https://github.com/johncarl81[John Ericksen]
 */
public class MultimapExample {
    private static final String COLOR = "Color";
    private static final String RED = "Red";
    private static final String YELLOW = "Yellow";
    private static final String GREEN = "Green";
    
    private static final String FURNITURE = "Furniture";
    private static final String TABLE = "Table";
    private static final String CHAIR = "Chair";
    private static final String SOFA = "Sofa";
    
    public static void main(String[] args) {
       Multimap<String,String> bag = ArrayListMultimap.create();
       bag.put(COLOR, RED);
       bag.put(COLOR, RED);
       bag.put(COLOR, YELLOW);
       bag.put(COLOR, GREEN);
       bag.put(COLOR, GREEN);
       bag.put(COLOR, GREEN);
       
       bag.put(FURNITURE, TABLE);
       bag.put(FURNITURE, CHAIR);
       bag.put(FURNITURE, SOFA);

       System.out.println("Total items in Bag: " + bag.size());
       System.out.println("Total colors in Bag: " + bag.get(COLOR).size());
       System.out.println("Colors in Bag: " + bag.get(COLOR));
       
       System.out.println("Total items in furniture: " + bag.get(FURNITURE).size());
       System.out.println("Furniture Items: " + bag.get(FURNITURE));
    }   
}
