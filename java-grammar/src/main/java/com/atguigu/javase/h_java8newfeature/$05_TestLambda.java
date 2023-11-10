package com.atguigu.javase.h_java8newfeature;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Lambda表达式练习
 */
public class $05_TestLambda {

    public static void callSomething(Call call){
        call.shout();
    }
    /**
     * 1.无参无返回值形式
     */
    @Test
    public void test01(){
        callSomething(()-> System.out.println("hello world"));
    }

    /**
     * 2.消费型接口 案例一:创建一个Collection系列的集合,添加你知道的编程语言,调用forEach方法遍历查看
     * 在JDK1.8中Collection集合接口的父接口Iterable接口中增加了一个默认方法：
     * public default void forEach(Consumer<? super T> action) 遍历Collection集合的每个元素，
     * 执行“xxx消费型”操作。
     */
    @Test
    public void test02(){
        List<String> list = Arrays.asList("java", "c", "python", "c++", "c#");
        list.forEach(s-> System.out.println(s));
    }
    /**
     * 2.消费型接口 案例二:创建一个Map系列的集合,添加一些(key,value)键值对,例如添加一些编程语言排名和语言名称,调用forEach方法遍历查看
     * 在JDK1.8中Map集合接口中增加了一个默认方法：
     * public default void forEach(BiConsumer<? super K,? super V> action) 遍历Map集合的每
     * 对映射关系，执行“xxx消费型”操作
     */
    @Test
    public void test03(){
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"java");
        map.put(2,"c");
        map.put(3,"python");
        map.put(4,"c++");
        map.put(5,"c#");
        map.forEach((k,v)-> System.out.println(k+"->"+v));
    }
    /**
     * 3.供给型接口
     * 代码实例:Supplier接口
     * 在jdk 1.8中增加了StreamAPI,java.util.stream.Stream是一个数据流,这个类型有一个静态方法:
     * public static <T> Stream<T> generate(Supplier<T> s) 可以创建Stream的对象,而又包含一个forEach方法可以遍历流中的元素: public void forEach(Consumer<? super T> action)
     */
    @Test
    public void test04(){
        //调用Stream的generate方法,产生一个流对象,并调用Math.Random()来产生数据,为Supplier函数式接口的形参赋值,最后调用forEach方法遍历流中的数据查看结果
        Stream.generate(()->Math.random()).forEach(num -> System.out.println(num));
    }
    /**
     * 4.功能型接口
     * 代码示例:Function<T,R>接口
     * 在jdk1.8时Map接口增加了很多方法
     * 例如 public default void replaceAll(BiFunction<? super K,? super V,? extends V> function) 按照function指定的操作替换map中的value
     *     public default void foreach(BiConsumer<? super K,? super V> action)遍历map集合中的每对映射关系,执行"xxx消费型操作"
     *  案例:
     *      ①声明一个Employee员工类型,包含编号,姓名,薪资
     *      ②添加n个员工对象到一个HashMap<Integer,Employee>集合中,其中员工编号为key,员工对象为value
     *      ③调用Map的foreach遍历集合
     *      ④调用Map的replaceAll方法,将其中薪资低于10000元的,薪资设置为10000
     *      ⑤再次调用Map的foreach遍历集合查看结果
     */
    @Test
    public void test05(){
        HashMap<Integer, Employee> map = new HashMap<>();
        Employee e1 = new Employee(1, "张三", 8000);
        Employee e2 = new Employee(2, "赵四", 9000);
        Employee e3 = new Employee(3, "王五", 10000);
        Employee e4 = new Employee(4, "赵六", 11000);
        Employee e5 = new Employee(5, "钱七", 12000);
        map.put(e1.getId(), e1);
        map.put(e2.getId(), e2);
        map.put(e3.getId(), e3);
        map.put(e4.getId(), e4);
        map.put(e5.getId(), e5);
        map.forEach((k,v)-> System.out.println(k+"->"+v));
        System.out.println();
        map.replaceAll((k,v)->{
            if(v.getSalary()<10000){
                v.setSalary(10000);
            }
            return v;
        });
        map.forEach((k,v)-> System.out.println(k+"->"+v));
    }

    /**
     * 5.判断型接口
     * 代码示例:Predicate接口
     * jdk1.8时,Collection接口增加了以下方法,其中一个如下:
     *  public default boolean removeIf(Predicate<? super E> filter) 用于删除集合中满足filter指定的条件判断的
     *  public default void forEach(Consumer<? super T> action)遍历collection集合中的每个元素,执行"xxxx消费型操作"
     *  案例:
     *      ①添加一些字符串到一个Collection集合中
     *      ②调用forEach遍历集合
     *      ③调用removeIf方法,删除其中字符串长度<5的
     *      ④再次调用forEach遍历集合
     */
    @Test
    public void test06(){
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("atguigu");
        list.add("ok");
        list.add("yes");
        list.forEach(word -> System.out.println(word));
        System.out.println();
        list.removeIf(word -> word.length()<5);
        list.forEach(word -> System.out.println(word));

    }

    /**
     * 5.判断型接口: 综合案例
     *      ①声明一个Employee员工类型,包含编号,姓名,性别,年龄,薪资
     *      ②声明一个EmployeeService员工管理类,包含一个ArrayList集合的属性all,在EmployeeService的构造器中,创建一些员工对象,为all集合初始化
     *      ③在EmployeeService员工管理类中,声明一个方法:ArrayList get(Predicate p),即将满足p指定条件的员工,添加到一个新的ArrayList集合中返回
     *      ④在测试类中创建EmployeeService员工管理类的对象,并调用get方法分别获取
     *          ·所有员工对象
     *          ·所有年龄超过35的员工
     *          ·所有薪资高于15000的女员工
     *          ·所有编号是偶数的员工
     *          ·名字是"张三"的员工
     *          ·年龄超过25,薪资低于10000的男员工
     */
    @Test
    public void test07(){
        EmployeeService es = new EmployeeService();
        es.get(employee -> true).forEach(employee -> System.out.println(employee));//所有员工对象
        System.out.println("-----------------------------");
        es.get(employee -> employee.getAge()>35).forEach(employee -> System.out.println(employee));//所有年龄超过35的员工
        System.out.println("-----------------------------");
        es.get(employee -> employee.getSalary() > 15000 && employee.getGender() == '女').forEach(employee -> System.out.println(employee));//所有薪资高于15000的女员工
        System.out.println("-----------------------------");
        es.get(employee -> employee.getId() % 2 == 0).forEach(employee -> System.out.println(employee));//所有编号是偶数的员工
        System.out.println("-----------------------------");
        es.get(employee -> employee.getName().equals("张三")).forEach(employee -> System.out.println(employee));//名字是张三的员工
        System.out.println("-----------------------------");
        es.get(employee -> employee.getAge() > 25 && employee.getSalary() < 10000 && employee.getGender() == '男').forEach(employee -> System.out.println(employee));//年龄超过25,薪资低于10000的男员工

    }
}
interface Call{
    void shout();
}

class Employee{
    private int id;
    private String name;
    private char gender;
    private int age;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(int id, String name, char gender, int age, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
class EmployeeService{
    private ArrayList<Employee> all;

    public EmployeeService(){
        all = new ArrayList<Employee>();
        all.add(new Employee(1,"张三",'男',33,8000));
        all.add(new Employee(2,"李四",'女',23,9000));
        all.add(new Employee(3,"王五",'男',27,10000));
        all.add(new Employee(4,"赵六",'女',36,18000));
        all.add(new Employee(5,"田七",'男',29,15000));
        all.add(new Employee(6,"朱八",'男',36,11000));
    }
    public ArrayList<Employee> get(Predicate<Employee> p){
        ArrayList<Employee> result = new ArrayList<>();
        for(Employee emp: all){
            if (p.test(emp)){
                result.add(emp);
            }
        }
        return result;
    }

}
