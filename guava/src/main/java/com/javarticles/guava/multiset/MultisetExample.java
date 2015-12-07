package com.javarticles.guava.multiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultisetExample {
    private static final String RED = "Red";
    private static final String YELLOW = "Yellow";
    private static final String GREEN = "Green";
    
    public static void main(String[] args) {
       Multiset<String> bag = HashMultiset.create();
       bag.add(RED);
       bag.add(RED);
       bag.add(YELLOW);
       bag.add(GREEN);
       bag.add(GREEN);
       bag.add(GREEN);
       bag.add(YELLOW, 2);
       
       System.out.println("Total items in Bag: " + bag.size());
       System.out.println("Count of RED: " + bag.count(RED));
       System.out.println("Count of YELLOW: " + bag.count(YELLOW));
       System.out.println("Count of GREEN: " + bag.count(GREEN));
       
       System.out.println("Remove GREEN by 2");
       bag.remove(GREEN, 2);
       System.out.println("Count of GREEN: " + bag.count(GREEN));
       
       bag.setCount(GREEN, 0);
       System.out.println("Count of GREEN: " + bag.count(GREEN));
    }   
}
