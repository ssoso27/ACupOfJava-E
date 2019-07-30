package study2;

import java.util.ArrayList;
import java.util.List;

/*	�����͸� �ٷ�� Ŭ������ �������Ѽ� ����� ������ ���ϴ�. ( ������ Ŭ���� )
 	A �� �����ͺ��̽��� ���õ� ��� ���� 
 	B �� �� ���α׷��ְ� ���õ� ��� ���� 
 	
 	������ζ�� A ������ ����ڵ带 B �� �Ѱ��ְ� B �� �װ� �޾Ƽ� ���Ѵ�.
 	��ȿ�����̴� : ���ÿ� �󸶵��� �� �� �� �ִµ� ....
 	
 	BangMyungDAO - ���Ͽ� �ʿ��� ������ ����� ����� ��Ƽ� �߻�ȭ �ߴ�.
 		:: add , findAll 
 	
 	BangMyungDAO_KaraImpl : DB ������ ����ϰ� �䳻���ش�.
 		add �� �̿��ؼ� ���ڵ带 �װ� , findAll �� ���� ���ڵ带 ����ϰ� ...
 		
 	B �� BangMyungDAO_KaraImpl �� �̿��Ͽ� �۾��� �����Ѵ�.
 	A �� BangMyungDAO_OracleImpl �� �����Ѵ� ( jdbc �ڵ� �ۼ� )
 	
 	������ �� �׽�Ʈ�� ������ ���տ� ����.
 		BangMyungDAO_KaraImpl �� BangMyungDAO_OracleImpl �ٲٱ⸸ �ϸ� �ȴ�.
 		
 	"�����͸� �ٷ�� �ڵ带 ������ Ŭ������ �����
 	 �� �۾����� �߻�ȭ �� �������̽��� ������� ����� ���� �����
 	 DAO ( Data Access Object ) Pattern �̶�� �Ѵ�."
*/
public class BangMyungDAO_KaraImpl implements BangMyungDAO 
{
	private static List<BangMyungVO> data = new ArrayList<BangMyungVO>();
	private static int no = 0;
	
	@Override
	public void add(BangMyungVO vo) throws Exception {
		vo.setNo( no++ );
		vo.setTheTime( "1999-12-12 12:00:00" );
		
		data.add( vo );
	}

	@Override
	public List<BangMyungVO> findAll() throws Exception {
		return data;
	}
}
