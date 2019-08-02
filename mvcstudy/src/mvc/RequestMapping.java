package mvc;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
	public String value(); 
}
