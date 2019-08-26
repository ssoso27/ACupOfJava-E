<%@page contentType="text/html;charset=utf-8" pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <style>
    @import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
    .hf{ font-family:"Nanum Gothic";}
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">		
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="myajax.js"></script>
    <script>
    window.onload = function(){
        $(document).ready(function(){
            $('#modal_ADD').click(function(e){
            	var email = $('#email').val();
            	var passwd = $('#passwd').val();            	
            	var url = "modal_login.jsp?email="+email+"&passwd="+passwd;

            	ajaxGet( url, function( response ){
            		var data = window.eval( "(" + response.trim() + ")" );
            		
            		if ( data.code == "OK" ) {
            			$('#alert').text('������');
            			window.setTimeout( function() {
            				$('#abcd').modal('hide');
            			}, 3000);
            		}
            	});
            });
            
            $('#modal_OK').click( function(e){
                $('#abcd').modal('hide');
            });            
        });
    };
    </script>		
</head>
<body>
<div class="container">
    <button data-toggle="modal" data-target="#abcd"
        class="btn btn-default">Click</button>
        
    <div id="abcd" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
					<div id="alert" class="hf alert alert-dark" role="alert">
  						�Է��� �ֽÿͿ� 
					</div>                
					<div class="form-group">
						<label class="hf" for="email">�̸���</label>
						<input id="email" class="hf form-control" type="text"/>
					</div>
					<div class="form-group">
						<label class="hf" for="passwd">��ȣ</label>
						<input id="passwd" class="hf form-control" type="password"/>
					</div>
                </div>
                <div class="modal-footer">
                    <button id="modal_ADD"
                        class="btn btn-default">Add</button>
                    <button id="modal_OK" 
                    	class="btn btn-default">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>