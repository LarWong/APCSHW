// Larry Wong
// APCS1 pd8
// HW45: In America, the Driver Sits on the Left
// 2017-12-04M

/***************************
 * class SuperArray version 4.0
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the List
 * interface. (List.java must be in same dir as this file)
 ***************************/

public class SuperArray implements List
{
    private Object[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor – initializes 10-item array
    public SuperArray()
    {
	_data = new Object[10];
	_size = 0;
    }


    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of SuperArray
    private void expand()
    {
	Object[] temp = new Object[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

    //adds an item after the last item
    public boolean add( Object newVal )
    {
	add( _size, newVal );
	return true;
    }


    //inserts an item at index
    public void add( int index, Object newVal )
    {
	if (index > _size || index < 0){
	    throw new ArrayIndexOutOfBoundsException("Out of Bounds");
	}
	//first expand if necessary
	if ( _size >= _data.length )
	    expand();
	for( int i = _size; i > index; i-- ) {
	    _data[i] = _data[i-1]; //each slot gets value of left neighbor
	}
	_data[index] = newVal;
	_size++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    //returns removed value
    public Object remove( int index )
    {
	if (index > _size || index < 0){
	    throw new ArrayIndexOutOfBoundsException("Out of Bounds");
	}
	Object retObj = _data[index];
	for( int i = index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_size--;
	return retObj;
    }


    //return number of meaningful items in _data
    public int size()
    {
	return _size;
    }

    //accessor -- return Object at specified index
    public Object get( int index ){
	if (index > _size || index < 0){
	    throw new ArrayIndexOutOfBoundsException("Out of Bounds");
	}
	return _data[index];
    }

    //mutator -- set value at index to newObj,
    //           return oldObj value at index
    public Object set( int index, Object newObj){
	if (index > _size || index < 0){
	    throw new ArrayIndexOutOfBoundsException("Out of Bounds");
	}
	Object oldObj = _data[index];
	_data[index] = newObj;
	return oldObj;	

    }
    



    //main method for testing
    public static void main( String[] args )
    {
	List mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add("I");
	mayfield.add("have");
	mayfield.add("finished");
	mayfield.add("my");
	mayfield.add("homework");

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	System.out.println("Printing get(1)...");
	System.out.println(mayfield.get(1));

	System.out.println("Printing SuperArray with set(2,'cool')...");
	System.out.println(mayfield.set(2,"cool"));

	/*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
	//Testing methods not in interface
	System.out.println("Now Removing...");
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	
	System.out.println("Now Adding at index...");
	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	
	
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
    }//end main()


}//end class


/***
    ,,########################################,,
    .*##############################################*
    ,*####*:::*########***::::::::**######:::*###########,
    .*####:    *#####*.                 :*###,.#######*,####*.
    *####:    *#####*                      .###########*  ,####*
    .*####:    ,#######,                        ##########*    :####*
    *####.    :#########*,                       ,,,,,,,,.      ,####:
    ####*  ,##############****************:,,               .####*
    :####*#####################################**,        *####.
    *############################################*,   :####:
    .#############################################*,####*
    :#####:*****#####################################.
    *####:                  .,,,:*****###########,
    .*####,                            *######*
    .####* :*#######*               ,#####*
    *###############*,,,,,,,,::**######,
    *##############################:
    *####*****##########**#####*
    .####*.            :####*
    :####*         .#####,
    *####:      *####:
    .*####,  *####*
    :####*####*
    *######
    *##

    -Miranda Chaiken '16

***/
