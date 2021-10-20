package learn.single;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 延迟加载懒汉模式
 * @date Created in 2021/10/12 下午11:00
 */
public class LazyManSingleton {

    /**
     * 构造器私有
     */
    private LazyManSingleton(){

    }

    /**
     * v使用olatile关键字
     * 禁止指令重排序
     * 保证可见性
     */
    private static volatile LazyManSingleton instance = null;

    /**
     * 延迟加载懒汉式模式
     * 考虑了线程安全的写法
     * @return
     */
    public LazyManSingleton getInstance() {
        synchronized (LazyManSingleton.class) {
            if (instance == null) {
                instance = new LazyManSingleton();
            }
        }

        return instance;
    }
}
