package com.lordofthejars.bar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BarComponent {

	private static final Logger logger = LoggerFactory.getLogger(BarComponent.class);
	
	public void bar() {
		
		String name = "lordofthejars";
		
		logger.info("Hello from Bar.");
		
		
		logger.debug("In bar my name is {}.", name);
		
	}

}
