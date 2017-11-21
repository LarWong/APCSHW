//Larry Wong
//APCS1 pd08
//HW 36 -- Be Rationa;
//2017-11-17

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
	numer /= x.numer;//sets numer by dividing
	denum /= x.denum;//sets denum by dividing
	if (denum == 0){//to prevent denum to be 0 due to rounding
	    denum = 1;//sets denum 1
	    System.out.println("Denominator is too small, set to 1");
	}
    }//end multiply

    public static void main(String[] arg){
	//creating new Rationals r and s
	Rational r = new Rational(12,5);
	Rational s = new Rational(1,2);

	//test toString
	System.out.println(r);
	//test floatValue
	System.out.println(r.floatValue());
	//test multiplty
	s.multiply(r);
	System.out.println(s);
	//test divide
	r.divide(s);
	System.out.println(r);

    }//end main

    

}//end class
