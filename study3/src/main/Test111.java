package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test111 {

	public static void main(String[] args) throws Exception {
		String data = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521/XE", "HR", "hr");
		
		String sql = "INSERT INTO temp20t VALUES ( ? )";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString( 1, "lnn" );
		stmt.executeUpdate();

		stmt.close();
		conn.close();
	}

}
