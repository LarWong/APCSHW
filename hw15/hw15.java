//Larry Wong
//APCS1 pd8
//HW15 -- Wayne's World
//2017-10-11

public class Coin{

    //Attributes
    private double value;
    private String upFace;
    private String name;
    private int flipCtr;
    private int headsCtr;
    private int tailsCtr;
    private double bias;


    //Default Constructor: Sets values for all attrubutes
    public Coin(){
	value = 0.0;
	upFace = "heads";
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	bias = 0.50;
	
    }

    
    //Overload Constructor 1: Uses this(); to set attributes to default values
    //Takes String input and overwrites name
    public Coin(String newName){
	this();
	name = newName;
  
    }

    
    //Overload Constructor 2: Uses this(); to set attributes to default values
    //Takes two String input and overwrites name and face
    public Coin(String newName, String newFace){
	this();
	upFace = newFace;
	name = newName;
  
    }

    
    //Overwritten toString(); returns a string with the name and the face
    public String toString(){
	return (name + " -- " + upFace);

    }

    //flip() method: Uses the "random" function and compares it to the bias
    //The bias is used as a way to limit what random values make the inequlity true
    //Bias closer to 1.0 = heads; Bias closer to 0.0 = tails.
    public String flip(){
	double randHolder = Math.random();

	if (randHolder < bias){
	    upFace = "heads"; 
	    return "heads";
	}else{
	    upFace = "tails";
	    return "tails";
	}
	

    }

    //equals method: takes a object, coin, input and compares the attribute upFace to this coin's upFace
    public boolean equals(Coin otherCoin){
        return otherCoin.upFace == upFace;
    }


    //assignvalue method: Uses conditionals to set values corresponding to var name
    public void assignValue(){
	if (name == "penny"){
	    value = 0.01;
	}else if (name == "nickle"){
	    value = 0.05;
	}else if (name == "dime"){
	    value = 0.10;
	}else if (name == "quarter"){
	    value = 0.25;
	}else if (name == "half dollar"){
	    value = 0.50;
	}else{
	    value = 1.00;
	}
    }



}
