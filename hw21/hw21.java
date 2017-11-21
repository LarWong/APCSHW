//Larry Wong
//APCS1 pd8
//HW21 -- Karmacomma
//2017-10-23

public class Commafier{

    /*
      Each method takes a non-negative integer input and returns the number as a 
      String with commas inserted appropriately using a for loop
    */
    public static String commafyF(int num){
	
	String numS = Integer.toString(num);//to convert int to str
	String newNum = "";//to build the string

	//loop to build str from L to R
	for (int x = numS.length(); x > 3; x -=3){
	    newNum =  "," + numS.substring(x-3,x) + newNum;//adding last 3 nums with comma to new str
	    numS = numS.substring(0,x-3);//reducing the str by 3 from the end
	}//end for loop
	
	newNum = numS + newNum;//puts remaining nums in numS in from of commafied part
	return newNum;


    }//end commafyF

    /*
      Each method takes a non-negative integer input and returns the number as a String 
      with commas inserted appropriately using recursive
    */
      public static String commafyR(int num){

      String numS = Integer.toString(num);//to convert into to str
      int len = numS.length();//len of str
      int newNum = 0;//used to make remaining str into int

      if (numS.length()<=3){
      return numS;//returns remaining: Basecase
      }else{
      newNum = Integer.parseInt(numS.substring(0,len-3));//turn str w/o last 3 nums as int
      return commafyR(newNum) + "," + numS.substring(len-3);//calls fxn for num w/o last 3 places
      }

      }//end commofyR
    
      public static void main(String[] args){

      /*
      System.out.println("Testing commafyF");
      System.out.println(commafyF(1));// 1
      System.out.println(commafyF(10));// 10
      System.out.println(commafyF(1000));// 100
      System.out.println(commafyF(10000));// 1,000
      System.out.println(commafyF(100000));// 10,000
      System.out.println(commafyF(1000000));// 100,000
      System.out.println(commafyF(10000000));//1,000,000
      System.out.println(commafyF(100000000));//10,000,000
      System.out.println(commafyF(1000000000));//100,000,000
      System.out.println("");
	    
      System.out.println(commafyF("Testing commafyR"));
      System.out.println(commafyR(1));// 1
      System.out.println(commafyR(10));// 10
      System.out.println(commafyR(1000));// 100
      System.out.println(commafyR(10000));// 1,000
      System.out.println(commafyR(100000));// 10,000
      System.out.println(commafyR(1000000));// 100,000
      System.out.println(commafyR(10000000));//1,000,000
      System.out.println(commafyR(100000000));//10,000,000
      System.out.println(commafyR(1000000000));//100,000,000
      System.out.println(commafyF(""));
    */

    System.out.println("Testing FOREACH: for loop");
    for(String s: args){
	int numF = Integer.parseInt(s);
	System.out.println(commafyR(numF));
    }//end FOREACH recusive

    System.out.println("Testing FOREACH: recursion");
    for(String s: args){
	int numL = Integer.parseInt(s);
	System.out.println(commafyF(numL));
    }//end FOREACH for loop
	    
	     
}//end main






}//end Commafier
