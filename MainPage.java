package com.MiniProject;
import java.sql.SQLException;
import java.util.Scanner;

public class MainPage {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new  Scanner(System.in);
		
		String s="Yes";
		while(s.equals("Yes") ){
			
			System.out.println("********** @ REVATURE TRAINEE MANAGEMENT @ **********");
			System.out.println("Enter 1 to login As Admin");
			System.out.println("Enter 2 to login AS Trainer");
			System.out.println("Enter 3 to login AS Trainee");
			
			
		
			System.out.println("Enter Your Option");

			TraineeManagement Tm=new TraineeManagement();
			int inp=sc.nextInt();
			switch(inp) {
			
			case 1:
				Tm.adminsignup();
			    break;
			case 3:
				Tm.LoginAsTrainee();
				break;
			case 2:
				Tm.loginAsTrainer();
				break;
			default:
				System.out.println("Wrong option");
			}
			
			System.out.println("Did you want to continue press: Yes/No");
			s = sc.next();
		}
		
		
		sc.close();
	}

}
