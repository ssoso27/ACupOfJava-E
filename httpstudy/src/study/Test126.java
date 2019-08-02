package study;

import java.net.*;
import java.io.*;

public class Test126 {
	public static void main(String[] args) throws Exception {
		URL rl = new URL("http://localhost:8081/httpstudy/Test127.jsp");
		URLConnection ucon = rl.openConnection();
		InputStream in = ucon.getInputStream();
		
		// Reader : Char 단위의 파일수신
		BufferedReader bin = new BufferedReader( new InputStreamReader( in, "UTF-8" ) );
		
		String l = null;
		while ( ( l = bin.readLine() ) != null ) {
			System.out.println( l );
		}
		
		in.close();
	}
}
