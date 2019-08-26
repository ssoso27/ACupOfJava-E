<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<script>
	window.onload = function() {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			alert( xhr.readyState );
			
			// response 도착 완료시
			if ( xhr.readyState == 4 ) {
				// xhr.status : http 상태코드
				if ( xhr.status == 200 ) {
					var rt = xhr.responseText;
					alert( rt );
					
					var lst = rt.split(",");
					for( var i = 0; i < lst.length; i++ ) {
						alert( lst[i] );
					}
				} else {
					alert("error : " + xhr.status);
				}
			} 
		};
		xhr.open('GET', 'mydata.jsp', true);
		xhr.send( null );
	};
</script>
</head>
<body>
</body>
</html>