/* 
   Larry Wong, Kenny Lin
   APCS1 pd8
   HW53: Solid Comparative Analysis
   2017-12-13
   Team LK
*/


import java.util.ArrayList;
public class SortTester{

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


    public static void main(String[] args){

	//=============BubbleSort==================
	/*
	  The best case for bubble sort is an array that is
	  already sorted such that all elements are in their 
	  final resting place. This is because there will
	  be no swaps that will occur. Swaps are more costly than 
	  comparasons, so just having comparasons reduces the 
	  use of resources.
	*/
	System.out.println("================BubbleSort==================");
	ArrayList<Comparable> bestCaseBub = populate(5, 0, 10);
	System.out.println("Will inform user if swap occurs (as seen above)");
	System.out.println("Preparing best case (already ordered)");
	MySorts.bubbleSort(bestCaseBub);

	System.out.println("\n\nBest case Bub array before sort: " + bestCaseBub);
	MySorts.bubbleSort(bestCaseBub);
	System.out.println("\nBest case Bub array after sort: " + bestCaseBub);
	System.out.println("No Swaps");

	/*
	  The worst case for bubble sort is an array that is 
	  sorted in the reverse order, in other words, sorted
	  in decesnding order. This means that the smallest element(far right)
	  has to swap with every element to the left of it to
	  reach its final resting position. This means that for an array
	  with p elements, p-1 passes are required to sort and requires the 
	  maximum number of swaps an array with p elements can have.
	*/
	ArrayList<Comparable> worstCaseBub = new ArrayList<Comparable>();
	for (Comparable x : bestCaseBub){
	    worstCaseBub.add(0,x);
	}
	
	System.out.println("Will inform user if swap occurs (as seen above)");
	System.out.println("\n\nWorst case Bub array before sort (reverse order of best case): " + worstCaseBub);
	MySorts.bubbleSort(worstCaseBub);
	System.out.println("\nWorst case Bub array after sort: " + worstCaseBub);
	System.out.println("Max num of swaps: 10 or 1+2+...+(n-1) swaps");


	//=============SelectionSort==================
	/*
	  There is no best case for selection sort. This is because
	  even if the list is in order, the algorithm still compares
	  an element to the rest of the array. Even if an element 
	  starts in its final resting position, the algorithm swaps
	  the element with itself. This still costs a swap.
	*/
	System.out.println("=============SelectionSort==================");
	ArrayList<Comparable> bestCaseSel = populate(5, 1, 10);
	System.out.println("Will inform user if swap occurs (as seen above)");
	
	System.out.println("Preparing an ordered case (Selection Sort)");
	MySorts.selectionSort(bestCaseSel);

	
	System.out.println("\n\nBest case Sel array before sort: " + bestCaseSel);
	MySorts.selectionSort(bestCaseSel);
	System.out.println("\nBest case Sel array after sort: " + bestCaseSel);
	System.out.println("Same num of swaps as previous selection sort");

	/*
	  Similar to the best case, there is no worst case. This is due to the 
	  same reasons as above. There will be the same number of comparasons and the same 
	  number of swaps regardless of the order of the elements.
	*/
	ArrayList<Comparable> worstCaseSel = new ArrayList<Comparable>();
	for (Comparable x : bestCaseSel){
	    worstCaseSel.add(0,x);
	}
	
	System.out.println("Will inform user if swap occurs (as seen above)");
	System.out.println("\n\nWorst case Sel array before sort (reverse order of best case): " + worstCaseSel);
	MySorts.selectionSort(worstCaseSel);
	System.out.println("\nWorst case Sel array after sort: " + worstCaseSel);
	System.out.println("Same number of swaps as the previous selection sorts");

	//=============Insertion Sort==================
	/*
	  The best case for insertion sort is the same as 
	  the case for bubble sort: an array that is already sorted 
	  so that all the elements are in their final resting place.
	  The algorithm will still split the array into two parts,
	  sorted and unsorted but because all the elements are 
	  already in order, no swaps will be made. Since comparisons 
	  require less processing power than swaps, this will reduce 
	  the use of resources, making this the best case possible. 
	*/
	System.out.println("================Insertion Sort==================");
	ArrayList<Comparable> bestCaseIns = populate(5, 0, 10);
	System.out.println("Will inform user if swap occurs (as seen above)");
	System.out.println("Preparing best case (already ordered)");
	MySorts.selectionSort(bestCaseIns);

	System.out.println("\n\nBest case Insertion array before sort: " + bestCaseIns);
	MySorts.insertionSort(bestCaseIns);
	System.out.println("\nBest case Insertion array after sort: " + bestCaseIns);
	System.out.println("No Swaps");
	

	  /*
	  The worst case for insertion sort is also an array that 
	  is sorted in reverse order, with the highest element starting 
	  on the left side and descending towards the left. Insertion sort 
	  compares the first element of the unsorted array with those of the 
	  sorted array, starting with the highest element and swapping until
	  it reaches its point of insertion. Since the array is in reverse
	  order, the next element in the sorted array will always be the next
	  smallest element in the array, meaning that it will have to compare
	  and swap with each element in the sorted array every pass. This 
	  results in the most number of passes and swaps possible making this 
	  the worst case for insertion sort. 
	*/

	ArrayList<Comparable> worstCaseIns = new ArrayList<Comparable>();
	for (Comparable x : bestCaseIns){
	    worstCaseIns.add(0,x);
	}
	System.out.println("Will inform user if swap occurs (as seen above)");
	System.out.println("\n\nWorst case Ins array before sort (reverse order of best case): " + worstCaseIns);
	MySorts.selectionSort(worstCaseIns);
	System.out.println("\nWorst case Ins array after sort: " + worstCaseIns);
	MySorts.insertionSort(worstCaseIns);
	System.out.println("Max num of swaps: 10 or 1+2+...+(n-1) swaps");
    }
}
