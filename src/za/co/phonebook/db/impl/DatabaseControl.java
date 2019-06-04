package za.co.phonebook.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import za.co.phonebook.db.ConnectionPool;
import za.co.phonebook.db.ConnectionPoolFactory;
import za.co.phonebook.db.ConnectionPoolName;
import za.co.phonebook.model.PhoneBook;

public class DatabaseControl {

    ConnectionPool pool ;
	Connection conn;
	
	public DatabaseControl() {
		pool = ConnectionPoolFactory.getInstance(ConnectionPoolName.application);
		try {
			conn = pool.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertData(PhoneBook pb) {
		Statement statement;
		try {

			String query = "INSERT INTO PHONEBOOK VALUES ('"+ pb.getName() +"' , '"+pb.getPhoneNumber()+"')";

			statement = conn.createStatement();


	         // Execute the insert command using executeUpdate() 
	         // to make changes in database 
			statement.executeUpdate(query); 

	         // Close all the connections 
			 statement.close(); 
	         conn.close(); 
	         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public List<PhoneBook> viewData(String _name) {
		Statement statement;
		List<PhoneBook> phoneBookList = new ArrayList<PhoneBook>();
		try {
			String query = "SELECT * FROM PHONEBOOK where name = '" + _name+"'";
			statement = conn.createStatement();
	         ResultSet rs = statement.executeQuery(query);
	         
	         while(rs.next()) {
	        	 phoneBookList.add(new PhoneBook(rs.getString("name") , rs.getString("phonenumber")));
	         }
	         
	         // Close all the connections 
	         statement.close(); 
	         conn.close(); 
	         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phoneBookList; 
	}
	
	
	
}
