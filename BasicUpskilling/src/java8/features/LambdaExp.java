package java8.features;

import java.util.ArrayList;
import java.util.Scanner;

public class LambdaExp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			arrList.add(sc.nextInt());
		}
//		Even Nos
		arrList.forEach(n -> {
			if(n%2 == 0) {
				System.out.print(n + " ");
			}
		});
	}

}
