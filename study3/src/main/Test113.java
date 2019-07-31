package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Test113 {

	public static int update( String sql, Object... args) throws Exception {
		int rc = 0;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521/XE", "HR", "hr");
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		for (int i = 0; i < args.length; i++) {
			if ( args[i] == null ) {
				System.out.println("null");
				stmt.setObject(i+1, null);
				
			} else if ( args[i] instanceof Integer ) {
				int r = ( (Integer)args[i] ).intValue();
				System.out.println("integer : " + r);
				stmt.setInt(i+1, r);
				
			} else if ( args[i] instanceof Double ) {
				double r = ( (Double)args[i] ).doubleValue();
				System.out.println("double : " + r);
				stmt.setDouble(i+1, r);
				
			} else if ( args[i] instanceof String ) {
				System.out.println("string : " + (String)args[i] );
				stmt.setString(i+1, (String) args[i]); 
				
			}
		}

		stmt.executeUpdate();

		stmt.close();
		conn.close();
		
		return rc;
	}
	
	public static void main(String[] args) throws Exception {
		String sql = "INSERT INTO temp20t VALUES ( ? )";
		
		update(sql, 55);
	}

}
