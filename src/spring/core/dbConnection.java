package spring.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
public Connection connection ;
	
	public dbConnection(String url , String userName , String password , String ClassName) {
		
		try {
			Class.forName(ClassName);
			
            this.connection = DriverManager.getConnection(url , userName , password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		
		return this.connection;
	}
}
