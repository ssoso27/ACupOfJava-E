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