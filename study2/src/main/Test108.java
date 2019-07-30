package main;

import main.BangMyungDAO;
import main.BangMyungDAO_OracleImpl;

public class Test108 {

	public static void main(String[] args) {
		BangMyungDAO dao = new BangMyungDAO_OracleImpl();
		BangMyungVO vo = new BangMyungVO();
		
		vo.setGul("HElloWORLD");
		
		try {
			dao.add(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
