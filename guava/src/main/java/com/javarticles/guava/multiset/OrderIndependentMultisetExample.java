package com.javarticles.guava.multiset;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class OrderIndependentMultisetExample {
    private static final String RED = "Red";
    private static final String YELLOW = "Yellow";
    private static final String GREEN = "Green";
    
    public static void main(String[] args) {
       Set<String> set1 = new HashSet<String>(); 
       set1.add(RED);
       set1.add(YELLOW);
       set1.add(GREEN);
       
       Set<String> set2 = new HashSet<String>(); 
       set2.add(GREEN);
       set2.add(RED);
       set2.add(YELLOW);
       
       System.out.println("Is set1.equals(set2)? " + set1.equals(set2));
       
       
       Multiset<String> bag1 = HashMultiset.create();
       bag1.add(RED);
       bag1.add(RED);
       bag1.add(YELLOW);
       bag1.add(GREEN);
       bag1.add(GREEN);
       bag1.add(GREEN);
       
       Multiset<String> bag2 = HashMultiset.create();
       bag2.add(GREEN, 3);
       bag2.add(YELLOW);
       bag2.add(RED, 2);
       
       
       System.out.println("Is bag1.equals(bag2)? " + bag1.equals(bag2));
    }   
}
