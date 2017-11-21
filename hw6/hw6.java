/*
Larry Wong
APCS1 pd08
HW#06 -- On BigSib Individuality and the Elimination of Radio Fuzz
2017-09-25
*/

public class BigSib{
    private String helloMsg;
    public void setHelloMsg(String newMsg){
	helloMsg = newMsg;
    }
    public String greet(String subject){
	return (helloMsg += subject);
    }
}
