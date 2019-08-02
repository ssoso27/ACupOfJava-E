package utils;

public class Util {
	public static int parseInt( String str ) {
		try {
			int r = Integer.parseInt(str);
			return r;
		} catch ( Exception e ) {
			return -1;
		}
	}

	// 한글 인코딩 처리 
	public static String encodeUTF8( String str ) {
		if (str == null || str == "") {
			return str;
		}
		
		try {
			byte[] bs = str.getBytes("8859_1");
			str = new String( bs, "UTF-8" );
		} catch ( Exception e ) {}
		
		return str;
	}
}
