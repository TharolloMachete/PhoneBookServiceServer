package za.co.phonebook.db;

import java.util.HashMap;

import za.co.phonebook.db.impl.AppConnectionPoolParameters;

public class ConnectionPoolFactory {

	  static HashMap<ConnectionPoolName, ConnectionPool> pools = new HashMap<ConnectionPoolName, ConnectionPool>();
	  

	  public static ConnectionPool getInstance(ConnectionPoolName poolName) {
		  ConnectionPool pool = null;
		  ConnectionPoolParameters poolParams = null;
	    switch(poolName) {
	      case application:
	        if(pools.get(ConnectionPoolName.application) == null) {
	          poolParams = new AppConnectionPoolParameters();
	        }
	        break;
	    }
	    if(poolParams != null) {
	      if(poolParams.getIsJNDIConnection()) {
	        pool = new JNDIConnectionPool(poolParams);
	      }
	      else {
	        pool = new DBCPConnectionPool(poolParams);
	      }
	      pools.put(poolName, pool);
	    }
	    return pools.get(poolName);
	  }
}
