package numberrangesummarizer;

import static org.junit.Assert.*;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class summerizerTestCases {

	@Test
	public void testInputCollectionNotNull()   // check if the string input in the collection method is not null
	{

		NumberSummarizerHelper helper = new NumberSummarizerHelper();
		Collection<Integer> input = helper.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
		
		 assertNotNull(input); 
	
	}
	@Test
	public void testInputCollectionWithChar()  // check if the a char value is inserted should return fail
	{

		NumberSummarizerHelper helper = new NumberSummarizerHelper();
		Collection<Integer> input = helper.collect("1,3,*,7,8,12,13,14,15,21,22,23,24,31");
		
		 assertNull(input);
	
	}
	
	@Test
	@SuppressWarnings("all")
	public void testInputCollectionNullChar()  // expected to fail 
	{
		
		Collection<Integer> input =null ;
		try {
		NumberSummarizerHelper helper = new NumberSummarizerHelper();
	     input = helper.collect("1,p,7,7,8,12,13,14,15,21,22,23,24,31");
		
	
		}
		catch(NumberFormatException ex)
		{
			assertTrue(true);
		}
		}
	}
	
