<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%--아래 변수 i는 로컬변수이지만 click될때 사용이 가능해야 함.
    따라서 로컬변수임에도 불구하고 함수호출이 끝나도 살아있어야 한다.
    함수에 물려있어서 살아있을 수 밖에 없는 로컬변수가 클로져...라고 한다. --%>
<!DOCTYPE html>
<html>
<head>
   <script>
      window.onload=function(){
         var i=100;
         var op=document.getElementById("abcd");
         op.onclick=function(){
            alert(i);
         };
         
         callback(20,function(t){alert(t);});
         
         setTimeout( function() {
        	 alert('hello');
         	}, 5000);
      };
      /*
         아래 함수는 j가 가리키는 변수라면 말이 된다.
         callback의 두번째 매개변수는 함수이거나 inline함수이어야 한다.
         -위의 코드에서라면 첫 매개변수가 10보다 크면 두번째 매개변수의 
         함수가 호출됨.
         
         함수를 호출하면서 매개변수의 함수가 도로 호출당하는 모양을
         callback이라고 한다.
      */
      function callback(i,j){
         if(i>10)
         {
            j(i);
         }
         
      }
   </script>
</head>
<body>

</body>
</html>