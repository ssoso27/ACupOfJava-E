package dao;

import vo.TalkRoomVO;

public interface TalkRoomDAO {
	public String findPermissionByRoomNoANDPassword(int roomNo, String password);
}
