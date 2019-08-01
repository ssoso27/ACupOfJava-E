package dao;

import java.util.List;
import vo.TalkVO;

public interface TalkDAO {
	public List<TalkVO> findByRoomNo(int roomNo);
}
