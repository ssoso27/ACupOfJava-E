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
      //��� onXXX�� ����Ű�� �Լ��� ���� �Ű������� �ϳ� �ִ� �Լ��̴�.
      //�Ű��������� �߻��Ǿ��� �̺�Ʈ�� ���õ� ������ �������.
      //������ � �̺�Ʈ�� �������Ŀ� ���� Ʋ����.
      
      
      //���콺�� Ŭ���� ��ġ�� �����ִ� �ڵ�
      dv.onclick=fucntion(e){
         alert(e.clientX+","+e.clientY);
         if(e.clientX>200&&e.clientY<40&&e.clientX<22&&e.cleintY>20)
         {
            dv.style.display='none';
         }
      }
      //� Ű���������� �������� �� �� �ִ� �ڵ�
      //Ŭ������ �̺�Ʈ ���� ������ Ű���� �Է½� ���� ������ �ٸ���.
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
<!-- �̺�Ʈ ����
   ������ ���� �̺�Ʈ�� �� �Ϳ��� ���޵ȴ�.
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
