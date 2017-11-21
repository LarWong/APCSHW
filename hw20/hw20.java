//Larry Wong
//APCS pd8
//HW20 -- For the Lulz Love of Strings
//2017-10-19

public class Foresrever{

    /*
      fenceF  method: Creates a fence with the number of posts given
      precondition: an int is inputed
      postcondition: a string is returned with the inputed number of posts
      ````````````````````````````````````````````````````*/
    public static String fenceF(int posts){
	
	String fence = ""; //To build the fence
	
	for (int x = 0; x < posts; x++){
	    if (x == 0){
		fence += "|";
	    } else {
		fence += "--|";
	    }//end if
	    
	}//end for loop
	return fence;

    }//end fenceF



    /*
      reverseF method: Takes a string and reverses the order of chars. Uses for loop
      precondition:  A string is given
      postcondition: A new string with the chars reversed is returned
      ````````````````````````````````````````````````````*/
    public static String reverseF(String s){

	String newString = ""; //To hold the revered String

	for (int position = s.length()-1; position >= 0; position --){
	    newString += s.substring(position, position + 1);// adds the char at place "position" to newString
	}//end for loop
	return newString;

    }//end reverseF


    /*
      reverseR method: Takes a string and reverses the order of chars. Uses recursion
      precondition:  A string is given
      postcondition: A new string with the chars reversed is returned
      ````````````````````````````````````````````````````*/
    public static String reverseR(String s){

	int lengthS = s.length() - 1;// to determine the position of the last char in the String s
	
	if (s.length() <= 1){
	    return s;
	} else {
	    
	    return s.substring(lengthS, lengthS + 1) + reverseR( s.substring(0,lengthS) );
	    //returns last char and calls method again w/o the last char
	    //adds second to last char to previous char
	    //and repeats
	}//end if
		

    }//end reverseR
    
    /*
      main method: Tests every method above
      precondition: none
      postcondition: a corresponding message is printed
      ````````````````````````````````````````````````````*/
    public static void main(String[] args){

	//Let's build a stair case
	System.out.println("fenceF: Testing FOR loop: " + fenceF(0)); //""
        System.out.println("fenceF: Testing FOR loop: " + fenceF(1)); //"|"
	System.out.println("fenceF: Testing FOR loop: " + fenceF(2)); //"|--|"
	System.out.println("fenceF: Testing FOR loop: " + fenceF(3)); //"|--|--|"
	System.out.println("fenceF: Testing FOR loop: " + fenceF(4)); //"|--|--|--|"
	System.out.println("fenceF: Testing FOR loop: " + fenceF(5)); //"|--|--|--|--|"
	System.out.println("fenceF: Testing FOR loop: " + fenceF(6)); //"|--|--|--|--|--|"
	System.out.println("");

	//Look into a mirror
	System.out.println("reverseF: Testing FOR loop: " + reverseF("Tacocat")); // "tacocaT"
	System.out.println("reverseF: Testing FOR loop: " + reverseF("Yensid")); // "disneY"
	System.out.println("reverseF: Testing FOR loop: " + reverseF("Nacirema")); // "americaN"
	System.out.println("reverseF: Testing FOR loop: " + reverseF("Live")); // "eviL"
	System.out.println("reverseF: Testing FOR loop: " + reverseF("pupils")); // "slipups"
	System.out.println("reverseF: Testing FOR loop: " + reverseF("raw")); // "war"
	System.out.println("");

	//Look into a mirror from another mirror
	System.out.println("reverseR: Testing RECURSION loop: " + reverseR("tacocat")); // "tacocat"
	System.out.println("reverseR: Testing RECURSION loop: " + reverseR("disney")); // "tacocat"
	System.out.println("reverseR: Testing RECURSION loop: " + reverseR("american")); // "tacocat"
	System.out.println("reverseR: Testing RECURSION loop: " + reverseR("evil")); // "tacocat"
	System.out.println("reverseR: Testing RECURSION loop: " + reverseR("slipup")); // "tacocat"
	System.out.println("reverseR: Testing RECURSION loop: " + reverseR("war")); // "tacocat"

	
			   


	

    }//end main





}//end class Foresrever
