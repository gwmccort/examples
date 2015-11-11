package com.lordofthejars.foo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FooComponent {

	private static final Logger logger = LoggerFactory.getLogger(FooComponent.class);
	
	public void foo() {
		
		String name = "Alex";
		
		logger.info("Hello from Foo.");
		
		logger.debug("In foo my name is {}.", name);
		
	}
	
}
