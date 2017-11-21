//Larry Wong
//APCS1 pd8
//HW22 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
//2017-10-24

/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
    //A: It allows a static method to check if a letter is a vowel without
    //    creating a similar string in every method
    private static final String VOWELS = "aeiou";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    
    public static boolean hasA( String w, String letter ) 
    {
	return w.indexOf(letter) >= 0;
	// str.indexOf() returns a value >= 0 if the letter is in str
    }//end hasA()

    
    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	return VOWELS.indexOf(letter) >= 0;
	// VOWELS.indexOf would return >=0 is letter is in VOWELS
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	int numVowels = 0;//ctr for # of vowels
	for (int pos = 0; pos < w.length(); pos++){//creates a substr for each char
	  
	    if (isAVowel(w.substring(pos,pos+1))){//checks if substr is a vowel
		numVowels ++;//increments ctr for each vowel
	    }//end if statement
	  
	}//end for loop
	return numVowels;
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	return countVowels(w) != 0;//uses previous countVowels, would return 0 if no vowels
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	String vowelsOnly = "";//holds possible vowels
	for (int pos = 0; pos < w.length(); pos++){//loops through each char

	    String it = w.substring(pos,pos+1);//holds the substr
	
	if (isAVowel(it)){//checks substrif vowel
	    vowelsOnly += it;//increments vowelsOnly by 1
	}//end if statement


    }//end for loop

    return vowelsOnly;
}

 
public static void main( String[] args ) 
{
    //======Testing hasA()========
    System.out.println("/======Testing hasA()========");
    System.out.println("cat, a: " + hasA("cat","a"));// true
    System.out.println("ct, y: "+ hasA("ct","y"));// false
    System.out.println("sdsdsct, s: "+ hasA("sdsdsct","s"));// true
    System.out.println("dogofof, o: "+ hasA("dogofof","o"));// true
    System.out.println("metrocard, w: "+ hasA("metrocard","w"));// false

    //======Testing hasA()========
    System.out.println("/======Testing isAVowel()========");
    System.out.println("a: " + isAVowel("a"));// true
    System.out.println("e: " + isAVowel("e"));// true
    System.out.println("i: " + isAVowel("i"));// true
    System.out.println("o: " + isAVowel("o"));// true
    System.out.println("u: " + isAVowel("u"));// true
    System.out.println("q: " + isAVowel("q"));// false
    System.out.println("v: " + isAVowel("v"));// false
    System.out.println("k: " + isAVowel("k"));// false

    //======Testing hasA()========
    System.out.println("/======Testing countVowels()()========");
    System.out.println("cat: " + countVowels("cat"));// 1
    System.out.println("antidisestablishmentarianis: " + countVowels("antidisestablishmentarianism"));// 11
    System.out.println("noodles: " + countVowels("noodles"));// 3
    System.out.println("fire: " + countVowels("fire"));// 2
    System.out.println("computer: " + countVowels("computer"));// 3

    //======Testing hasA()========
    System.out.println("/======Testing hasAVowel()========");
    System.out.println("cat: " + hasAVowel("cat"));// true
    System.out.println("floccinaucinihilipilification: " + hasAVowel("floccinaucinihilipilification"));// true
    System.out.println("pcv: " + hasAVowel("pcv"));// false
    System.out.println("mvmt: " + hasAVowel("mvmt"));// false
    System.out.println("csd: " + hasAVowel("csd"));// false

    //======Testing hasA()========
    System.out.println("/======Testing allVowels()========");
    System.out.println("cat: " + allVowels("cat"));// a
    System.out.println("incomprehensibilities: " + allVowels("incomprehensibilities"));// ioeeiiiie
    System.out.println("computer: " + allVowels("computer"));// oue
    System.out.println("school: " + allVowels("school"));// oo
    System.out.println("unimaginative: " + allVowels("unimaginative"));// uiaiaie

      
}//end main()

}//end class Pig
