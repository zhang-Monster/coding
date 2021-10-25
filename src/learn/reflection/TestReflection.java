package learn.reflection;

import java.util.Objects;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/10/20 下午6:14
 */
public class TestReflection extends Object {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> c1 = Class.forName("learn.reflection.User");
        System.out.println(c1);

        Class<?> c2 = Class.forName("learn.reflection.User");
        Class<?> c3 = Class.forName("learn.reflection.User");
        Class<?> c4 = Class.forName("learn.reflection.User");

        // 一个类在内存中只有一个Class对象
        // 一个类被加载后，类的整个结构都会被封装在Class对象中
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());

    }
}

class User{

    private String name;

    private int id;

    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void a() {

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
