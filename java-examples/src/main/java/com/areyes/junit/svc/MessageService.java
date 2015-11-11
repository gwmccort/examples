package com.areyes.junit.svc;

/**
 * The Class MessageService.
 * from: http://examples.javacodegeeks.com/core-java/junit/junit-disable-test-example/
 */
public class MessageService {
	
	

	/** The message. */
	private String message;


	/**
	 * Instantiates a new message service.
	 *
	 * @param message the message
	 */
	public MessageService(String message) {
		this.message = message;
	}

	/**
	 * Prints the message.
	 *
	 * @return the string
	 */
	public String printMessage() {
		return message;
	}

	/**
	 * Salutation message.
	 *
	 * @return the string
	 */
	public String salutationMessage() {
		message = "Hi!" + message;
		return message;
	}
	
	/**
	 * This will be the method to get the salutation messages specifically for executives.
	 * @return a string
	 */
	public String salutationMessageForExecutives() {
		return "this is not yet implemented";
	}

}
