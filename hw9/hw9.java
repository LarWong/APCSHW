// Larry Wong
// APCS1 pd8
// HW09 -- CMYM Dollar Dollar Bills Y’all...
// 2017-10-02
// Larry Wong, Richard Wong, Jessica Wu
// Team Name: Free Stuff (Team 0)

    
public class BankAccount{
    // main method containing test cases 
    public static void main(String[] args){
	BankAccount account = new BankAccount();
	
	account.setName("Amory Tr");
	//System.out.println(account.name);
	
	account.setPass("supersecretpw");
	//System.out.println(account.pw);
	
	account.setPIN(5555);
	//System.out.println(account.pin);
	
	account.setAccNum(200300400);
	//System.out.println(account.accNum);
	
	account.setBal(299.99);
	//System.out.println(account.balance);

	account.accInfo();

	account.withdraw(300);
	account.withdraw(299);
	account.deposit(100);
    }

    //instance vars (private)
    private String name;
    private String pw;
    private int pin;
    private int accNum;
    private double balance;

    //methods to set each attribute (public so can be used by other classes)
    public void setName(String newName){
    	name = newName;
    }
    public void setPass(String newPass){
    	pw = newPass;
    }
    public void setPIN(int newPIN){
    	pin = newPIN;
    }
    public void setAccNum(int newAccNum){
	accNum = newAccNum;
    }
    public void setBal(double newBal){
	balance = newBal;
    }

    //print account info (public so can be used by other classes)
    public void accInfo(){
	String toPrint;
	toPrint = ("Name: " + name + "\n");
	toPrint += ("Password: "+ pw + "\n");
	toPrint += ("PIN: "+ pin + "\n");
        toPrint += ("Account Number: "+ accNum + "\n");
	toPrint += ("Balance: "+ balance);

	System.out.println(toPrint);
    }

    //withdraw method (public so can be used by other classes)
    public void withdraw(double amt){
	String toPrint;
	// if attempting to withdraw more than your balance
	if (amt > balance) {
	    toPrint = "You do not have enough money to perform this action";
       	}
	else {
	    balance += -amt;

	    toPrint = "";
	    toPrint += "You have successfully withdrawn $";
	    toPrint += amt;
	    toPrint += ". Your current balance is: $";
	    toPrint += balance;
	}
        System.out.println(toPrint);
    }

    //deposit method (public so can be used by other classes)
    public void deposit(double amt){
	String toPrint;
	
	balance += amt;
	
	toPrint = "";
	toPrint += "You have successfully deposited $";
	toPrint += amt;
	toPrint += ". Your current balance is: $";
	toPrint += balance;

	System.out.println(toPrint);
    }
    
    
}
