/**
 * 
 */
package com.architectcorner.cli.parsing;


import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * @author Bhagvan Kommadi
 * Basic Parser example for parsing application data arguments
 */
public class BasicParserExample extends BasicParser{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicParserExample exampleParser = new BasicParserExample();
		
		Options options = new Options()
        .addOption("a", "enable-a", false, "turn [a] on or off")
        .addOption("b", "bfile", true, "set the value of [b]")
        .addOption("c", "copt", false, "turn [c] on or off");
		
		String[] parserArgs = new String[] { "-a",
                "-b", "toast",
                "foo", "bar" };
		try
		{
		 CommandLine commandLine = exampleParser.parse(options,parserArgs);
		 System.out.println(commandLine.getOptionValue("b"));
		}
		catch(ParseException parseException)
		{
			System.out.println("Exception "+parseException.getMessage());
		}
	}
	@Override
	/**
	 * flatten the options and arguments string
	 * @param arg0 options
	 * @param arg1 argument string
	 * @param arg2 boolean flag
	 * @return string array of flattened arguments
	 */
	protected String[] flatten(Options arg0, String[] arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return super.flatten(arg0,arg1,arg2);
	}

}
