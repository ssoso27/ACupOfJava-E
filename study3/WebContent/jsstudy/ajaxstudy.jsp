<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

window.onload = function() {
	ajaxGet("mydata.jsp"
		, function( rt ) {
			var lst = rt.split(",");
			alert( [0] );
		}, function( code ) {
			alert("error : " + code );
		});
}

function ajaxGet( target, success, reject ) {
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if ( xhr.readyState == 4 ) {
			
			if ( xhr.status == 200 ) {
				if ( success ) success( xhr.responseText );
			} else {
				if ( reject ) reject( xhr.status );
			}
		}	
	}
	
	xhr.open('GET', target, true);
	xhr.send( null );
}

</script>
</head>
<body>

</body>
</html>