package basicDS;

import java.util.Scanner;

public class ArmStrongNumber {

	public static int numCount(int num) {
		int count = 0;
		while (num != 0) {
			int temp = num % 10;
			count++;
			num = num / 10;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		try {
			int num = sc.nextInt();
			int temp = num;
			int cube = 0;
			int armNum = 0;
			int count = numCount(num);

			while (num != 0) {
				int temp1 = num % 10;
				int digitPower = 1;
				for (int i = 0; i < count; i++) {
					digitPower *= temp1;
				}
				armNum = armNum + digitPower;
				num = num / 10;
			}

			if (temp == armNum) {
				System.out.println("ArmStrong Number");
			} else {
				System.out.println("Not Arm");
			}
		} catch (Exception e) {
			System.out.println("Error ");
		} finally {
			sc.close();
		}

	}

}
