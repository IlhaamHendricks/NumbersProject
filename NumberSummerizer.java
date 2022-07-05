package numberrangesummarizer;

import java.util.*;

/**Class containing the main method where the start of the program will  be executed 
 */

public class NumberSummerizer
{ 
    public static void main(String[] args)						// Main Method 
    {
    	NumberSummarizerHelper numHelper = new NumberSummarizerHelper();  // Initialize and Instantiate NumberSummarizeHelper class 
        String rangeInput = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";		// String input of integers assuming all integers are positive 
        
        try
        {																			  //error handling 
            Collection<Integer> collectionInput = (List<Integer>)numHelper.collect(rangeInput);  // method to add delimiters and sort the input string  
            String range = numHelper.summarizeCollection(collectionInput);                 // group the numbers into a range if it is sequential.

            System.out.println(range); // print the range 
        } 
        catch (ClassCastException exc)
        {
            System.out.println("Please provide a range of numbers only");  
        }
    }	    
}