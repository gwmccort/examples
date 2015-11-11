package com.javarticles.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

/**
 * GuavaTableExample
 * from: http://javarticles.com/2015/11/guava-table-example.html
 * 
 * @author Glen
 *
 */
public class GuavaTableExample {
    
    public static void main(String[] args) {
        Table<String, String, String> table = HashBasedTable.create();
        table.put("Language", "Java", "1.8");
        table.put("Language", "Ruby", "2.2.3");
        table.put("IOC", "Spring", "4.1.4");
        table.put("IOC", "Guice", "4.0");
        table.put("Database", "Oracle", "12c");
        table.put("Database", "MySQL", "5.0");
        table.put("Training", "Java", "Java 8 Features");
        table.put("Training", "Spring", "Spring Core");
        
        System.out.println(table);
        
        System.out.println("Languages: " + table.row("Language"));
        System.out.println("Java language ver# using row: " + table.row("Language").get("Java"));
        System.out.println("Table as row map: " + table.rowMap());
        System.out.println("Row keys as set: " + table.rowKeySet());
        
        System.out.println("Java Column size: " + table.column("Java").size());
        System.out.println("Java: " + table.column("Java"));
        System.out.println("Java language ver# using column: " + table.column("Java").get("Language"));
        System.out.println("Table as col map: " + table.columnMap());
        System.out.println("Column keys as set: " + table.columnKeySet());
        
        System.out.println("Cell set: " + table.cellSet());
        for (Cell<String, String, String> cell : table.cellSet()) {
            System.out.println("(" + cell.getRowKey() + "," + cell.getColumnKey() + ")=" + cell.getValue());
        }
    }   
}
