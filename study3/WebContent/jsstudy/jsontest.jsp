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
		// �����ð� �ڿ�, �������ؼ� ����
		setTimeout( "loop(" + (i+1) + ")", 1000*5 );	
	}
	
}

</script>
</head>
<body>

</body>
</html>