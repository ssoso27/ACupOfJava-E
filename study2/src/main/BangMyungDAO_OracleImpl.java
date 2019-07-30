package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BangMyungDAO_OracleImpl implements BangMyungDAO {
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521/XE";
	private String user = "HR";
	private String pw = "hr";

	@Override
	public void add(BangMyungVO vo) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		
		String gul = vo.getGul();
		String sql = "INSERT INTO bangmyung_t VALUES ( seq_bangmyung.NEXTVAL, '" + gul  +"', SYSDATE) ";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);	

		} catch (Exception e) {
			throw e;
			
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<BangMyungVO> findAll() throws Exception {
		String sql = "SELECT no, gul, the_time FROM bangmyung_t ORDER BY no desc";
		List<BangMyungVO> ls = new ArrayList<BangMyungVO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, pw);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while ( rs.next() ) {
				BangMyungVO vo = new BangMyungVO();
				
				vo.setNo( rs.getInt("no") );
				vo.setGul( rs.getString("gul") );
				vo.setTheTime( rs.getString("the_time") );
				
				System.out.println(vo.toString());
				ls.add( vo );
			}
			rs.close();
			
			stmt.close();
			conn.close();
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		return ls;
	}
	
	
}
