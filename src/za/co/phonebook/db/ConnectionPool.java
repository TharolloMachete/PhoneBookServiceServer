package za.co.phonebook.db;

import javax.sql.DataSource;

public abstract class ConnectionPool {

	  protected ConnectionPoolParameters poolParams;

	  public ConnectionPool(ConnectionPoolParameters params)  {
	    poolParams = params;
	  }

	  public abstract DataSource getDataSource();
}
