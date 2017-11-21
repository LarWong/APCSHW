/*
Larry Wong
APCS1 pd08
HW#07 -- On the Origins of a BigSib
2017-09-26
*/

public class BigSib{
    private String helloMsg;
    public BigSib(){
	helloMsg = "Yo YO yo ";
    }
    public BigSib(String newMsg){
	helloMsg = newMsg;
    }
    public String greet(String subject){
	helloMsg += " ";
	return (helloMsg += subject);
    }
}
