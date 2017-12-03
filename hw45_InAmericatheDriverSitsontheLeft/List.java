/***************************
 * interface ListInt
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of a list of ints.
 ***************************/

public interface List
{
  // Return number of elements in the list
  int size();

  // Append an int to the end. Return true.
  boolean add( Object num );

  // Retrieve the int at index
  Object get( int index );

  // Overwrite the int at index
  Object set( int index, Object num );

     /*

     //Testing methods not in interface
     //removes object at index and returns it
     Object remove(int index);

     //adds object at index, moves thing to the right
     void add(int index, Object newObj);

   

     */


}//end interface ListInt
