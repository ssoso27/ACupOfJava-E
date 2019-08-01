package dao;

import java.util.ArrayList;
import java.util.List;

import vo.TalkVO;

public class TalkDAO_OracleImpl implements TalkDAO {

	@Override
	public List<TalkVO> findByRoomNo(int roomNo) {
		List<TalkVO> lst = new ArrayList<TalkVO>();
		TalkVO vo = new TalkVO();
		vo.setRoomNo(10);
		vo.setTalkNo(20);
		vo.setContent("content는내용이다");
		
		for(int i = 0; i < 10; i++) lst.add(vo);
		return lst;
	}
	
}
