package basicDS;

import java.util.Scanner;

public class IncomeTax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter income to calculate tax.");
		double income = sc.nextDouble();
		double tax = 0;
		if(income > 0 && income <= 180000) {
			tax = income * 0;
			System.out.println("Slab A " + tax);
		} else if(income > 180001 && income <= 300000) {
			tax = income * 0.1;
			System.out.println("Slab B " + tax);
		}else if(income > 300001 && income <= 500000) {
			tax = income * 0.2;
			System.out.println("Slab C " + tax);
		}else if(income > 500001 && income <= 1000000) {
			tax = income * 0.3;
			System.out.println("Slab D " + tax);
		}
	}

}
