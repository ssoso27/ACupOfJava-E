package dao;

import vo.TalkRoomVO;

public interface TalkRoomDAO {
	public String findPermissionByRoomNoANDPassword(Integer roomNo, String password);
}
