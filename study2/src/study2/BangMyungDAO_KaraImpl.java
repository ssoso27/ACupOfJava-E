package study2;

import java.util.ArrayList;
import java.util.List;

/*	데이터를 다루는 클래스는 독립시켜서 만드는 경향이 강하다. ( 별도의 클래스 )
 	A 는 데이터베이스와 관련된 기능 구현 
 	B 는 웹 프로그래밍과 관련된 기능 구현 
 	
 	원래대로라면 A 끝나고 결과코드를 B 에 넘겨주고 B 는 그걸 받아서 일한다.
 	비효율적이다 : 동시에 얼마든지 일 할 수 있는데 ....
 	
 	BangMyungDAO - 방명록에 필요한 데이터 입출력 기능을 모아서 추상화 했다.
 		:: add , findAll 
 	
 	BangMyungDAO_KaraImpl : DB 연동을 비슷하게 흉내내준다.
 		add 를 이용해서 레코드를 쌓고 , findAll 로 쌓인 레코드를 출력하고 ...
 		
 	B 는 BangMyungDAO_KaraImpl 을 이용하여 작업에 착수한다.
 	A 는 BangMyungDAO_OracleImpl 을 구현한다 ( jdbc 코드 작성 )
 	
 	양쪽이 다 테스트가 끝나서 통합에 들어간다.
 		BangMyungDAO_KaraImpl 을 BangMyungDAO_OracleImpl 바꾸기만 하면 된다.
 		
 	"데이터를 다루는 코드를 독립된 클래스로 만들되
 	 그 작업들을 추상화 한 인터페이스를 기반으로 만드는 설계 기법을
 	 DAO ( Data Access Object ) Pattern 이라고 한다."
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
