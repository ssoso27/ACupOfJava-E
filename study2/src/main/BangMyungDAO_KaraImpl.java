package main;

import java.util.ArrayList;
import java.util.List;

// 테스트용 가짜 DAO
// DB 없이 돌아감
public class BangMyungDAO_KaraImpl implements BangMyungDAO {
	
	// 가짜 DB 역할
	private static List<BangMyungVO> data = new ArrayList<BangMyungVO>();

	@Override
	public void add(BangMyungVO vo) throws Exception {
		data.add(vo);
	}

	@Override
	public List<BangMyungVO> findAll() throws Exception {
		return data;
	}
	
}
