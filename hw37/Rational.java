//Larry Wong
//APCS1 pd08
//HW 37 -- Be More Rational
//2017-11-20

public class Rational{
    private int numer;
    private int denum;

    //default constructor
    public Rational(){
	numer = 0;//default 0
	denum = 1;//default 1
    }//default constructor

    //constructor
    public Rational(int num, int den){
	if (den == 0){//denuminator cannot be 0, sets to 0/1
	    num = 0;
	    denum = 1;
	    System.out.println("Invalid option. Set to 0/1");
	}else{
	    denum = den;
	    numer = num;
	}
    }//constructor

    //overrides toString
    public String toString(){
	return numer + "/" + denum;
    }//end toString

    //converts numer into a double and divides by the denum
    public double floatValue(){
	return (double)numer / denum;
    }

    //sets numer and demun to itself multiplied by the numer & denum of input Rational
    public void multiply(Rational x){
	numer *= x.numer;//sets numer by multiplying
	denum *= x.denum;//sets denum by multiplying
    }//end multiply

    //does the samething as multiply, but with divide. Also, due to rounding, if denum is 0, denum is set to 1.
    public void divide(Rational x){
	if (x.numer != 0){
	    numer *= x.denum;
	    denum *= x.numer;
	}else{
	    System.out.println("Divide by zero.");
	}
    }//end multiply

    //gcd method
    public static int gcdR ( int a, int b){ // Does a recursive algorithm of GCD
        if (a % b == 0) {
	    return b;
        }
        return gcdR( b, a%b);
    }//end gcdR from prev hw
    

    /*add
      Takes 1 Rational object (just like multiply) and adds it to the current rational number object
      Need not reduce
    */
    public void add(Rational x){//gets common denum & multiplies numer by appropriate value
	numer *= x.denum;
	numer += (x.numer * denum);
	denum *= x.denum;
       
    }//end add

    /*
      subtract
      Works the same as add, except the operation is subtraction
    */
    public void subtract(Rational x){//gets common denum & multiplies numer by appropriate value
	numer *= x.denum;
	numer -= (x.numer * denum);
	denum *= x.denum;
    }//end subtract

    /*
      gcd
      Returns the gcd of the numerator and denominator of this Rational
    */
    public int gcd(){//uses wrapper to call gcdR
	return gcdR(numer,denum);
    }//end gcd

    /*
      reduce
      Changes this Rational to one in reduced form (should use gcd)
    */
    public void reduce(){//divides both numer & denum by gcd
	int factor = gcd();
	numer /= factor;
	denum /= factor;
    }//end reduce

    /*
      compareTo
      Takes a Rational parameter and compares it to the calling object
      Returns 0 if the two numbers are equal
      Returns a positive integer if the calling number is larger than the parameter
      Returns a negative integer if the calling number is smaller than the parameter
    */
    public int compare(Rational x){//subtracts or adds 1 to 0 based on comparison
	int equality = 0;
	if (floatValue() > x.floatValue()){
	    equality ++;
	}else if (floatValue() < x.floatValue()){
	    equality --;
	}
	return equality;

    }//end compare



    public static void main(String[] arg){
	//creating new Rationals a,b,c,d,e,f,r,s,q,t,u,v
	Rational a = new Rational(1,3);
	Rational b = new Rational(3,12);
	Rational c = new Rational(34,17);
	Rational r = new Rational(12,5);
	Rational s = new Rational(1,2);
	Rational q = new Rational(24,30);
	Rational t = new Rational(4,3);
	Rational u = new Rational(4,3);
	Rational v = new Rational(5,3);
	
	

	//test toString
	System.out.println(r);//12/5
	//test floatValue
	System.out.println(r.floatValue());//2.4
	//test subtract
	a.subtract(b);
	System.out.println(a);//3/36
	//test add
	b.add(c);
	System.out.println(b);//459/204
	//test gcd
	System.out.println(c.gcd());//17
	//test multiplty
	s.multiply(r);
	System.out.println(s);//12/10
	//test divide
	r.divide(q);
	System.out.println(r);//360/120
	//test compare
	System.out.println(t.compare(u));//0
	System.out.println(v.compare(u));//1
	System.out.println(u.compare(v));//-1



    }//end main

    

}//end class
