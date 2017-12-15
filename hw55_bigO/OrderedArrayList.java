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
    
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    _data = new ArrayList<Comparable>();    
  }

    //toStrind() is O(n)
  public String toString()
  {
    return _data.toString(); 
  }

    //remove() is O(n)
  public Comparable remove( int index )
  {	
    return _data.remove(index); 
  }

    //size() is O(1)
  public int size()
  { 
    return _data.size();
  }

    //get is O(1)
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
    //add() is O(n)
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
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class OrderedArrayList
