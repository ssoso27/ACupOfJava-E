<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%--�Ʒ� ���� i�� ���ú��������� click�ɶ� ����� �����ؾ� ��.
    ���� ���ú����ӿ��� �ұ��ϰ� �Լ�ȣ���� ������ ����־�� �Ѵ�.
    �Լ��� �����־ ������� �� �ۿ� ���� ���ú����� Ŭ����...��� �Ѵ�. --%>
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
         �Ʒ� �Լ��� j�� ����Ű�� ������� ���� �ȴ�.
         callback�� �ι�° �Ű������� �Լ��̰ų� inline�Լ��̾�� �Ѵ�.
         -���� �ڵ忡����� ù �Ű������� 10���� ũ�� �ι�° �Ű������� 
         �Լ��� ȣ���.
         
         �Լ��� ȣ���ϸ鼭 �Ű������� �Լ��� ���� ȣ����ϴ� �����
         callback�̶�� �Ѵ�.
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