package Test.utils;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        sb.append("asd");
        sb.append('f');
        System.out.println(sb.charAt(sb.length() - 1));
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        sb.insert(0,"hello");
        System.out.println(sb.toString());

    }
}
