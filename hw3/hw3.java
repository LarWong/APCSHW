/*
Larry Wong
APCS1 pd08
HW#03 -- Howdy, <VeryInterestingPerson>!
2017-09-16
*/

public class Greet{
    public static void main (String[] args){
	greet("Bob McCabbage");
	greet("Ol' MacDonald");
	greet("Existing Lifeform");
    }
    public static void greet(String x){
	System.out.println("Whaddup, " + x + ". I've come in peace");
    }
}
