/******************************
 * class Rational
 * stores a rational number (p/q s.t. p,q ints && q!=0)
 * facilitates
 * multiplication
 * division
 * addition
 * subtraction
 * reduction
 * comparison
 ******************************/

// Larry Wong
// APCS1 p8
// HW44 --  Rational Equality
// 2017-11-30T

public class Rational implements Comparable
{
    //   Instance variables for the numerator and denominator
    private int _numerator;
    private int _denominator;


    // Default constructor (no parameters)
    // creates a new Rational with the value of 0/1
    public Rational()
    {
	_numerator = 0;
	_denominator = 1;
    }


    // Constructor
    // takes 2 parameters, one for the numerator, one for the denominator
    // if an invalid denominator is attempted, should print a message and set the number to 0/1
    public Rational( int n, int d )
    {
	this();
	if ( d != 0 ) {
	    _numerator = n;
	    _denominator = d;
	}
	else {
	    System.out.println( "Invalid number. " +
				"Denominator set to 1." );
	}
    }


    // toString
    // returns a string representation of the rational number (formatting of your choice)
    public String toString()
    {
	return _numerator + " / " + _denominator;
    }


    // floatValue
    // returns floating point approximation of the number
    // uses the most precise floating point primitive
    public double floatValue()
    {
	return (double)_numerator / _denominator;
    }


    // multiply
    // takes a Rational parameter and multiplies it by this Rational
    // does not return a value
    // modifies this object, leaves parameter alone
    // need not reduce
    public void multiply( Rational r )
    {
	_numerator   = this._numerator   * r._numerator;
	_denominator = this._denominator * r._denominator;
    }


    // divide
    // works the same as multiply, except the operation is division
    public void divide( Rational r )
    {
	if ( r._numerator != 0 ) {
	    _numerator   = _numerator   * r._denominator;
	    _denominator = _denominator * r._numerator;
	}
	else {
	    System.out.println( "Div by 0 error. Values unchanged." );
	}
    }


    //increases this Rational by value of input Rational
    public void add( Rational r )
    {
	_numerator = _numerator * r._denominator + r._numerator * _denominator;
	_denominator = _denominator * r._denominator;
    }


    //decreases this Rational by value of input Rational
    public void subtract( Rational r )
    {
	_numerator = _numerator * r._denominator - r._numerator * _denominator;
	_denominator = _denominator * r._denominator;
    }


    //reduces this Rational to simplest fraction
    public void reduce()
    {
	int g = gcd();
	_numerator = _numerator / g;
	_denominator = _denominator / g;
    }


    //calculates GCD/GCF of numerator and denominator
    public int gcd()
    {
	return gcd( _numerator, _denominator );
    }


    //calculates GCD/GCF of two int inputs
    public static int gcd( int n, int d )
    {
	int a, b, x;

	a = n;
	b = d;

	while( a % b != 0 ) {
	    x = a;
	    a = b;
	    b = x % b;
	}

	return b;
    }


    // Takes a Rational parameter and compares it to the calling object
    // Returns 0 if the two Rationals are equal
    // Returns positive integer if calling Rational is larger than parameter
    // Returns negative integer if calling Rational is smaller than parameter
    public int compareTo( Object other )
    {
	//checks of other is Rational, throws an exception otherwise
	if (! (other instanceof Rational) ) {
	    throw new ClassCastException("Not right Obj Type");
	}

	//typecasts other into Rational to allow Rational manipulability
	Rational holder = (Rational) other;
	int thisNumerator, otherNumerator;

	thisNumerator = _numerator * holder._denominator;
	otherNumerator = _denominator * holder._numerator;

	return thisNumerator - otherNumerator;
      
    }//ends compareTo()

    public boolean equals( Object other ){
	//passes other to compareTo
	//compareTo does all the heavy work (even checking if it is Rational)
	return compareTo(other) == 0;

    }//end equals()


    //main method for testing
    public static void main( String[] args )
    {
	
	// all instance vars
	  Rational r = new Rational( 1, 2 );
	  Rational s = new Rational();
	  Rational t = new Rational( 8, 5 );

	  Rational u = new Rational( 1, 2 );
	  Rational v = new Rational( 2, 3 );
	  Rational w = new Rational( 8, 12 );

	  String dummy = "This Won't Work";
	  String fool = "This Won't change the output";

	  System.out.println("Printing all Objects:");
	  System.out.println("r: " + r );
	  System.out.println("s: " +  s );
	  System.out.println("t: " +  t );

	  System.out.println("u: " + u );
	  System.out.println("v: " +  v );
	  System.out.println("w: " +  w );

	  System.out.println("\ndummy: " +  dummy );
	  System.out.println("\nfool: " +  fool );

	  //Testing compareTo();
	  System.out.println("\n=========-Testing compareTo():-=========");
	  System.out.println("\nr.compareTo(u): Expect 0");
	  System.out.println(r.compareTo(u));//0
	  System.out.println("\n(s.compareTo(v): Expect neg #");
	  System.out.println(s.compareTo(v));//neg #
	  System.out.println("\nt.compareTo(w): Expect pos #");
	  System.out.println(t.compareTo(w));//pos #

	  try{
	      System.out.println("\ncompareTo w/ diff obj type:");
	      System.out.println(w.compareTo(dummy));//error
	  }
	  catch(Exception e){
	      System.out.println("\nExpect error:");
	      System.out.println(e + "\n");
	  }

	  //Testing equals();
	  System.out.println("=========-Testing equals():-=========");
	  System.out.println("\nr.equals(u): Expect true");
	  System.out.println(r.equals(u));//true
	  System.out.println("\ns.equals(w): Expect false");
	  System.out.println(s.equals(w));//false
	  System.out.println("\nt.equals(v): Expect false");
	  System.out.println(t.equals(v));//false

	  try{
	      System.out.println("\nEquals w/ diff obj type:");
	      System.out.println(w.equals(fool));//error
	  }
	  catch(Exception e){
	      System.out.println("\nExpect error:");
	      System.out.println(e);
	  }

			     

	  
	
    }

}//end class
