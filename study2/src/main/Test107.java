package main;

import java.util.StringTokenizer;

public class Test107 {
	public static void main(String[] args) {
		String l = "���ش��� �̰��� ���� �� ���뿡 �ش��ϴ� #�ؽ��±� �����Դϴ�.";
		
		/*	���忡�� ������ �������� �ϳ��� �߶� ���� ����Ѵ�.
		 * 	String �� split �Լ��� ����� ����� ������ ������ �� ������.
		 */
		StringTokenizer st = new StringTokenizer( l );
		while( st.hasMoreTokens() ) {
			String tkn = st.nextToken();
			System.out.println( tkn.startsWith("�ش�") );
			if( tkn.charAt(0) == '#' ) {
				System.out.println( tkn );				
			}
		}
	}
}






