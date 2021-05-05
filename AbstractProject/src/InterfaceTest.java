import java.util.Scanner;

public class InterfaceTest {
  public static void main(String[] args) {
	/*payment p=new ChequePayment();
    p.pay();
    CashPayment q=new CashPayment();
    q.pay();
    payment r=new NEFTPayment();
    r.pay();*/
	  payment p=new ChequePayment();
	  p.pay();
    int choice=0;
    do {
    	System.out.println("payment choice");
    	System.out.println("1.Pay via Cheque");
    	System.out.println("2.Pay via Cash");
    	System.out.println("3.Pay via NEFT");
    	System.out.println("4.Pay via Gpay");
    	System.out.println("5.exit");
    	System.out.println("enter choice");
    	Scanner scan=new Scanner(System.in);
        choice = scan.nextInt();
       // payment pmnt=null;
        switch(choice) {
        case 1:p =new ChequePayment();break;
        case 2:p =new CashPayment();break;
        case 3:p =new NEFTPayment();break;
        case 4:p =new GPayment();break;
        case 5: break;
        default:System.out.println("Invalid Choice");
        }
        if(p!=null) p.pay();
    }while(choice!=5);
    if(p instanceof GPayment)
    {
    	GPayment gpay=(GPayment) p;
    	gpay.findGooglePayee();
    	gpay.pay();
    }
    else 
    	System.out.println("It's not pointing to GPay");
  }
}
 interface payment{
	 void pay();
 }
 
 class ChequePayment implements payment{
	 public void pay() {
		 System.out.println("writing the details of the person");
         System.out.println("writing the amount on the cheque");
	 }
 }
 class CashPayment implements payment{
	 public void pay(){
		 System.out.println("writing the details of the person");
         System.out.println("checking the amount on the denominations");

	 }
 }
 class NEFTPayment implements payment{
	 public void pay() {
		 System.out.println("entering the details of the person");
         System.out.println("entering the amount ");

	 }
 }
 class GPayment implements payment{
	 public void pay() {
		 System.out.println("paying through Google Pay");
	 }

	public void findGooglePayee() {
		// TODO Auto-generated method stub
		System.out.println("searching for the payeee.......");
	}
 }