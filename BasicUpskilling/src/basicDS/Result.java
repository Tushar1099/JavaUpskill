package basicDS;

import java.util.Scanner;

public class Result {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st subject marks");
		double mark1 = sc.nextDouble();
		System.out.println("Enter 2nd subject marks");
		double mark2 = sc.nextDouble();
		System.out.println("Enter 3rd subject marks");
		double mark3 = sc.nextDouble();
		
		if(mark1>60 && mark2>60 && mark3 >60) {
			System.out.println("Passed");
		}
		else if((mark1>60 && mark2>60 && mark3<60) || (mark1>60 && mark2<60 && mark3>60) || (mark1<60 && mark2>60 && mark3>60)) {
			System.out.println("Promoted");
		}
		else {
			System.out.println("Failed");
		}
	}

}
