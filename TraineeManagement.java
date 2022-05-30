package com.MiniProject;
import java.sql.*;

import java.util.Scanner;
public class TraineeManagement {
	
	public Connection getMySQLConnectio()
	{
		Connection con=null;
		try {
		
			
			String url="jdbc:mysql://localhost:3306/miniProject1?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "3@Sailaja";
			
		con = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
		
		return con;
		 
	}
	
	
	
	public void adminsignup() throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter UserName");
		String userName = ss.next();
		
		System.out.println("Enter password");
		String password = ss.next();

		Connection con =getMySQLConnectio();
		Statement stmt= con.createStatement();
		ResultSet rs=stmt.executeQuery("select userName,password from admin");
			

		if (rs.next()) {
				
			if (rs.getString(1).equals(userName) && rs.getString(2).equals(password)) {

			    System.out.println("************* @@ REVATURE COMPANY @@ *************");
			    System.out.println("*********** Welcome Dear Admin: "+userName + " ***********");
			
			    Scanner sc=new Scanner(System.in);
			    
			    int a=0;
				
				for(a =0; a<=3;a++) {   
			    
			   System.out.println("1. Trainer Registration");
			   System.out.println("2. Trainee Registration");
			   System.out.println("3. Exit");
                System.out.println("Enter Your Option: ");
                
                
                 a =sc.nextInt();		
				
			    if (a == 2){
			    	TraineeRegistration();		
			    }
			    else if (a == 1) {
			    	TrainerRegistration();
			    }
			    else if(a == 3) {
			    	
			    }
			    else {
			    	System.out.println("INVALID INPUT");
			    }
					
				}
			}
			else{
			
				System.out.println("INVALID USERNAME OR PASSWORD");
				
			}
		
		}
		
}	
	
	
	
	 public void TraineeRegistration() {	
	    
	      try {
			Connection conn =getMySQLConnectio();
			String createAcount = "insert into trainees(email,username,password) values(?,?,?) ";
			
			PreparedStatement ps=  conn.prepareStatement(createAcount);
			
			Scanner sc=new Scanner(System.in);
			
			
			System.out.println("Enter Email");
			String email = sc.next();
			
			System.out.println("Enter Username");
			String username = sc.next();
			
			System.out.println("Enter Password");
			String password = sc.next();
			
	
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setString(3, password);
			
			ps.executeUpdate();
			 System.out.println("************ TRAINEE ACCOUNT CREATED SUCCESSFULLY  ************");
				conn.close();
			
	      }catch(Exception e) {
	    	  System.out.println(e);
	      }
	     
			
		}


	 public void TrainerRegistration() {
			// TODO Auto-generated method stub
			   try {
					Connection conn =getMySQLConnectio();
					String createAcount = "insert into trainers(username,password,course) values(?,?,?) ";
					
					PreparedStatement ps=  conn.prepareStatement(createAcount);
					
					Scanner sc=new Scanner(System.in);
					
		
					System.out.println("Enter Username");
					String username = sc.next();
					
					System.out.println("Enter Password");
					String password = sc.next();
					
					System.out.println("Enter Trainer course");
				    String course= sc.next();
					
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, course);
					
					ps.executeUpdate();
					 System.out.println("*********  TRAINER ACCOUNT CREATED SUCCESSFULLY  ************");
						conn.close();
					
			      }catch(Exception e) {
			    	  System.out.println(e);
			      }
			
		}



	public void LoginAsTrainee()  {
		// TODO Auto-generated method stub
		
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter UserName");
		String usernames = ss.next();
		
		System.out.println("Enter password");
		String password = ss.next();

		Connection connn =getMySQLConnectio();
		String sql=  "select username,password from trainees where username= ?";
		PreparedStatement stmt;
		try {
			stmt = connn.prepareStatement(sql);
			stmt.setString(1, usernames);
			ResultSet rs=stmt.executeQuery( );
       		
				 
			if (rs.next()) {
				if (rs.getString(1).equals(usernames) && rs.getString(2).equals(password)) {
					System.out.println("****************** @@ REVATURE COMPANY @@ ******************");
					System.out.println(" ********* WELCOME DEAR TRAINEE :"+" "+ usernames + " *********");
		            
				}
				else{
				
					System.out.println("!!!!!!!!!!!!! INVALID USERNAME OR PASSWORD !!!!!!!!!!!!!!" );
					
				}}
				}
					
			

				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		
	}



	
public void viewTrainees()
{
  try {
	Connection con =getMySQLConnectio();
	Statement stmt= con.createStatement();
	ResultSet rs=stmt.executeQuery("select userName from trainees");
		

	if (rs.next()) {
		
		System.out.println("* " +rs.getString(1) + " ");
		
	}
  }catch (SQLException e) {
	  e.printStackTrace();
	  
  }
}

    public void loginAsTrainer()  {
	
	    Scanner ss=new Scanner(System.in);
	    System.out.println("Enter UserName");
	    String usernames = ss.next();
	
	    System.out.println("Enter password");
	    String password = ss.next();

		Connection connn =getMySQLConnectio();
		String sql=  "select username,password,course from trainers where username= ?";
		PreparedStatement stmt;
		try {
			stmt = connn.prepareStatement(sql);
			stmt.setString(1, usernames);
			ResultSet rs=stmt.executeQuery( );
   			
			
			 
			if (rs.next()) {
				
				if (rs.getString(1).equals(usernames) && rs.getString(2).equals(password)) {
					System.out.println("********************* @@ REVATURE COMPANY @@ **********************");  
					System.out.println(" ************** WELCOME DEAR TRAINER :"+" "+ usernames + "***************");		
					System.out.println("Your Trainer for: "+rs.getString(3));
					System.out.println("======= List of Trainees ====== ");
					viewTrainees();
					
			}
			else{
			
				System.out.println("!!!!!!!!!!!!! INVALID USERNAME OR PASSWORD !!!!!!!!!!!!!!" );
				
			}}
			}
				
		

			catch (SQLException e) {
		
			e.printStackTrace();
		}
}}
