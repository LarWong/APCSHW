//Larry Wong
//APCS1 pd8
//HW#19 -- gcd 3 ways
//2017-10-18

public class Stats {
    /* method: returns the mean of two integers
       precondition:  two integers
       postcondition: mean is returned
       ````````````````````````````````````````````````````*/
    public static int mean(int a, int b) {
    	int avg = (a + b)/ 2;
    	return(avg);
    }
    /* method: returns the mean of two doubles
       precondition:  two doubles
       postcondition: mean is returned
       ````````````````````````````````````````````````````*/
    public static double mean(double a, double b) {
    	double avg = (a + b)/2;
    	return(avg);
    }
    /* method: returns the max of two integers
       precondition:  two integers
       postcondition: max is returned
       ````````````````````````````````````````````````````*/
    public static int max(int a, int b) {
    	if (a >= b){
    	    return(a);
    	}
    	else {
    	    return(b);
    	}
    }
    /* method: returns the max of two doubles
       precondition:  two doubles
       postcondition: max is returned
       ````````````````````````````````````````````````````*/
    public static double max(double a, double b) {
    	if (a >= b){
    	    return(a);
    	}
    	else {
    	    return(b);
    	}
    }
    /* method: returns the geometric mean of two integers
       precondition:  two integers
       postcondition: geometric mean is returned
       ````````````````````````````````````````````````````*/
    public static int geoMean(int a, int b) {
    	int gM = (int) Math.sqrt(a * b);
    	return(gM);
    }	    
    /* method: returns the geometric mean of two doubles
       precondition:  two doubles
       postcondition: geometric mean is returned
       ````````````````````````````````````````````````````*/
    public static double geoMean(double a, double b) {
	double gM = Math.sqrt(a * b);
	return(gM);
    }
    /* method: returns the max of three integers 
       precondition: three integers
       postcondition: max is returned
       ````````````````````````````````````````````````````*/
    public static int max(int a, int b, int c) {
	if (a > b && a > c) {
	    return a;
	}
	if (b > c) {
	    return b;
	}
	else {
	    return c;
	}
    }
    /* method: returns the max of three doubles 
       precondition: three doubles
       postcondition: max is returned
       ````````````````````````````````````````````````````*/
    public static double  max(double a, double b, double c) {
	if (a > b && a > c) {
	    return a;
	}
	if (b > c) {
	    return b;
	}
	else {
	    return c;
	}
    }
    /* method: returns the geometric mean of three integers 
       precondition: three integers
       postcondition: geometric mean is returned
       ````````````````````````````````````````````````````*/
    public static int geoMean(int a, int b, int c) {
	int gM = (int) Math.cbrt(a * b * c);
	return(gM);
    }
    /* method: returns the geometric mean of three doubles
       precondition:  three doubles
       postcondition: geometric mean is returned
       ````````````````````````````````````````````````````*/
    public static double geoMean(double a, double b, double c) {
	double gM = Math.cbrt(a * b * c);
	return(gM);
    }

    
    //finds the GCD through bashing, goes through all numbers
    //starting from 1 all the way to the smallest input
    //to see if it is the GCD
    public static int gcd (int a, int b){
	int ctr = 1;
	int gcd = 1;
	int smaller = Math.min(a,b);
	int bigger = max(a,b);
	while (ctr <= smaller){
	    if (smaller % ctr == 0 && bigger % ctr == 0){
		gcd = ctr;
	    }
	    ctr += 1;

	}
	return gcd;

    }
    /* Euclid's algorithm finds the GCD of two integers by dividing the bigger 
       input by the smaller input.
       If there is no remainder, then the smaller input is the gcd.
       If there is a remainder, then the smaller input is subtracted from the bigger input to create a difference.
       The difference is divided from the previous smaller input.
       The process is repeated until the difference divides the previous smaller input or the difference is 0.
       If the difference is 0, then the previous inputs are the same, so either one can be returned as the gcd.
 
       
    */

    //recursively finds the GCD using Euclid's algorithm
    public static int gcdER( int a, int b ) {
	if (max(a,b) % Math.min(a,b) == 0){
	    return Math.min(a,b);
	}else{
	    int c = max(a,b) - Math.min(a,b);
	    return gcdER(Math.min(a,b), c);
	}	    
    }

    //finds the GCD with Euclid's algorithm by using a while loop
    public static int gcdEW( int a, int b ){
	int c = max(a,b);
	int d = Math.min(a,b);
	while (d != 0){
	    int e = max(c-d,d);
	    int f = Math.min(c-d,d);
	    c = e;
	    d = f;
	}
	return c;
    }
}
