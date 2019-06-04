package za.co.phonebook.db.impl;

import za.co.phonebook.db.ConnectionPoolParameters;

public class AppConnectionPoolParameters extends ConnectionPoolParameters{

	
	public AppConnectionPoolParameters(){

	    setConnectionPoolName("application");
	    setUsername("PHONEBOOKAPPLICATION");
	    setPassword("su");
	    setDriver("org.apache.derby.jdbc.ClientDriver");
	    setPort(1527);
	}
	
	@Override
	public String getJDBCUrl() {
		// TODO Auto-generated method stub
		return "jdbc:derby://localhost:1527/PhoneBookDB;create=true";
	}

}
