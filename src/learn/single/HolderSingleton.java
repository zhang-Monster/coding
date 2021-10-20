package learn.single;


/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 内部静态类实现
 * @date Created in 2021/10/12 下午11:30
 */
public class HolderSingleton {

    /**
     * 构造器私有
     */
    private HolderSingleton(){

    }

    /**
     * 内部静态类实现的方式
     * 静态内部类只会被加载一次
     */
    public static class Holder {
        private static final HolderSingleton instance = new HolderSingleton();
    }

    public HolderSingleton getInstance() {
        return Holder.instance;
    }

}
