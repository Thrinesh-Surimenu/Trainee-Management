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
	
	
	
	
	 public void login() {	
	    
	      try {
			Connection conn =getMySQLConnectio();
			String createAcount = "insert into trainees(Id,phonenumber,username,password) values(?,?,?,?) ";
			
			PreparedStatement ps=  conn.prepareStatement(createAcount);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Id");
			int Id = sc.nextInt();
			
			System.out.println("Enter your Phone Number");
			int phonenumber = sc.nextInt();
			
			System.out.println("Enter your Username");
			String username = sc.next();
			
			System.out.println("Enter your Password ony In Integer form");
			int password = sc.nextInt();
			
			ps.setInt(1, Id);
			ps.setInt(2, phonenumber);
			ps.setString(3, username);
			ps.setInt(4, password);
			
			ps.executeUpdate();
			 System.out.println("Account created");
				conn.close();
			
	      }catch(Exception e) {
	    	  System.out.println(e);
	      }
	     
			
		}


	public void adminsignup() throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter UserName");
		String userName = ss.next();
		
		System.out.println("Enter password");
		int password = ss.nextInt();

			Connection con =getMySQLConnectio();
			Statement stmt= con.createStatement();
			ResultSet rs=stmt.executeQuery("select userName,password from admin");
			

			 
			if (rs.next()) {
				
			if (rs.getString(1).equals(userName) && rs.getInt(2)== password) {

					
						System.out.println("Welcome Dear:"+" "+ userName );
						System.out.println("Did you want to signup trainee registration  Yes or No");
						Scanner sc=new Scanner(System.in);
					    String a =sc.next();
					    if (a.equals("Yes")){
					    		login();		
					    }
						
						
					  
			}
			else{
			
				System.out.println("Wrong Username And Password");
				
			}}
		
		
		
			}	


	public void loginasuser()  {
		// TODO Auto-generated method stub
		
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter UserName");
		String usernames = ss.next();
		
		System.out.println("Enter password");
		int password = ss.nextInt();

			Connection connn =getMySQLConnectio();
			String sql=  "select username,password from trainees where username= ?";
			PreparedStatement stmt;
			try {
				stmt = connn.prepareStatement(sql);
				stmt.setString(1, usernames);
				ResultSet rs=stmt.executeQuery( );
       			
				
				 
				if (rs.next()) {
					
					if (rs.getString(1).equals(usernames) && rs.getInt(2) == password) {

						System.out.println("WELCOME DEAR TRAINE :"+" "+ usernames);
							
						  
				}
				else{
				
					System.out.println("Wrong Username And Password");
					
				}}
				}
					
			

				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		
	}

}
