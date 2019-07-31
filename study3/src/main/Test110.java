package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test110 {

	public static void main(String[] args) throws Exception {
		String data = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521/XE", "HR", "hr");
		Statement stmt = conn.createStatement();
		
		String sql = ( data != null ) ? 
				"INSERT INTO temp20t VALUES ('abc')" :
				"INSERT INTO temp20t VALUES (null)";
		stmt.executeUpdate(sql);
		
		stmt.close();
		conn.close();
	}
}
