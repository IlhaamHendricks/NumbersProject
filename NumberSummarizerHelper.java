package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
S: We are implementing the first Rule of SOLID, singular responsibility principal where it is good practice to have two separate methods 
   one method to collect the input array and sort it and the other to summarize it complies to the practices of SOLID therefore the class has been created separately 
O: Open-closed Principle: In future the method will not need to be modified only inherited from
L:  Liskov Substitution Principle: every subclass or derived class will be substitutable for their base or parent class
I:  Interface Segregation Principle: there is no need to depend on methods that are not in use
D: Dependency Inversion Principle: No models were defined so there was no use of dependency injection 
 */
public class NumberSummarizerHelper implements NumberRangeSummarizer //Implements the given interface 
 {
	//COLLECTION
	// Starting with collecting the input using the collection method which requires a string input which is comma separated 
	// and returns a list of integers 

	public Collection<Integer> collect (String input)
	{
        String[] collectorArray = input.split(",");              //Split the input using a comma ","
        int[] collectorLength = new int[collectorArray.length];  //get the length of the array

        for (int n = 0; n < collectorArray.length; n++)          // use a for loop to iterate through the array 
        {
        	collectorLength[n] = Integer.parseInt(collectorArray[n]); // parse into the array 
        }

       
        Arrays.sort(collectorLength); 							// Sorting the input in ascending order 
        List<Integer> collectorList = new ArrayList<>();		// initialize new list 

        for (int n = 0; n < collectorLength.length; n++)        // add into the integer list 
        {
        	collectorList.add(collectorLength[n]);
        }
        return collectorList;                                  // Single responsibility of the method is to return the list

    }

	
	
	// SUMMARY 
	// requires a collection of input value and returns a string value
	
	public String summarizeCollection(Collection<Integer> input)
    {
        int numCount = 0;												//counter is used to check how many items are in the list 
        
        StringBuilder builder = new StringBuilder();					
        
        ArrayList<Integer> inputCollectionList = new ArrayList<Integer>(input);  //collection of array lost of integers 
        int inputCollectionLength = inputCollectionList.size();					//define the size of the list 


        int startIndex, rangeIndex, lowest;      	// to hold the start and next value of the list 
        for (int n = 0; n < inputCollectionLength; n++)
        {
            
            if (n == inputCollectionLength - 1) 	// if it is the last integer in the list 
            {
                if(inputCollectionList.get(inputCollectionLength-2) != inputCollectionList.get(inputCollectionLength-1))
                {
                	builder.append(inputCollectionList.get(n) + ","); // add a new input value to the string builder 
                }
                break; // end the loop
            }

            startIndex = (Integer)inputCollectionList.get(n); // get the index value 

            rangeIndex = (Integer)inputCollectionList.get(n + 1); //  add 1 to index value 
            if (rangeIndex == startIndex + 1)					// check to see if the number is sequential 
            {
            	numCount++;										//add 1 to the counter 
                 lowest = startIndex;							// make the lowest the current start number 

                for (int i = n + 1; ; i++)
                {
                	startIndex = (Integer)inputCollectionList.get(i);  
                	rangeIndex = (Integer)inputCollectionList.get(i + 1);

                    if (rangeIndex == startIndex + 1)    // check if it is  sequential 
                    {
                    	numCount++;   //Add to the count
                    }
                    else
                    {// if no longer sequential add to string builder lowest number - to the highest number in the sequence followed by comma
                        n = i;
                        if (numCount != 0)
                        {
                        	builder.append(lowest + " - " + (Integer)inputCollectionList.get(i) + ", ");
                        }
                        break;  // exit the loop
                    }
                }
                numCount = 0;  // set counter back to 0
            }
            else
            {
               
            	builder.append(startIndex + ", "); // add comma to those that are not in a range  and append the result 
            }
        }
        
        String range = builder.toString();
        return range.substring(0, range.length() - 1);//Concatenate and return the range
    }


	

}
