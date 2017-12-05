/*
  Larry Wong
  APCS1 pd8
  HW46: Al<B> Sorted!
  2017-12-03
*/

import java.util.ArrayList;

public class ALTester{

    //populate: takes an existing array with randomly generated ints from 0-100
    //precond: array input
    //postcod: array w/ random values
    public static void populate(ArrayList<Comparable> x){
	for (int index = 0; index < 23; index++){
	    x.add((int) ( Math.random() * 100)); //typecasting
	}
    }//end populate()

    //order: checks the array is ints are increasing in order
    //precond: array w/ ints
    //postcod: boolean 
    public static boolean order(ArrayList<Comparable> x){
	for (int i = 0; i < x.size()-2; i++){
	    // -1 for max index,
	    // -1 to prevent out of bounds error
	    if (x.get(i).compareTo(x.get(i+1)) > 0)
		return false;
	    //ends loop when first error spotted
	}
	return true;
    }//end order()
    

    public static void main(String[] args){
	
	//-----------------------------------------------------------
	//Testing functionality of order()
	//order() will most likely return false for random ints
	//specific case to test if it would return a true
	ArrayList<Comparable> testingOrder = new ArrayList<Comparable>();
	//new ArrayList with type Comparable

	System.out.println("Testing order() for true: ");
	testingOrder.add(1);
	testingOrder.add(2);
	testingOrder.add(3);
	testingOrder.add(4);

	System.out.println("Test array: ");
	System.out.println(testingOrder);
	System.out.println("In order?");
	System.out.println(order(testingOrder));
	//-----------------------------------------------------------

	//Real test:
	//All functions: populate() and order()
	ArrayList<Comparable> testing = new ArrayList<Comparable>();
	//new ArrayList with type Comparable
	
	populate(testing);
	System.out.println("\nDisplay array: ");
	System.out.println(testing);
	System.out.println("Size: " + testing.size());
	System.out.println("In order?");
	System.out.println(order(testing));
	


    }


}
   
