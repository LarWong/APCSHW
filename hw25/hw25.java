/*
  Larry Wong
  APCS1 pd8
  HW25 -- All Hallow's Eve 
  2017-10-31
*/

public class Loopier{

    //populate: takes an existing array with randomly generated ints from 0-100
    //precond: array input
    //postcod: array w/ random values
    public static int[] populate(int[] anArray){
	for (int index = 0; index < anArray.length; index++){
	    anArray[index] = (int) ( Math.random() * 100); //typecasting
	}//end for loop
	return anArray;
    }//end populate()


    //stringify: takes elements from an array and creates a string out of them
    //precond: array input
    //postcod: string w/ elements, space separated
    public static String stringify(int[] anArray){
	String nums = "";//holds the str
	
	for (int x: anArray){
	    nums += Integer.toString(x) + " ";
	}//end for each loop
	
	return nums;
    }//end stringify


    //linSearch: takes an existing array and iterates through array for the first
    //           instance of target num.
    //precond: array input & target num
    //postcod: index of first occurance of target in string, else returns -1
    public static int linSearch(int[] a, int target){
	for (int index = 0; index < a.length; index++){
	    if (a[index] == target){
		return index;
	    }//end if
	}//end for loop
	return -1;
    }//end linSearch


    //reduceArray: helper method to create an array from an existing array without index 0
    //precond: array input
    //postcod: new array w/ elements 0-array.length
    public static int[] reduceArray(int[] a){
	int[] array = new int[a.length-1];//creates a new array to return
	for (int index = 1; index < a.length; index++){
	    array[index-1] = a[index];
	}//end for loop
	return array;
       
    }//end reduceArray


    //linSearchR: takes an existing array and recursively goes through array for the first
    //           instance of target num.
    //precond: array input
    //postcod: index of first occurance of target in string, else returns -1
    public static int linSearchR(int[] a, int target){
	if (a.length == 0){
	    return -1;
	}//end 1st basecase
	if (a[0] == target){
	    return 0;
	}//end 2nd basecase, returns 0 to stop count
	if (linSearchR(	reduceArray(a), target ) == -1){
	    return -1;
	}//checks if array doesnt have target, does not count
	return 1 + linSearchR(reduceArray(a), target);
	//has target, returns count
	//
  
    }//end linSearchR


    //freq: takes an existing array and returns # of occurances of target num
    //      through iteration
    //precond: array input
    //postcod: num of occurances of target num
    public static int freq(int[] a, int target){
	int ctr = 0;//holds num of occurances
	for( int x: a ){
	    if (x == target){
		ctr++;
	    }//end if
	}//end for each loop
	return ctr;
    }//end freq


    //freqRec: takes an existing array and returns # of occurances of target num
    //      through recursion
    //precond: array input
    //postcod: num of occurances of target num
    public static int freqRec(int[] a, int target){
	if (a.length == 0){
	    return 0;
	}//1st basecase, end of array
	if (a[0] == target){
	    return 1 + freqRec(reduceArray(a),target);
	}//2nd base case,
	return freqRec(reduceArray(a),target);
	
    }//end freqRec

    
    //main: tests functions above
    //precond: none
    //postcond: none
    public static void main(String[] args){
	int[] Array = {10,32,23,23,45,74,45,11,23,11};
	//Array = new int[10];
	
	//populate(Array);

	//Test stringify
	System.out.println(stringify(Array));//10 32 23 23 45 74 45 11 23 11

	//Test linear search methods: (Iteration then Recursive)
	System.out.println(linSearch(Array , 11));//7
	System.out.println(linSearch(Array , 32));//1

	System.out.println(linSearchR(Array , 11));//7
	System.out.println(linSearchR(Array , 32));//1

	//Test helper function reduceArray
	System.out.println(stringify(reduceArray(Array)));// 32 23 23 45 74 45 11 23 11

	//Test frequency methods 
	System.out.println(freq(Array, 11));//2
	System.out.println(freq(Array, 11));//2
	
	System.out.println(freqRec(Array, 23));//3
	System.out.println(freqRec(Array, 23));//3


    }//end main()
}//end class
