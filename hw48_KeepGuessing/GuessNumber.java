/*
Larry Wong
APCS1 pd8
HW48 -- Keep Guessing
2017-12-07
*/

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
        _guessCtr = 1;
	_lo = a;
	_hi = b;
	_target = (int)(Math.random()*(b-a)) + a;
	
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
        System.out.println("\n\nGuess a # fr " + _lo + "-" + _hi + " inclusive : ");
	int guess = Keyboard.readInt();
	
	if (guess > _hi || guess < _lo){
	    System.out.println("No valid option, Guess again.");
	    _guessCtr ++;
	    playRec();
	}
	else if (guess > _target){
	    System.out.println("Too high");
	    _hi = guess - 1;
	    _guessCtr ++;
	    playRec();
	}
	else if (guess < _target){
	    System.out.println("Too low");
	    _lo = guess + 1;
	    _guessCtr ++;
	    playRec();
	}
	else if (guess == _target){
	    System.out.println("Correct! It took " + _guessCtr + " guesses\n");
	}
	
	
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
        int guess = 0;
	while (guess != _target){
	    
	    System.out.println("\n\nGuess a # fr " + _lo + "-" + _hi + " inclusive : ");
	    guess = Keyboard.readInt();

	    if (guess > _hi || guess < _lo){
		System.out.println("No valid option, Guess again.");
	    }
	    else if (guess > _target){
		System.out.println("Too high");
		_hi = guess - 1;
	    }
	    else if (guess < _target){
		System.out.println("Too low");
		_lo = guess + 1;
	    }
	   _guessCtr ++;
	   System.out.println("Guesses: " + _guessCtr); 
	}
	    
	    System.out.println("\nCorrect! It took " + _guessCtr + " guesses\n");
      
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class
