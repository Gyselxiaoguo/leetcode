package leetcode_learning.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation
public class Test1{
    @MyAnnotation
    public void test(){}
}

@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(value= RetentionPolicy.RUNTIME)
@interface MyAnnotation{

}
