/*
Larry Wong
APCS1 pd8
HW57: How Deep Does the Rabbit Hole Go?
2017-12-19
*/
/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) 
    {
	matrix = new Object[2][2];//defualt size 2x2
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	matrix = new Object[a][a];//axa
    }

    
    //return size of this matrix, where size is 1 dimension
    //O(1)
    private int size() 
    {
	return matrix.length;//row length = column length
    }
    

    //return the item at the specified row & column
    //O(1)
    private Object get( int r, int c ) 
    {
	return matrix[r][c];
    }
    
    
    //return true if this matrix is empty, false otherwise
    //O(n)
    private boolean isEmpty() 
    {
	for (Object x[] : matrix){
	    for (Object y : x){
		if (y != null){
		    System.out.println(y);
		    return false;
		}
	    }
	}
	return true;
    }
    
    
    //overwrite item at specified row and column with newVal
    //return old value
    //O(1)
    private Object set( int r, int c, Object newVal ) 
    {
	Object holder = matrix[r][c];
	matrix[r][c] = newVal;
	return holder;
    }
    


    //return String representation of this matrix
    // (make it look like a matrix)
    //O(n)
    public String toString() 
    {
	String s = "-\n";
	//loops through element to append them to String
	for (int r = 0; r < size(); r++){
	    s += "|  ";
	    for (int c = 0; c < size(); c++){
		s += " " + matrix[r][c];
	    }
	    s+= "   |\n";

	}
	return s;
    }

    
    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    //O(n)
    public boolean equals( Object rightSide ) 
    {
	//checks if rightSide is a Matrix
	if  (! (rightSide instanceof Matrix)){
	    throw new ClassCastException("\nNot recognizable as a Matrix! "
					 + " equals() input not a Matrix");
	}
	
	//if is a Matrix, checks size first
	if (size() == ((Matrix)rightSide).size()){
	    //loops through elements of matrix
	    for (int r = 0; r < size(); r++){
		for (int c = 0; c < size(); c++){
		    //if the elements coppresponding to each other are not equal
		    //returns a false and ends method
		    if (! (get(r,c).equals(((Matrix)rightSide).get(r,c)))){
			return false;
		    }
		}
	    }
	    //if nothing happens, they are equal
	    return true;
	}
	//if size check fails
	return false;
	
    }
			

	
    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    //O(n)
    public void swapColumns( int c1, int c2  ) 
    {
	//checks if columns exist, range: 1 - size()
	if ( (c1 < 1 && c1 > size() ) &&
	     (c2 < 1 && c2 > size() )){
	    System.out.println("Out of bounds. 1-matrix.size() only");
	    return;
	}
	//reduces input by 1 to match indices
	c1 -= 1;
	c2 -= 1;
	//loops through each row
	//swaps c1 and c2 elements of each row
	for (int r = 0; r < size(); r++){
	    Object holder = matrix[r][c1];//holds old
	    matrix[r][c1] = matrix[r][c2];
	    matrix[r][c2] = holder;

	}
    }
    

    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    //O(n)
    public void swapRows( int r1, int r2  ) 
    {
	//checks if columns exist, range: 1 - size()
	if ( (r1 < 1 && r1 > size() ) &&
	     (r2 < 1 && r2 > size() )){
	    System.out.println("Out of bounds. 1-matrix.size() only");
	    return;
	}
	//reduces input by 1 to match indices
	r1 -= 1;
	r2 -= 1;
	//loops through each column
	//swaps r1 and r2 elements of each column
	for (int c = 0; c < size(); c++){
	    Object holder = matrix[r1][c];
	    matrix[r1][c] = matrix[r2][c];
	    matrix[r2][c] = holder;

	}
    }

	
    //main method for testing
    public static void main( String[] args ) 
    {
	System.out.println("Testing default constructor");
	Matrix test0 = new Matrix();
	System.out.println(test0);
	System.out.println("\n\n");

	System.out.println("Testing overloaded constructor");
	Matrix test1 = new Matrix(3);
	System.out.println(test1);
	System.out.println("\nTesting get(0,0) of test1");
	System.out.println(test1.get(0,0));
	System.out.println("\nTesting size() of test1");
	System.out.println(test1.size());
	System.out.println("\nTesting isEmpty() of test1");
	System.out.println(test1.isEmpty());

	System.out.println("\nCreating new Matrix: test2 ...");
	Matrix test2 = new Matrix(3);

	System.out.println("\nTesting set() of test1 & test2: new & diff values");
	test1.set(0,0,"cool");
	test2.set(0,0,"uncool");

	System.out.println("\ntest1 and test2 (respectively)");
	System.out.println(test1);
	System.out.println(test2);

	System.out.println("\nTesting test1.equals(test2) after change, Expect: false");
	System.out.println(test1.equals(test2));

	System.out.println("\nFilling up test1 w/ nums....");
	int num = 0;
	for (int r = 0; r < test1.size(); r++){
	    for (int c = 0; c < test1.size(); c++){
		test1.set(r,c,num);
		num ++;
	    }
	}
	    
	System.out.println("\n" + test1 + "\n");
	
	System.out.println("\nSwapping rows 1 & 3 (0,2)");
	test1.swapRows(1,3);
	System.out.println("\n" + test1 + "\n");

	System.out.println("\nSwapping columns 1 & 2 (0,1)");
	test1.swapColumns(1,2);
	System.out.println("\n" + test1 + "\n");
	    

	    
      
      
    }

}//end class Matrix
