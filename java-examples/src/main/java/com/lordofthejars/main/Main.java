package com.lordofthejars.main;

import com.lordofthejars.bar.BarComponent;
import com.lordofthejars.foo.FooComponent;

/**
 * sl4j example
 * from: http://www.javacodegeeks.com/2012/04/using-slf4j-with-logback-tutorial.html
 * 
 * @author Glen
 *
 */
public class Main {

	public static void main(String args[]) {
		
		BarComponent barComponent = new BarComponent();
		barComponent.bar();
		
		FooComponent fooComponent = new FooComponent();
		fooComponent.foo();
		
	}
	
}
