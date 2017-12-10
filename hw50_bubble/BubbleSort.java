/*
  Larry Wong
  APCS1 pd8
  HW50 --  Dat Bubbly Tho
  2017-12-11M
*/

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	//setup for traversal fr right to left
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data )
    {
	//counts the number of swaps
	//if num = 0 in any pass, list is sorted
	int swapNum = 0;
	
	//passes through n-1 times (if necessary)
	for (int pass = 0; pass < data.size()-1; pass++){
	    
	    //each pass goes through the whole list
	    for (int index = 0; index < data.size()-1; index++){
		
		//if element is greater than the adjacent (from left to right), swap
		if (data.get(index).compareTo(data.get(index+1)) > 0){
		    Comparable holder = data.get(index + 1);//holds element after index
		    data.remove(index + 1);//removes element after index
		    data.add(index, holder);//inserts element before the index element
		     
		    swapNum ++;//inc swap

		}


	    }
	    //keeps track of each pass
	    System.out.println("\nPassNumber: " +( pass+1));
	    System.out.println("\n"+data+"\n");

	    //if no swaps, list sorted
	    //ends loop and method
	    if (swapNum == 0)
		return;

	    //resets num after every pass
	    swapNum = 0;

	}
    }

    
    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
	//creates a new ArrayList with contents of input
	//copy elements from input to output
	ArrayList<Comparable> output = new ArrayList<Comparable>(input);

	//uses previous bubblesort method to sort output
	bubbleSortV(output);
	//returns output
	return output;
    }


    public static void main( String [] args )
    {


	/*===============for VOID methods=============
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	bubbleSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );
	
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	bubbleSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	
	  ============================================*/


	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = bubbleSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = bubbleSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println( coco );
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class BubbleSort
