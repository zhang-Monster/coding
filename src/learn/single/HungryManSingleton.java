package learn.single;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:饿汉式单例
 * @date Created in 2021/10/12 下午10:33
 */
public class HungryManSingleton {

    /**
     * 单例模式 构造器私有
     */
    private HungryManSingleton(){

    }

    /**
     * static 修饰 依附于类存在
     * 立即加载饿汉模式 在使用类的时候就已经将对象创建完毕了
     * 无法做到延迟加载
     */
    private static HungryManSingleton instance = new HungryManSingleton();

    public static HungryManSingleton getInstance() {
        return instance;
    }


}
