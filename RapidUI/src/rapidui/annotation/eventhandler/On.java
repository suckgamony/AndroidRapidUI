package rapidui.annotation.eventhandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import rapidui.annotation.Lifecycle;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface On {
	public String event();
	public int[] id();
	public Lifecycle lifecycle() default Lifecycle.CREATE;
}
