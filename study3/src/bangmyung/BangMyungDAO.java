package bangmyung;

import java.util.List;

public interface BangMyungDAO {
	public void add( BangMyungVO vo ) throws Exception ;
	public List<BangMyungVO> findAll() throws Exception ;
}
