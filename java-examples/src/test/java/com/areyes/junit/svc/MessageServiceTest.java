package com.areyes.junit.svc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.isA;

/**
 * MessageServiceTest - disable test example <br>
 * from: http://examples.javacodegeeks.com/core-java/junit/junit-disable-test-example/
 * 
 * @author Glen
 *
 */
public class MessageServiceTest {

	private String CONST_MSG = "Message is me";
	private MessageService msgService = new MessageService(CONST_MSG);
	
	@Test
	public void testPrintMessage() {
		//	Check type return
		assertThat(msgService.printMessage(), isA(String.class));
		assertEquals(CONST_MSG, msgService.printMessage());
		
	}
	
	@Test
	public void testSalutationMessage() {
		String messageSal = msgService.salutationMessage();
		assertThat(messageSal, isA(String.class));
		assertEquals("Hi!" + CONST_MSG,messageSal);
	}


	@Ignore //ignore this test
	@Test
	public void testSalutationMessageForExecutives() {
		assertThat(msgService.salutationMessageForExecutives(), isA(String.class));
		assertEquals(CONST_MSG, msgService.salutationMessage());
	}
}
