/*
  Larry Wong
  APCS1 pd8
  HW51: Selection
  2017-12-11
  /*

  /***************************************
  * class SelectionSort -- implements SelectionSort algorithm
  ***************************************/

import java.util.ArrayList;

public class SelectionSort 
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


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	int theChamp = 0;//holds the index of lowest element

	//each pass checks index pass to end
	for (int pass = 0; pass < data.size(); pass ++){
	    //prints pass
	    //System.out.println("pass: " + pass);
	 
	    theChamp = pass;//starts with the element at index pass
	    for (int index = pass; index < data.size(); index ++){
	      
	      
	      
		//prints out data at index and the current lowest element
		//System.out.println("At index: " + data.get(index));
		//System.out.println("At champ: " + data.get(theChamp));

		//if index is lower than the current lowest, changes the current lowest
		if (data.get(index).compareTo(data.get(theChamp)) <= 0){

		  
		 
		    theChamp = index;
		    //prints the newest lowest if a change occurs
		    //System.out.println("New Champ: " + theChamp);

		}

	    }
	    //prints what is swapped and does the swap using code
	    //from bubble sort
	    //System.out.println(pass + " swaps with " + theChamp);
	    data.set( pass, data.set(theChamp,data.get(pass)) );
	    //prints new array
	    //System.out.println(data);



	} 
    }//end selectionSortV


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable>
	selectionSort( ArrayList<Comparable> input ) 
    {
	//creates new array and fills it with elements from input
	ArrayList<Comparable> output = new ArrayList<Comparable>();
	for (Comparable x : input){
	    output.add(x);
	}
	//uses prev sort to sort new array
	selectionSortV(output);
	return output;//returns the new array
    }//end selectionSort 


    public static void main( String [] args ) 
    {
	/*
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  selectionSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );
	*/
	/*===============for VOID methods=============
	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  selectionSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
      
	  ============================================*/

    
    	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = selectionSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = selectionSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println( coco );
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort
