package leetcode_learning.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test2 {

    @MyAnnotation2
    public void test(){

    }
}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    int id() default -1;
    String name() default "";
    int age() default 0;
    String[] schools() default {"清华大学","北京大学"};
}