/*
  Larry Wong
  APCS1 pd8
  HW52: Poker Face
  2017-12-12
*/
/***************************************
 *  class InsertionSort -- implements InsertionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class InsertionSort
{
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
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSortV( ArrayList<Comparable> data )
    {
	//number of passes = n-1
	//each pass keeps track of an unsorted element
	for (int pass = 0; pass < data.size(); pass++){

	    System.out.println("Pass# : " + pass);
	  
	    int holder = pass;//keeps track of element

	    //while loop bc process is repetitive & takes into account out of bounds
	    while (holder-1 >= 0 &&
		   data.get(holder).compareTo(data.get(holder-1)) < 0)
		{
		    //if index-1 is in the array, then compare index w/ index-1
		    //if index > index-1, swaps & repeats until it is greater than the
		    //relatively sorted elements
	      
		    System.out.println(data.get(holder) + " swaps with " +
				       data.get(holder-1));
		    //swap
		    data.set( holder, ( data.set( holder-1, data.get(holder) ) ) );
		  
		    System.out.println("New Array: " + data);
		    holder--;//reduces holder to go down the array.


		}
	  


	}



}//end insertionSortV


// ArrayList-returning insertionSort
// postcondition: order of input ArrayList's elements unchanged
//                Returns sorted copy of input ArrayList.
public static ArrayList<Comparable>
insertionSort( ArrayList<Comparable> input )
{
    ArrayList<Comparable> output = new ArrayList<Comparable>();
    for (Comparable x:input){
	output.add(x);//copys input into new array
    }
    insertionSortV(output);//sorts
    return output;
}//end insertionSort


public static void main( String [] args )
{
    /*===============for VOID methods=============
    System.out.println("\n*** Testing sort-in-place (void) version... *** ");
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "\nArrayList glen before sorting:\n" + glen );
    insertionSortV(glen);
    System.out.println( "\nArrayList glen after sorting:\n" + glen );

    
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      insertionSortV(coco);
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
     
      ============================================*/

    
      System.out.println( "*** Testing non-void version... *** " );
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = insertionSort( glen );
      System.out.println( "\nsorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = insertionSort( coco );
      System.out.println( "\nsorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      /*==========for AL-returning methods==========
      ============================================*/

}//end main

}//end class InsertionSort
