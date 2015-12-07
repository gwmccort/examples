package com.javarticles.guava.multiset;

import java.util.HashMap;
import java.util.Map;

public class TraditionalMapItemCountExample {
    private static final String RED = "Red";
    private static final String YELLOW = "Yellow";
    private static final String GREEN = "Green";
    
    public static void main(String[] args) {        
        Map<String, Integer> bag = new HashMap<String, Integer>();
        addItem(bag, RED);
        addItem(bag, RED);
        addItem(bag, YELLOW);
        addItem(bag, GREEN);
        addItem(bag, GREEN);
        addItem(bag, GREEN);

       System.out.println("Total items in Bag: " + bag.size());
       System.out.println("Count of RED: " + bag.get(RED));
       System.out.println("Count of YELLOW: " + bag.get(YELLOW));
       System.out.println("Count of GREEN: " + bag.get(GREEN));
       
       System.out.println("Remove GREEN by 2");
       removeItem(bag, GREEN, 2);
       System.out.println("Count of GREEN: " + bag.get(GREEN));
    }  
    
    private static void addItem(Map<String, Integer> bag, String item) {       
        Integer count = bag.get(item);
        if (count == null) {
          bag.put(item, 1);
        } else {
          bag.put(item, count + 1);
        }
    }
    
    private static void removeItem(Map<String, Integer> bag, String item, Integer removeCount) {       
        if (bag.containsKey(item)) {
            Integer itemCount = bag.get(item);
            Integer updatedCount = itemCount - removeCount;
            bag.put(item, updatedCount);
        }
    }
}
