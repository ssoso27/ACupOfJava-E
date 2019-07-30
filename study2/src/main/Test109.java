package main;

import java.util.List;

import study2.BangMyungDAO;
import study2.BangMyungDAO_OracleImpl;
import study2.BangMyungVO;

public class Test109 {

	public static void main(String[] args) {
		BangMyungDAO dao = new BangMyungDAO_OracleImpl();
		try {
			List<BangMyungVO> ls = dao.findAll();
			System.out.println( ls.toString() );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
