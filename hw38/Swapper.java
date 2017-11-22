//Larry Wong
//APCS1 pd8
//HW38 -- Put It Together
//2017--11-21

/*Summary:
First, a 2D array with specific dimensions is created and is filled with random
unique Strings. The array is printed to be compred with the final array. Next,
this code uses readInt() from Keyboard.java to get user input and stores these
inputs into a 2D array. This 2D array is passed through a swap method that swaps
the igems around based on their index. Finally, the original 2D array is printed
again with the changes.
*/

import cs1.Keyboard;
    
public class Swapper{
    //used to create random unique 5 character strings
    private static final String _LETTERS = "abcdefghijklmnopqrstuvwxyz1234567890";

    //creates random 5 character strings
    public static String randGen(){
	String s = "";
	//loop repeats a random selection 4 times and returns the result 
	for (int x = 0; x < 5; x++){
	    int rand = (int)(Math.random() * _LETTERS.length());
	    s+= _LETTERS.substring(rand, rand + 1);
	}
	return s;
    }//end randGen

    //uses randGen to fill up 2D arrays using for loops to go to each index
    public static void fillUp(String[][] x){
	for( int y = 0; y < x.length; y++){
	    for ( int z = 0; z < x[y].length; z++){
		x[y][z] = randGen();
	    } 
	}
    }//end fill up

    //converts an 2D array into a String and returns it to be printed
    public static String printStuff(String[][] y){
	String holder = "";
	for (String[] x : y){
	    for (String z : x){
		holder += z + ", ";
	    }
	    holder += "\n";
	}
	return holder;
    }//end printStuff

    //swaps two items in a 2D array using a separate 2D array as index holders
    public static void swap(String[][] Array, int[][] y){
	int r1 = y[0][0];
	int c1 = y[0][1];

	int r2 = y[1][0];
	int c2 = y[1][1];

	//creates var to hold an item
	String holder = Array[r1][c1];
	Array[r1][c1] = Array[r2][c2];
	Array[r2][c2] = holder;
	


    }//end swap

    //main tests all methods
    public static void main(String[] args){
	//creates an 2D array
	String[][] Array = new String[3][3];
	//occupied the array
	fillUp(Array);
	//prints out the array
	System.out.println(printStuff(Array));

	//creates another 2D array to hold user input as arrays
	int[][] index = new int[3][3];
	System.out.println("Choose row of first item:");
	index[0][0] = Keyboard.readInt();
	System.out.println("Choose column of first item:");
	index[0][1] = Keyboard.readInt();
	System.out.print("First item: ");
	System.out.println(Array[index[0][0]][index[0][1]] + "\n");
	

	System.out.println("Choose row of second item:");
	index[1][0] = Keyboard.readInt();
	System.out.println("Choose row of second item:");
	index[1][1] = Keyboard.readInt();
	System.out.print("Second item: ");
	System.out.println(Array[index[1][0]][index[1][1]] + "\n");

	//swaps the items
	swap( Array, index);
	//prints out new array
	System.out.println("\nNew Array: \n \n" + printStuff(Array));

	
	
	
	
	
    }//end main
	
}//end class
