package basicDS;

import java.util.Scanner;

public class SimpleAndCompound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//priciple value
		System.out.println("Enter priciple value ");
		double p = sc.nextDouble();
		
		//rate of interest
		System.out.println("Enter rate of interest ");
		double r = sc.nextDouble();
		
		//time
		System.out.println("Enter time ");
		double t = sc.nextDouble();
		
		//Simple Interest		
		double SI = (p*r*t)/100;
		System.out.println("Simple Interest " + SI);
		
		//Compound Interest
		double CI = p*(Math.pow((1+(r/100)), t))-p;
		System.out.println("Compound Interest " + CI);
	}

}
