package basicDS;

import java.util.Scanner;

public class StudentResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] marks = new int[3][3];
		for (int i = 0; i < marks.length; i++) {
			System.out.println("Enter student " + (i+1) + " marks");
			for (int j = 0; j < marks.length; j++) {
				System.out.println("Enter subject " + (j+1) + " marks");
				marks[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Total score of stud1 "+ (marks[0][0]+marks[1][0]+marks[2][0]));
        System.out.println("Total score of stud2 "+ (marks[0][1]+marks[1][1]+marks[2][1]));
        System.out.println("Total score of stud3 "+ (marks[0][2]+marks[1][2]+marks[2][2]));
        
        System.out.println("Average score of stud1 "+ (marks[0][0]+marks[1][0]+marks[2][0])/3);
        System.out.println("Average score of stud2 "+ (marks[0][1]+marks[1][1]+marks[2][1])/3);
        System.out.println("Average score of stud3 "+ (marks[0][2]+marks[1][2]+marks[2][2])/3);
        
        System.out.println("Total score of sub1 "+ (marks[0][0]+marks[0][1]+marks[0][2]));
        System.out.println("Total score of sub2 "+ (marks[1][0]+marks[1][1]+marks[1][2]));
        System.out.println("Total score of sub3 "+ (marks[2][0]+marks[2][1]+marks[2][2]));
        
        System.out.println("Average score of sub1 "+ (marks[0][0]+marks[0][1]+marks[0][2])/3);
        System.out.println("Average score of sub2 "+ (marks[1][0]+marks[1][1]+marks[1][2])/3);
        System.out.println("Average score of sub3 "+ (marks[2][0]+marks[2][1]+marks[2][2])/3);
        
		
	}
}
