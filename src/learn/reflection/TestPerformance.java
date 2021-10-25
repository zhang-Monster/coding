package learn.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 分析反射的性能问题
 * @date Created in 2021/10/21 下午3:48
 */
public class TestPerformance {

    // 普通方式调用
    public static void test01() {
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            user.getName();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("普通方式调用所需的时间：" + (endTime - startTime) + "ms");
    }


    // 反射方式调用
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            getName.invoke(user,null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("反射方式调用所需的时间：" + (endTime - startTime) + "ms");
    }

    // 反射方式调用 关闭检测
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName");
        getName.setAccessible(true);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            getName.invoke(user,null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("关闭检测方式调用所需的时间：" + (endTime - startTime) + "ms");
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();

    }
}
