package learn.reflection;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 类加载器
 * @date Created in 2021/10/20 下午10:41
 */
public class TestClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器 --> 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取扩展类加载器的父类加载器 --> 根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        // 测试当前类是那个类加载器
        ClassLoader classLoader = Class.forName("learn.reflection.TestClassLoader").getClassLoader();
        System.out.println(classLoader);

        // 测试java内部类的类加载器（根加载器）
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        // 获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        // 双亲委派机制
    }
}
