/*
  Larry Wong
  APCS1 pd8
  HW17 -- Do I repeat myself?
  2017-10-16
*/

public class Repeater{

    /*
      While method: Adds a post and dashes while numPost is greater than 1.
      If numPosts is one, it stops the loop.
      precond: int input greater than or equal to 1
      postcond: returns length of fence corresponding to numPosts
    */
    public static String fenceW(int numPosts){
	String fence = "";
	while (numPosts > 0){
	    fence += "|";
	    if (numPosts > 1){
		fence += "--";
	    }
	    numPosts -= 1;
	}
	return fence;

    }

    /*
      Recursive method: calls methods with arg one less than previous call until numPost is 1.
      precond: int input greater than or equal to 1
      postcond: return length of fence corresponding to numPosts
    */
    public static String fenceR(int numPosts){
	String theBarrier = "";
	if (numPosts == 1){
	    theBarrier =  "|";
	    return theBarrier;
	}else{
	    theBarrier += fenceR(numPosts - 1);
	    theBarrier += "--|";
	    
	}
	return theBarrier;
	    

    }



   

}
