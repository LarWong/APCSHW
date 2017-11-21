// Larry Wong
// APCS1 pd08
// HW11 -- stAtistically sPeaking
// 2017-10-05
// Team BEC ---- Larry Wong, John Liu, Wenting Li


public class Stats{


    /*
      Int Mean method: Takes two ints and calculates the mean
      Input:  Two int parameters are passed through
      Output: The mean is returned
      ````````````````````````````````````````````````````*/
    public static int mean(int a, int b){
	return ((int)(a+b)/2);
    }


    /*
      Double Mean method: Takes two doubles and calculates the mean
      Input:  Two double parameters are passed through
      Output: The mean is returned
      ````````````````````````````````````````````````````*/
    public static double mean(double a, double b){
	return ((a+b)/2);
    }

    
    /*
      Int Max method: Compares two ints and returns that larger one
      Input:  Two int parameters are passed through
      Output: The larger # is returned
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
      Input:  Two double parameters are passed through
      Output: The larger # is returned
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
      Input:  Two int parameters are passed through
      Output: The geoMean is returned
      ````````````````````````````````````````````````````*/
    public static int geoMean(int a, int b){
	int retVal = (int) Math.sqrt( a * b );
	
	return retVal;
    }

    
    /*
      Double geoMean method: Takes two doubles and calculates the geoMean
      Input:  Two double parameters are passed through
      Output: The geoMean is returned
      ````````````````````````````````````````````````````*/
    public static double geoMean(double a, double b){
	double retVal = Math.sqrt( a * b );

	return retVal;
    }


    /*
      Int Max method: Compares three ints and returns that larger one
      Input:  Three int parameters are passed through
      Output: The larger # is returned
      ````````````````````````````````````````````````````*/
    public static int max(int a, int b, int c){
        if (a >= b && a >= c){
	    return a;
	}
	else if (b >= a && b >= c){
	    return b;
	}
	else{
	    return c;
	}
    }

    
    /*
      Double Max method: Compares three doubles and returns that larger one
      Input:  Three double parameters are passed through
      Output: The larger # is returned
      ````````````````````````````````````````````````````*/
    public static double max(double a, double b, double c){
        if (a >= b && a >= c){
	    return a;
	}
	else if (b >= a && b >= c){
	    return b;
	}
	else{
	    return c;
	}
    }


        /*
      Int geoMean method: Takes three ints and calculates the geoMean
      Input:  Three int parameters are passed through
      Output: The geoMean is returned
      ````````````````````````````````````````````````````*/
    public static int geoMean(int a, int b, int c){
	return (int)Math.pow(a * b * c, 1.0 / 3.0);
    }

    
    /*
      Double geoMean method: Takes three doubles and calculates the geoMean
      Input:  Three double parameters are passed through
      Output: The geoMean is returned
      ````````````````````````````````````````````````````*/
    public static double geoMean(double a, double b, double c){
	return Math.pow(a * b * c, 1.0 / 3.0);
    }
    
    /*
      Main method: Contains test cases to test for the methods
      Input:  None
      Output: Methods are called and values are returned
      ````````````````````````````````````````````````````*/
    public static void main(String[] args){
	System.out.println("============== Testing int mean ==============");
	
	System.out.println("Mean(4,6)");
	System.out.println(mean(4,6));
	System.out.println("");

	
	System.out.println("============== Testing double mean ==============");
	
	System.out.println("Mean(5.3,6.2)");
	System.out.println(mean(5.3,6.2));
	System.out.println("");

	
	System.out.println("============== Testing int geoMean ==============");
	
	System.out.println("geoMean(4,6)");
	System.out.println(geoMean(4,6));
	System.out.println("");


	System.out.println("============== Testing Double geoMean ==============");
	
	System.out.println("geoMean(4.5,6.25)");
	System.out.println(mean(4.5,6.25));
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
