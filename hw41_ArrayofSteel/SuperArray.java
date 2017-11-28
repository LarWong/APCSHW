/*
Larry Wong
APCS1 pd8
HW41-- Array of Steel
2017 - 11 - 27
*/

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
      _data = new int[10];
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
      String arr = "[";
      //uses a for loop to stop at the 2nd to last element
      for (int index = 0; index < _data.length-1;index++ ){
	  arr += _data[index] + ",";
      }
      //adds last element and closing bracket
      return arr + _data[_data.length-1] + "]";
      
  }


  //double capacity of SuperArray
  private void expand()
  {
      //creates a new array w/ twice the length
      int[] _newData = new int[2*_data.length];
      for (int i = 0; i < _data.length; i ++){
	  _newData[i] = _data[i];
      }
      _data = _newData;
      
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
      return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
      
      int oldVal = _data[index];//holds the old value
      _data[index] = newVal;//sets to new value
      return oldVal;//returns holder
      
  }


  //main method for testing
  public static void main( String[] args )
  {
    
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
      

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing out get(3);");
      System.out.println(curtis.get(3));//6

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
      //10X items
      //20X items
      //40x items
      /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
	      
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
