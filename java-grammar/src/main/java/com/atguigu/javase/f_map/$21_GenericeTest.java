package com.atguigu.javase.f_map;

/**
 * 声明一个学生类,该学生包含姓名,成绩,而此时学生的成绩类型不稳定,为什么呢,因为,语文老师希望成绩是"优秀","良好","及格","不及格",数学老师希望成绩是
 * 89.5,65.0,英语老师希望成绩是'A','B','C','D',
 */
public class $21_GenericeTest {
    public static void main(String[] args) {
        //语文老师使用时
        NewStudent<String> stu1 = new NewStudent<>("张三","优秀");
        //数学老师使用时
        NewStudent<Double> stu2 = new NewStudent<>("李四", 90.0);
        //英语老师使用时
        NewStudent<Character> stu3 = new NewStudent<>("王五", 'A');

    }
}



//定义泛型类:
class NewStudent<T>{
    private String name;
    private T score;

    public NewStudent() {
    }

    public NewStudent(String name, T score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "NewStudent{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
