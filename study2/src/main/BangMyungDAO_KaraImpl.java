package main;

import java.util.ArrayList;
import java.util.List;

// �׽�Ʈ�� ��¥ DAO
// DB ���� ���ư�
public class BangMyungDAO_KaraImpl implements BangMyungDAO {
	
	// ��¥ DB ����
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
