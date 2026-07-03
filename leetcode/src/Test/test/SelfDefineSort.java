package Test.test;


import java.util.ArrayList;
import java.util.List;

public class SelfDefineSort {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, 90));
        list.add(new Student(2, 80));
        list.add(new Student(5, 80));
        list.add(new Student(3, 75));
        list.add(new Student(4, 80));

        // 执行排序
        list.sort(null);
//        Collections.sort(list);

        // 打印结果
        for (Student s : list) {
            System.out.println(s);
        }
    }

}

/**
 *Comparable：写进实体类，固定自然排序
 */
class Student implements Comparable<Student> {
    private int id;
    private int score;

    public Student(int id, int score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if(score!=o.score){
            return score-o.score;   //按照分数升序排序
        }else {
            return o.id-id; //分数相同时，按照学号降序排序
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}