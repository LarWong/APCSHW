// Larry Wong
// APCS1 pd08
// HW11 -- stAtistically sPeaking
// 2017-10-05
// Team BEC ---- Larry Wong, John Liu, Wenting Li


public class Stats{


    /*
      Int Mean method: Takes two ints and calculates the mean
      precondition:  Two int parameters are passed through
      postcondition: The mean is returned
      ````````````````````````````````````````````````````*/
    public static int mean(int a, int b){
	return ((int)(a+b)/2);
    }


    /*
      Double Mean method: Takes two doubles and calculates the mean
      precondition:  Two double parameters are passed through
      postcondition: The mean is returned
      ````````````````````````````````````````````````````*/
    public static double mean(double a, double b){
	return ((a+b)/2);
    }

    
    /*
      Int Max method: Compares two ints and returns that larger one
      precondition:  Two int parameters are passed through
      postcondition: The larger # is returned
      ````````````````````````````````````````````````````*/
    public static int max(int a, int b){
        if (a > b){
	    return a;
	}
	else{
	    return b;
	}
    }

    
    /*
      Double Max method: Compares two doubles and returns that larger one
      precondition:  Two double parameters are passed through
      postcondition: The larger # is returned
      ````````````````````````````````````````````````````*/
    public static double max(double a, double b){
        if (a > b){
	    return a;
	}
	else{
	    return b;
	}
    }
 
    
    /*
      Int geoMean method: Takes two ints and calculates the geoMean
      precondition:  Two int parameters are passed through
      postcondition: The geoMean is returned
      ````````````````````````````````````````````````````*/
    public static int geoMean(int a, int b){
	int retVal = (int) Math.sqrt( a * b );
	
	return retVal;
    }

    
    /*
      Double geoMean method: Takes two doubles and calculates the geoMean
      precondition:  Two double parameters are passed through
      postcondition: The geoMean is returned
      ````````````````````````````````````````````````````*/
    public static double geoMean(double a, double b){
	double retVal = Math.sqrt( a * b );

	return retVal;
    }

    
    /*
      Main method: Contains test cases to test for the methods
      precondition:  None
      postcondition: Methods are called and values are returned
      ````````````````````````````````````````````````````*/
    public static void main(String[] args){
	System.out.println("============== Testing int mean ==============");
	
	System.out.println("Mean(4,6)");
	System.out.println(mean(4,6));
	System.out.println("");
	
	System.out.println("Mean(10,4)");
	System.out.println(mean(10,4));
	System.out.println("");

	
	System.out.println("============== Testing double mean ==============");
	
	System.out.println("Mean(5.3,6.2)");
	System.out.println(mean(5.3,6.2));
	System.out.println("");
	
	System.out.println("Mean(17.32,10.23)");
	System.out.println(mean(17.32,10.23));
	System.out.println("");
	

	
	System.out.println("============== Testing int geoMean ==============");
	
	System.out.println("geoMean(4,6)");
	System.out.println(geoMean(4,6));
	System.out.println("");
	
	System.out.println("geoMean(10,4)");
	System.out.println(geoMean(10,4));
	System.out.println("");


	System.out.println("============== Testing Double geoMean ==============");
	
	System.out.println("geoMean(4.5,6.25)");
	System.out.println(mean(4.5,6.25));
	System.out.println("");
	
	System.out.println("Mean(10.4,4.7)");
	System.out.println(mean(10.4,4.7));
	System.out.println("");

	
	System.out.println("============== Testing max ==============");
	
	System.out.println("IntMax(4,6)");
	System.out.println(max(4,6));
	System.out.println("");
	
	System.out.println("DoubleMean(4.56,4.23)");
	System.out.println(max(4.56,4.23));
	System.out.println("");

	


    }
}
