<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	window.onload = function() {
		// 하위 요소는 .name으로 접근 가능한데, 동일이름이 여럿이면 배열로 받는다.
		var op = document.getElementById("frm");
		// alert( op.fruits.length );
		
		var allCheck = document.getElementById("all");
		allCheck.onclick = function() {
			// alert( allCheck.checked );
			for (var i = 0; i < op.fruits.length; i++) {
				op.fruits[i].checked = allCheck.cheked;
			}
		}
		
		buttonClick("btna", function() {
			alert( 10101 );
		})
		
		loop(0);
	};
	
	function buttonClick(id, callback) {
		if ( callback ) { // callback != undefined
			var btn = document.getElementById(id);
			if ( btn ) { // btn != null
				btn.onclick = callback;
			}
		} else {
			alert();
		}
	}
	
	function loop(i) {
	    var dv = document.getElementById("dv");
	    dv.innerHTML = (10 - i) + "초 후 이동";
	    
	    if (i < 10) {
	        setTimeout( function() { loop(i+1) }, 1000 );
	    }
	    
	    if (i == 10) {
	    	location.href("https://www.google.com");
	    }
	}
</script>
</head>
<body>
	<input type="checkbox" id="all"/>
	<form id="frm">
		<input type="checkbox" name="fruits" value="apple"/>
		<input type="checkbox" name="fruits" value="banana"/>
		<input type="checkbox" name="fruits" value="orange"/>
		<input type="checkbox" name="fruits" value="kiwi"/>
	</form>
	
	<input type="button" value="Click!" id="btn"/>
	
	<div id="dv"></div>
</body>
</html>