package study;

import java.io.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

public class HttpClientStudy {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// Get ��� ��û ����. 
		String url = "http://192.168.2.11:8081/study3/Test126.jsp?pw=1234";
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("User-Agent", "Mozila/5.0"); // ��� ����
		
		// ������� Get ������� ��û�ϰ�, ���� ����
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		// ���信�� �����ڵ� ����
		int resCode = httpResponse.getStatusLine().getStatusCode();
		
		// ���� Ȯ��
		if ( resCode == 200 ) { // ��û�� �������� ��
			// response�� ������ ����
			InputStream in = httpResponse.getEntity().getContent();
			BufferedReader bin 
				= new BufferedReader( 
						new InputStreamReader( in, "UTF-8" ) ); // UTF-8 ���ڵ� ����
			String line = null;
			
			while ( (line = bin.readLine()) != null ) {
				System.out.println(line);
			}
			
			in.close();
		} 
	}

}
