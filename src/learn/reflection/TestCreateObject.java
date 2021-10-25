package learn.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 通过反射 动态的创建对象
 * @date Created in 2021/10/21 上午10:57
 */
public class TestCreateObject {

    public static void main(String[] args) throws Exception {
        // 获得class对象
        Class c1 = Class.forName("learn.reflection.User");
//
//        // 通过class对象构造一个对象
//        User user = (User) c1.newInstance(); // 本质上是调用了无参构造器
//
//        System.out.println(user);
//
//        // 通过构造器创建对象
//        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
//        Object user2 = constructor.newInstance("张三", 1, 18);
//        System.out.println(user2);

        // 通过反射调用普通方法
        User user3 = (User) c1.newInstance();

        // 通过反射获得一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);


        // invoke 激活
        // ("对象"，"方法的值")
        setName.invoke(user3,"张三");
        System.out.println(user3.getName());


        System.out.println("=================================");

        // 通过反射 操作属性
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");

        // 不能直接操作私有属性，我们需要关闭程序的安全检测
        name.setAccessible(true);
        name.set(user4,"李四");
        System.out.println(user4.getName());


    }
}
