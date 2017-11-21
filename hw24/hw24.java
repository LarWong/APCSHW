/*
  Larry Wong
  APCS1 pd8
  HW#24 --  Imetay Otay Ineshay
  2017-10-29
  Team LeMon: Marryann Foley, Larry Wong, Jessica Wu
*/

/*
  To-Do List:
  Seperating words
  White space
  Digraphs: Combine with other functions
  Dashed words - count as separate words, create 2 substrs 
*/
import java.util.Scanner;

public class Pig{

    
    private static final String VOWELS = "aeiouAEIOU";
    private static final String PUNCTUATIONS = ".,!?:;\"''_-()[]{}";
    private static final String CAPS = "QWERTYUIOPASDFGHJKLZXCVBNM";
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

  	return hasA(VOWELS, letter); //uses hasA with variable VOWELS and the letter you want to check
    }//end isAVowel


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
  	return countVowels(w) > 0;//uses previous countVowels, would return 0 if no vowels
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


    //pre: w != null
    //post: firstVowel("") --> ""
    //      firstVowel("zzz") --> ""
    //      firstVowel("meatball") --> "e"
    public static String firstVowel(String w)
    {
	return allVowels(w).substring(0,1);// returns index 0 of str from allVowels
    }


    //pre: w != null
    //post: firstVowel("") --> ""
    //      firstVowel("zzz") --> ""
    //      firstVowel("meatball") --> "e"
    public static boolean beginsWithVowel(String w)
    {
	return isAVowel(w.substring(0,1));// checks index 0 of str w/ isAVowel()
    }


    //pre: w != null
    //post: firstVowel("") --> ""
    //      firstVowel("zzz") --> ""
    //      firstVowel("meatball") --> "e"
    //If the word is capitalized, then output has first letter capitalized
    //Works with punctuations, but not digraphs
    public static String engToPig(String w)
    {
	w = digraphs(w);
	
	if (hasA(CAPS, w.substring(0,1)) &&
	    beginsWithVowel(w)){
	    w = punctuation(w.toLowerCase());
	    return w.substring(0,1).toUpperCase() + w.substring(2);
	    
	}else if (hasA(CAPS, w.substring(0,1))){
	    w = punctuation(w.toLowerCase());
	    return w.substring(1,2).toUpperCase() + w.substring(2);

	}else if (beginsWithVowel(w)){
	    return punctuation(w);
	}
	return punctuation(w);

    }

    //Checks to see if the word has digraphs and puts the first 2 letters to the back
    public static String digraphs(String w){
	if (w.substring(0,2) == "ch" ||
	    w.substring(0,2) == "kn" ||
	    w.substring(0,2) == "gn" ||
	    w.substring(0,2) == "ph" ||
	    w.substring(0,2) == "sh" ||
	    w.substring(0,2) == "wr" ||
	    w.substring(0,2) == "wh" ||
	    w.substring(0,2) == "th"){//checks for Digraphs
	    return w.substring(2) + w.substring(0,2) + "ay";
	}
	return w;

    }//end digraphs()

    //Checks the punctuation of the word. If the word contains punctuation, then
    //the word is converted to piglatin and the punctuation is moved to the back after
    public static String punctuation(String w){
	String str = "";
	if (hasA(PUNCTUATIONS, w.substring(w.length()-1)) &&
	    beginsWithVowel(w)){
	    str = w.substring(0,w.length()-1) + "way" + w.substring(w.length()-1);
	    return str;
	}else if (hasA(PUNCTUATIONS, w.substring(w.length()-1))){
	    str = w.substring(1,w.length()-1) + w.substring(0,1) + "ay" + w.substring(w.length()-1);
	    return str;

	}else if (beginsWithVowel(w)){
	    return w + "way";
	} 
	return w + "ay";
    }//end punctuation()
    
    public static void main( String[] args ) 
    {
	/*
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


	//======Testing firstvowel()========
	System.out.println("/======Testing firstVowel()========");
	System.out.println("cat: " + firstVowel("cat"));// a
	System.out.println("kosoosa: " + firstVowel("kosoosa"));// o
	System.out.println("bird: " + firstVowel("bird"));// i
	System.out.println("forest: " + firstVowel("forest"));// o

	//======Testing beginsWithVowel()========
	System.out.println("/======Testing beginsWithVowels()========");
	System.out.println("eeatball: " + beginsWithVowel("eeatball"));// true
	System.out.println("cat: " + beginsWithVowel("cat"));// false
	System.out.println("cool: " + beginsWithVowel("cool"));// false
	System.out.println("apple: " + beginsWithVowel("apple"));// true

	//======Testing engToPig()========
	System.out.println("/======Testing enToPig()========");
	System.out.println("java: " + engToPig("java"));// avajay
	System.out.println("strong: " + engToPig("strong"));// ongstray
	System.out.println("apple: " + engToPig("apple"));// appleway
	System.out.println("animal: " + engToPig("java"));// animalway
	System.out.println("who: " + engToPig("who"));// owhay
	System.out.println("that: " + engToPig("that"));//atthay
    	

	System.out.println("Java: " + engToPig("Java!"));// Avajay
	System.out.println("Eva: " + engToPig("Eva!"));// Avajay
	System.out.println("Eva: " + engToPig("eva"));// Avajay
	System.out.println("Eva: " + engToPig("java"));// Avajay
	
	System.out.println("java!: " + punctuation("java!"));// avajay!
	System.out.println("eava!: " + punctuation("eava!"));// eavaway!
	*/

	Scanner sc = new Scanner (System.in);
	while (sc.hasNext()) {
	    System.out.println(engToPig(sc.next()));

	}
	

    }
}
