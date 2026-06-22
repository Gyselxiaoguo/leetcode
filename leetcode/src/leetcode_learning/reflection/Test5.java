package leetcode_learning.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test5 {
    public void test1(Map<String, Student1> map, List<Student1> list){
        System.out.println("test1");
    }

    /*public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test5.class.getDeclaredMethod("test1", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
            if(genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
    }*/


    public Map<String, Student1> test2(){
        System.out.println("test2");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test5.class.getDeclaredMethod("test2", null);
        Type genericReturnType = method.getGenericReturnType();
        System.out.println(genericReturnType);

        if(genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }

    }
}
