package IntermediateOOP;

class Accounts{
	double totalAmount;
}
class SavingAcc extends Accounts{
	 double fixDepo = 2000;
	public void getTotalAmount() {
		totalAmount = totalAmount + fixDepo;
		System.out.println("Total Saving Amount is " + totalAmount);
	}
}
class CurrentAcc extends Accounts{
	double cashCredit = 4000;
	public void getTotalAmount() {
		totalAmount = totalAmount + cashCredit;
		System.out.println("Total Saving Amount is " + totalAmount);
	}
}

public class Bank {

	public static void main(String[] args) {
		SavingAcc sa = new SavingAcc();
		CurrentAcc ca = new CurrentAcc();
		sa.getTotalAmount();
		ca.getTotalAmount();
	}

}
