<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
   #dv{
      position:absolute;
      top:20px;left:200px;
      width:200px;height:100px;
      
   }


</style>
<script>

   window.onload=function(){
      var dv=documetn.getElementById("dv");
      //모든 onXXX가 가리키는 함수는 실은 매개변수가 하나 있는 함수이다.
      //매개변수에는 발생되어진 이벤트에 관련된 내용이 들어있음.
      //내용은 어떤 이벤트가 벌어졌냐에 따라 틀리다.
      
      
      //마우스로 클릭한 위치를 없애주는 코드
      dv.onclick=fucntion(e){
         alert(e.clientX+","+e.clientY);
         if(e.clientX>200&&e.clientY<40&&e.clientX<22&&e.cleintY>20)
         {
            dv.style.display='none';
         }
      }
      //어떤 키보드자판을 눌렀는지 알 수 있는 코드
      //클릭시의 이벤트 내부 정보와 키보드 입력시 내부 정보는 다르다.
      var tx=document.getElementById("tx");
      tx.onkeyup=function(e){
         if(e.keyCode==13)
            {
            
               e.preventDefault();
            }
      
      };
   };

</script>
</head>
<body>
<!-- 이벤트 버블링
   포개진 경우는 이벤트를 깔린 것에게 전달된다.
 -->
   <div id="dv"></div>
   <input type="text" id="tx"/>
   <div style="background-color: red onclick="alert(3);">
      apple
      <div style="background-color: blue" onclick="alert(2);">
         banana
         <div style="background-color: green" onclick="alert(1);">
            orange
         </div>
      </div>
   </div>
</body>
</html>
