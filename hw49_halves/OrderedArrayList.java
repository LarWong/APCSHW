/*
Larry Wong
APCS1 pd8
HW48 -- Halving the Halves
2017-12-07
*/

/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 * linear search to insert element
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList()
    {
	_data = new ArrayList<Comparable>();    
    }


    public String toString()
    {
	return _data.toString(); 
    }


    public Comparable remove( int index )
    {	
	return _data.remove(index); 
    }


    public int size()
    { 
	return _data.size();
    }

    
    public Comparable get( int index )
    { 
	return _data.get(index); 
    }


    /***
     * add takes as input any comparable object 
     * (i.e., any object of a class implementing interface Comparable)
     * inserts newVal at the appropriate index
     * maintains ascending order of elements
     * uses a linear search to find appropriate index
     ***/
    public void add( Comparable newVal )
    { 
	for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
		//newVal < oal[p]
		_data.add( p, newVal );
		return; //Q:why not break?
	    }
	}
	_data.add( newVal ); //newVal > every item in oal, so add to end 
    }

    /***
	addBin(), 
	which employs a binary search to locate the point of insertion 
	for a new element.
    ***/
    public void addBin( Comparable newVal){
	//instance vars to set range and mid number
	int _lo = 0;
	int _hi = _data.size()-1;
	int _mid = _hi/2;

	//to check if newVal is the lower than the lowest
	//loop does not account for this bc it adds to the index
	//1 more than the last mid check
	if (newVal.compareTo(_data.get(_lo)) <= 0){
	    _data.add(_lo,newVal);
	    return;
	}
	
	//run loop as long as the size of the range is >= 0
	while (_hi >= _lo){
	   
	    
	    //if newVal is lower than the mid, sets mid as new _lo-1
	    if (newVal.compareTo(_data.get(_mid)) < 0){
		System.out.println("Too high");
		_hi = _mid-1;	
	    }else{
		//if newVal is lower than the mid, sets mid as new _lo-1
		_lo = _mid+1;
		System.out.println("Too low");
	    }
	    //prints out the current mid number
	    System.out.println("Middle: " + _data.get(_mid));
	    
	    //halves _mid everytime
	    _mid = (_lo + _hi)/2;


	}
	//uses _mid to add newVal
	//+1 to put the number in front of the last check
	_data.add(_mid+1,newVal);
	




    }



    // main method solely for testing purposes
    public static void main( String[] args )
    {
	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.add( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	//check for sorted-ness
	//if msg does not appear, list was sorted
	for( int i=0; i<Franz.size()-1; i++ ) {
	    System.out.println("at i: " + Franz.get(i) );
	    if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
		System.out.println( " *** NOT sorted *** " );
		break;
	    }
	}

	/*
	  Tests four cases:
	  1. insert a num lower than _lo
	  2. insert a num somewhere in the middle
	  3. insert a num that exists already in array
	  4. insert a num greater than _hi
	*/
	
	System.out.println("\n\nArray: " + Franz + "\n");
	Franz.addBin(0);
	System.out.println("\n\nArray: " + Franz + "\n");

	System.out.println("\n\nArray: " + Franz + "\n");
	Franz.addBin(16);
	System.out.println("\n\nArray: " + Franz + "\n");

	System.out.println("\n\nArray: " + Franz + "\n");
	Franz.addBin(21);
	System.out.println("\n\nArray: " + Franz + "\n");

	System.out.println("\n\nArray: " + Franz + "\n");
	Franz.addBin(21);
	System.out.println("\n\nArray: " + Franz + "\n");


	System.out.println("\n\nArray: " + Franz + "\n");
	Franz.addBin(89);
	System.out.println("\n\nArray: " + Franz + "\n");
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class OrderedArrayList
