package dao;

import vo.TalkRoomVO;

public class TalkRoomDAO_OracleImpl implements TalkRoomDAO {

	@Override
	public String findPermissionByRoomNoANDPassword(int roomNo, String password) {
		return password;
	}

}
