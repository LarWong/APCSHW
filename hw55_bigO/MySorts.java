/* 
   Larry Wong, Kenny Lin
   APCS1 pd8
   HW55: Never Fear, Big Oh Is Here!
   2017-12-14
   Team LK
*/


import java.util.ArrayList;
public class MySorts{

    /*
    Methods in OrderedArrayList:

    remove():
    Best case: O(1) The element at the right most end of the dataset will be removed. There is no 
    need to shift elements to the left since there are no elements to the right of the right most element.
    Worst case: O(n) The element removed is the removed is the left most element. This would mean that 
    all the elements to the right of the first element has to be shifted to the left by one. 
    This is linear
    
    size() is O(1) => it does returns variable size and nothing else all the time, so it is constant.

    get() is O(1) => it goes to the index and returns the value and nothing else, so it is constant.

    add():
    Best case: O(1) The algorithm would place the item at index 0 since it would be the smaller than
    the smallest element in the array. There would be only one comparison
    Worst case: O(n) The algorithm would have to compare the item to all the elements from the start
    of the list to the end and place the item at the end since it would be the new largest element.

    addBin():
    Best case: O(1) The algorithm would do one comparison with the middle number in the data and place 
    the item. This would require only one comparison, so it would be constant
    Worst case: O(log2n) The algorithm would have to place the element at either ends of the array or
    the the left or right of the middle number. This would require the algorithm to divide the dataset 
    long2n times before it can place the item.
    
    */
    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    /*
    Best Case: Sorted => is O(n^2)
    When the data is already sorted in ascending order, the algorithm
    still goes through the data. For n elements, the algorithm goes through n-1
    passes. In each pass, it checks the order of adjacent elements n-p times,
    where p is the number of the current pass. So, for n elements, there would 
    be (n-1)+(n-2)+(n-3)+...+1 comparisons, or n(n-1)/2 comparisons in total. This is an
    order of n^2.
    */
    /*
    Worst Case: Sorted in reverse order => is O(n^2)
    When the data is sorted in the reverse order, descending elements, the 
    algortithm has to comparisons and swap elements. For a dataset of n elements,
    the algorithm goes through n-1 passes and each pass has swaps that are one
    less than the previous swap. This would be (n-1)+(n-2)+(n-3)+...+1 swaps,
    or n(n-1)/2 swaps in total, and as esablished earlier, there will be n(n-1)/2 
    checks as well. Added together, this is an O(n^2).
    */
    public static void bubbleSort( ArrayList<Comparable> data )
    {
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );

	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) {
		    data.set( i, data.set(i+1,data.get(i)) );
		    System.out.println("SWAPPED!!!!");
		    System.out.println(data);
		   
		}
		
	    }
	     System.out.println(data); //diag: show current state of list
	}
    }

    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
     /*
    Best Case: There is no best case. Default => is O(n^2)
    Regardless of whether or not the dataset is sorted, the algorithm proceeds
    to pass through the data n-1 times for n elements. In addition, it would 
    swap an element with itself if there are no other bigger values. The function
    would be n(n-1)/2 +1 (for the number of comparisons, and + 1 for the insertion).
    This is O(n^2).
    */
    /*
    Worst Case:  There is no best case. Default => is O(n^2)
    This is so for the same reason as the best case. There are n(n-1)/2 comparisons
    and a 1 for the insertion regardless of the order of the dataset. So, 
    this is O(n^2).
    */
    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
	    
	    for( int i = 1; i <= pass; i++ ) {
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    System.out.println("SWAPPED!!!");
	    System.out.println( "after swap: " +  data );//diag
	}
    }//end selectionSort

    
    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // postcondition: data's elements sorted in ascending order
     /*
    Best Case: Sorted => is O(n)
    When a dataset is sorted, the algorithm does one comparison for each element.
    For example, in a dataset of [1,2,3], there will be a comparison between 1 & 2
    and 2 & 3 with no swaps. so the function would be n-1, for n elements. so, this 
    is O(n).
    */
    /*
    Worst Case: Sorted in reverse order => is O(n^2)
    When a dataset is in reverse order, there will be swaps for each pass.
    For example, in a dataset of [4,3,2,1], 3 swaps with 4, 2 swaps with 3 and 4,
    and 1 swaps for 4, 3 and 2. This is a total of 6 swaps for n(n-1)/2 swaps with 
    n(n-1)/2 comparisons. This is O(n^2).
    */
    public static void insertionSort( ArrayList<Comparable> data )
    {
	for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.println( "\npartition: " + partition + "\tdataset:");
	    System.out.println( data ); 

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    //diag:
		    System.out.println("SWAPPED!!!");
		    System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
    }//end insertionSort







}
