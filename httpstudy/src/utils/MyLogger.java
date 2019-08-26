package utils;

import org.apache.log4j.Logger;

public class MyLogger {
	static Logger logger = null;
	
	static {
		logger = Logger.getLogger("ssoso");
	}
	
	public static void log( Object obj ) {
		if ( obj == null ) {
			logger.info( "[null]" );
		}
		else {
			logger.info( obj.toString() );
		}
	}
}
