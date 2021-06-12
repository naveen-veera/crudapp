package crudapp.utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}

	public static Connection getConnection() {
		Connection connection = null;
		Properties prop = null;
		try {
			prop = loadPropertiesFile();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		 final String driver = prop.getProperty("driver");
		 final String url = prop.getProperty("url");
		 final String username = prop.getProperty("username");
		 final String password = prop.getProperty("password");
		try {
			Class.forName(driver); // Loading the driver -- thin driver purely written in java
			// Native api driver
			// network driver
			// odbc jdbc driver
			// Establishing connection
			 connection = DriverManager.getConnection(url,username,password);
			 if(connection !=null)
				 System.out.println("Connection Established");
			//connection = DriverManager.getConnection(url);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return connection;
	}

	
}
