<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script>

window.onload = function() {
	$(document).ready( function() {
		$(".dum").click( function() {
			$(".dum").attr("src", "opera.png");
			$(this).attr("src", "safari.png");
		})
		
		/*
		$("#btn").click( function() {
			$("#dv").text("SOHEE WORLD");
			// dv.style.backgroundColor = "red"
			$("#dv").css("background-color", "red");
			$("#dv").css("font-size", "20px");
		})
		*/
		

		$("#btn").click( function() {
			var google = $("<img></img>").attr("src", "google.png");
			$("#dv").append( google );
		});
		
		var gu = document.getElementById("gu");
		gu.onchange = function() {
			var idx = gu.selectedIndex;
			if ( idx != 0 ) {
				alert( gu.options[idx].value );
			}
		};
		
		$("#gu").change( function() {
			var data = $("#gu > option:selected").val();
			alert( data );
		});
	});
}

</script>
</head>
<body>
	<img class="dum" src="google.png"/>
	<img class="dum" src="google.png"/>
	<img class="dum" src="google.png"/>
	<img class="dum" src="google.png"/>
	
	<div id="dv">HelloWorld</div>
	<input type="button" id="btn" value="CLICK!"/>
	
	<select id="gu">
		<option>구를 선택하세요</option>
		<option value="kangnam">강남구</option>
		<option value="seocho">서초구</option>
	</select>
</body>
</html>