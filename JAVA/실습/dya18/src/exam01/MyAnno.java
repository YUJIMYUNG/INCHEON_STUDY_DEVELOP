package exam01;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


@Target({TYPE, FIELD, METHOD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String value() default "값1"; // 기본 설정 value();
    int max() default 100;
    int[] numbers() default {10, 20};

}
