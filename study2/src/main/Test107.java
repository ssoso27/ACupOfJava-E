package main;

import java.util.StringTokenizer;

public class Test107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String l = "이것은 글을 쓴 내용에 해당하는 #해시태그 문장입니다.";
		
		StringTokenizer st = new StringTokenizer(l);
		while ( st.hasMoreTokens() ) {
			String tkn = st.nextToken();
			System.out.println( tkn );
			
			System.out.println( tkn.indexOf("해당") != -1 );
			
			if ( tkn.charAt(0) == '#' ) {
				System.out.println( tkn );
			}
			
			System.out.println( tkn.startsWith("해당") );
		}
	}

}
