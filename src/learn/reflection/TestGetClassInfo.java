package learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 获取类的信息
 * @date Created in 2021/10/20 下午10:56
 */
public class TestGetClassInfo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("learn.reflection.User");

        // 获得类的名字
        System.out.println(c1.getName()); // 获得包名 + 类名
        System.out.println(c1.getSimpleName()); // 获得类名

        // 获得类的属性

        // 只能找到public 属性
        Field[] fields = c1.getFields();

        // 找到全部属性
        fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 获取指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("==================");

        // 获取类的方法

        // 获得本类及其父类的全部public方法
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }


        // 获得本类的全部方法
        methods = c1.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("declared:" + method);
        }

        // 获得指定方法
        // 需要参数类型是因为重载的情况存在
        Method getName = c1.getDeclaredMethod("getName", null);
        Method setName = c1.getDeclaredMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);


        // 获得构造器
        Constructor[] constructors = c1.getConstructors();

        // 获得全部的构造器
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();

        // 获得指定的构造器
        Constructor constructor = c1.getConstructor(String.class,int.class,int.class);
    }
}
