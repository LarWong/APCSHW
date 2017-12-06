/*
  Larry Wong
  APCS1 p8
  HW47 : ascending
  2017-12-05
*/

/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
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
	_data = new ArrayList();
    }


    public String toString()
    {
	//uses ArrayList toString()
	return _data.toString();
    }


    public Comparable remove( int index )
    {
	//uses ArrayList remove method to remove and return object
	return _data.remove(index); 
    }


    public int size()
    {
	//uses ArrayList size method to return size
	return _data.size();
    }

    
    public Comparable get( int index )
    {
	//uses ArrayList get method to access index
	return _data.get(index);
    }


    public void add(Comparable newVal)
    {
	int index = 0;//holdsnindex where newVal is inserted
	//loops through existing elements (if any)
        for (int i = 0; i < _data.size(); i++){
	    //increments index if newVal is greater than the object at index
	    //continues until object is greater or equal to newVal
	    if (newVal.compareTo(_data.get(i)) > 0)
		index ++;
	}
	//uses ArrayList add-at-index method to insert newVal at index
	_data.add(index,newVal);
	    
    }



    // main method solely for testing purposes
    public static void main( String[] args )
    {
	
	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.add( (int)( 50 * Math.random() ) );

	//check for sorted-ness
	//if msg does not appear, list was sorted
	for( int i=0; i<Franz.size()-1; i++ ) {
	    System.out.println("at i: " + Franz.get(i) );
	    if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
		System.out.println( " *** NOT sorted *** " );
		break;
	    }
	}
	System.out.println( Franz );

	System.out.println( "Testing remove(2)" );
	System.out.println( Franz.remove(2) );
	System.out.println( Franz );

	System.out.println( "Testing size()" );
	System.out.println( Franz.size() );
	
	System.out.println( "Testing get(1)" );
	System.out.println( Franz.get(1) );
	

	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class OrderedArrayList
