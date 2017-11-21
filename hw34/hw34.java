/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

// Larry Wong
// APCS1 pd08
// HW34 -- Arrays of Arrays
// 2017-11-17

public class TwoDimArray
{
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a )
    {
	for (int r = 0; r < a.length; r++){
	    for (int i = 0; i < a[r].length; i++){
		System.out.print(a[r][i] + " ");//print item at row r and column i
			       
	    }
	    System.out.println();//provides the newline
	}
    }//end print1()

    
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a )
    {
	for (int[] c : a){
	    for (int x : c){
		System.out.print(x + " ");//print the item at each index in each array
	    }
	    System.out.println();//provides the newline
	}
    }//end print2()

    
    //postcond: returns sum of all items in 2D int array a
    public static int sum1( int[][] a )
    {
	int total = 0;//hold the sum
	for (int[] c : a){
	    for (int x : c){
		total += x;//adds the item in each index of each column to total
	    }
	}
	return total;
	
    }//end sum1)()

    
    //postcond: returns sum of all items in 2D int array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m )
    {
	int total = 0;
	for( int r = 0; r < m.length; r ++){
	    total += sumRow(r,m);//uses helper fxn to get sum of each row and add it to total
	}
	return total;
    }//end sum2()

    
    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a )
    {
	int total = 0;
	for(int i = 0; i < a[r].length; i ++){
	    total += a[r][i];//adds each item at row r and column i to total
	}
	return total;
    }//end sumRow

    
    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOREACH loop
    public static int sumRow2(int r, int[][] m)
    {
	int total = 0;
	for( int i: m[r] ){
	    total += i;//adds item at each index from each array to total
	}
	return total;
    }//end sumRow2()
    


    public static void main( String [] args )
    {
    
	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	print1(m1);
	print1(m2);
	print1(m3);
	
	print2(m1);
	print2(m2);
	print2(m3);

	System.out.print("testing sum1...\n");
	System.out.println("sum m1 : " + sum1(m1));//0
	System.out.println("sum m2 : " + sum1(m2));//27
	System.out.println("sum m3 : " + sum1(m3));//21

	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));//0
	System.out.println("sum m2 : " + sum2(m2));//27
	System.out.println("sum m3 : " + sum2(m3));//21

	System.out.print("testing sumRow2...\n");
	System.out.println("sumRow2 m1 row 3 : " + sumRow(3,m1));//0
	System.out.println("sumRow2 m1 row 2 : " + sumRow(2,m1));//0
	System.out.println("sumRow2 m2 row 0 : " + sumRow(0,m2));//12
	System.out.println("sumRow2 m2 row 1 : " + sumRow(1,m2));//15
	System.out.println("sumRow2 m3 row 1 : " + sumRow(1,m3));//10
	System.out.println("sumRow2 m3 row 2 : " + sumRow(2,m3));//9
    }

}//end class TwoDimArray
