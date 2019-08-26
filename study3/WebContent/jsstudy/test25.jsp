<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="myajax.js"></script>
<script>

window.onload = function() {
	var btn = document.getElementById("btn");
	btn.onclick = function() {
		var email = document.getElementById("email");
		var url = "for_test25.jsp?email=" + email.value;
		
		ajaxGet( url, function( responseText ) {
			// json data 를 받음 
			/// json은 앞뒤에 ( ) !!
			var data = window.eval( "(" + responseText.trim() + ")");
			
			if ( data.code == 'OK' ) {
				alert("입력 성공");
			} else if ( data.code == 'FAIL' ) {
				alert("입력 실패");
			}
			
		}, function( status ) {
			alert(status);
		} );
	};
}

</script>
</head>
<body>

	<input type="text" id="email"/>
	<input type="button" id="btn" value="Click!"/>

</body>
</html>