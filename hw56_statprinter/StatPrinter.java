/*
Larry Wong
APCS1 pd8
HW56: His Toe Grammar
2017-12-18
*/


/*====================================================================
  An AP-style question, for practice:
  Write the StatPrinter class below. The StatPrinter Object receives an
  ArrayList of nonnegative integers, then builds a frequency ArrayList in which
  the index values are the data and the entry at the index is the frequency.
  For example, if the received data is    2,3,2,5,1,3    then the frequency 
  list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
  2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
  the maximum value of the data.

  A capability of the class is to calculate local modes from the frequency 
  list. A local mode is a value that is greater than the value at index-1 
  and greater than the value at index+1. A local mode is never at the end
  points of the list. For example, if the frequency list is [1,2,1,4,2,3,5] 
  then the local modes are 2 and 4.

  This class is also capable of printing a histogram of the frequencies, using
  '*'s to indicate a frequency amount. To print a histogram, the user specifies
  the longest sequence of '*'s used and then all other values are printed in 
  proportion to this value. For example, if longest bar is 10 and the frequency
  list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

  0 : **
  1 : ****
  2 : **
  3 : ********
  4 : ****
  5 : ******
  6 : **********

  For each method, state run time efficiency using Big O notation.

  Tips for Awesome:
  * Keys to Success are so named for a reason.
  * Look over all fxns, think a bit, decide which to tackle first.
  ( Simplest?  Prerequisites? . . . )
  * Develop 1 fxn at a time, test it, then move to next.
  * For coding today, what extra code do you need to get past compiler?
  ====================================================================*/

import java.util.ArrayList;


public class StatPrinter {

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    //runtime: O(n)
    public StatPrinter( ArrayList <Integer> data ) 
    { 
	_frequency = new ArrayList<Integer>();
	
	//inc size to max(data) + 1
	for (Integer i = 0; i < max(data) + 1; i ++){
	    _frequency.add(0);
	}
	//inserting appropriate freq
	for (Integer x : data){
	    _frequency.set(x, _frequency.get(x)+1 );
	}
	//Testing constructor
	/*
	for (Integer x : _frequency){
	    System.out.println(x);
	}
	*/
    }


    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    //runtime: O(n)
    public Integer max( ArrayList <Integer> data ) 
    { 
        Integer maxInt = 0;
	//sets maxInt to largest Integer in data
	for (Integer x : data){
	    if (x > maxInt){
		maxInt = x;
	    }
	}
	return maxInt;
    }


    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    //runtime: O(1)
    public boolean isLocalMode( int i ) 
    { 
        return i > 0 &&
	    i < _frequency.size() - 1 &&
	    _frequency.get(i) > _frequency.get(i-1) &&
	    _frequency.get(i) > _frequency.get(i+1);
	    
	    
    }
    

    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    //runtime: O(n)
    public ArrayList<Integer> getLocalModes() 
    {
	//creates an ArrayList
	ArrayList<Integer> list = new ArrayList<Integer>();
	//uses isLocalMode to create a list of bool corresponding to index
        for( int i = 0; i < _frequency.size(); i++){
	    if (isLocalMode(i)) list.add(i);
	}
	return list;

    }


    //*************** QUESTION 05 **************************
    //precond: longestBar > 0
    //runtime: O(n^2) 
    public void printHistogram( int longestBar ) 
    {
	//determines the scale, used double bc int would not
	//produce enough stars
	double starScale = (double)longestBar /  max(_frequency);
	String s = "";
	//loops through freq list
	for (int i = 0; i<_frequency.size(); i++){
	    s += i + " | ";
	    //appends num of stars propriate to freq
	    for(int stars = 0;
		stars < ((int) _frequency.get(i) * starScale);
		stars++){
		s += "*";
	    }
	    s += "\n";

	}
	//prints out string
	System.out.println(s);
	
    }
 
}//end class StatPrinter
