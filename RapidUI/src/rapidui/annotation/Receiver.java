package rapidui.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Receiver {
	public String[] value() default {};
	public String[] action() default {};
	public String[] extra() default {};
	public String[] category() default {};
	public Lifecycle lifecycle() default Lifecycle.START;
}
