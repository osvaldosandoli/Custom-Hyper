package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcustom";
	private String user = "root";
	private String password = "";
	
	
	
	/**
	 * Method responsible for connecting to the database
	 * 
	 * @return con
	 *
	 */
	
	public Connection conectar(){
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
