<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

window.onload = function () {
	loop(0);
};

function loop ( i ) {
	alert("I am loop! " + i);
	
	if ( i != 10 ) {
		// 지정시간 뒤에, 컴파일해서 실행
		setTimeout( "loop(" + (i+1) + ")", 1000*5 );	
	}
	
}

</script>
</head>
<body>

</body>
</html>