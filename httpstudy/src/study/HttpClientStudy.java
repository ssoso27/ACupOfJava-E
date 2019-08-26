package study;

import java.io.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

public class HttpClientStudy {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// Get 방식 요청 생성. 
		String url = "http://192.168.2.11:8081/study3/Test126.jsp?pw=1234";
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("User-Agent", "Mozila/5.0"); // 헤더 조작
		
		// 만들어진 Get 방식으로 요청하고, 응답 받음
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		// 응답에서 상태코드 받음
		int resCode = httpResponse.getStatusLine().getStatusCode();
		
		// 응답 확인
		if ( resCode == 200 ) { // 요청이 성공했을 시
			// response의 내용을 받음
			InputStream in = httpResponse.getEntity().getContent();
			BufferedReader bin 
				= new BufferedReader( 
						new InputStreamReader( in, "UTF-8" ) ); // UTF-8 인코딩 설정
			String line = null;
			
			while ( (line = bin.readLine()) != null ) {
				System.out.println(line);
			}
			
			in.close();
		} 
	}

}
