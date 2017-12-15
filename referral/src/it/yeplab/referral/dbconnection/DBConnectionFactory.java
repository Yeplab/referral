package it.yeplab.referral.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {
	
	private static Connection connection = null;
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String HOST = "wc1mysql1.mondoserver.com";
	public static final String PORT = "3306";
	public static final String DB = "host9320_db1";
	public static final String USER = "host9320_usr1";
	public static final String PASSWORD = "59xso4TAQ8";

	public static final String TIME_ZONE = "0";
	
	public static Connection getConnection(){
		boolean toReInit = false;
		if(connection==null)
			toReInit=true;
		else
			try {
				if(connection.isClosed())
					toReInit=true;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (toReInit) {
			String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB;
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection(url, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}

}
