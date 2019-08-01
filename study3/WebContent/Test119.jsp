<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
    
<% 
request.setAttribute("apple", 100);
request.setAttribute("arr", new int[]{1, 2, 3, 4});

%>
<!DOCTYPE html>
<html>
<body>
${ apple }
${ apple > 10 }
${ arr[0] }
</body>
</html>