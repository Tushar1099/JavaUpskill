package basicDS;

public class ArmStrongHundredToThousand {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ArmStrong Number from 100-999");
		for (int i = 100; i < 1000; i++) {

			try {
				int num = i;
				int temp = num;
				int cube = 0;
				int armNum = 0;

				while (num != 0) {
					int temp1 = num % 10;
					int digitPower = 1;
					for (int j = 0; j < 3; j++) {
						digitPower *= temp1;
					}
					armNum = armNum + digitPower;
					num = num / 10;
				}

				if (temp == armNum) {
					System.out.println("ArmStrong Number " + temp);
				} 
			} catch (Exception e) {
				System.out.println("Error ");
			}
		}
	}

}
