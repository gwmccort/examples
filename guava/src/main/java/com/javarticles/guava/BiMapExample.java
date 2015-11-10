package com.javarticles.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * = BiMapExample
 * 
 * from: http://javarticles.com/2015/11/guava-bimap-example.html
 *
 * @author https://github.com/johncarl81[John Ericksen]
 */
public class BiMapExample {
    private static final String COLOR = "Color";
    private static final String RED = "Red";
    private static final String YELLOW = "Yellow";
    
    private static final String FURNITURE = "Furniture";
    private static final String CHAIR = "Chair";
    
    public static void main(String[] args) {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put(COLOR, RED);
        biMap.put(COLOR, YELLOW);
        System.out.println("Total size: " + biMap.size());
     
        biMap.put(FURNITURE, CHAIR);
        biMap.put(CHAIR, RED);
        
        System.out.println("Total size: " + biMap.size());        
        System.out.println("BiMap Items: " + biMap);        
        System.out.println("Inverse Items: " + biMap.inverse());
        
        
        try {
            biMap.put(CHAIR, YELLOW);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        
        System.out.println("Force put chair->yellow");
        biMap.forcePut(CHAIR,  YELLOW);
        
        System.out.println("Total size: " + biMap.size());        
        System.out.println("BiMap Items: " + biMap);
    }   
}
