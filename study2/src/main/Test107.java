package main;

import java.util.StringTokenizer;

public class Test107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String l = "�̰��� ���� �� ���뿡 �ش��ϴ� #�ؽ��±� �����Դϴ�.";
		
		StringTokenizer st = new StringTokenizer(l);
		while ( st.hasMoreTokens() ) {
			String tkn = st.nextToken();
			System.out.println( tkn );
			
			System.out.println( tkn.indexOf("�ش�") != -1 );
			
			if ( tkn.charAt(0) == '#' ) {
				System.out.println( tkn );
			}
			
			System.out.println( tkn.startsWith("�ش�") );
		}
	}

}
