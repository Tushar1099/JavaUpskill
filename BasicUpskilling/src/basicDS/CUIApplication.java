package basicDS;

import java.util.Scanner;

public class CUIApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter username: ");
			String username = sc.next();
			System.out.println("Enter Password: ");
			String password = sc.next();
			
			if (username.contains("user") && password.contains("user@123")) {
				System.out.println("Welcome " + username);
			} else {
				if(i==2) {
					System.out.println("Contact Admin.");
				}else {
					System.out.println("invalid credentials");
				}
			}
		}
		

	}

}
