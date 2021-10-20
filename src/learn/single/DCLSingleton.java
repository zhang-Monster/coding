package learn.single;


/**
 * @version V1.0
 * @author: zhangkun
 * @Description:Double-check-lock(双重校验锁)
 * @date Created in 2021/10/12 下午11:06
 */
public class DCLSingleton {
    private DCLSingleton(){

    }

    private static volatile DCLSingleton instance;

    /**
     * 双重校验锁的写法
     * 进行两次null检查 看似多次一举，但是实际上确极大的提升了并发度，进而提升了性能
     * 为什么可以提高并发度？
     * 在单例中new的情况非常少，绝大多数都是可以并行的读操作。因此在加锁前多进行一次null检查就可以减少绝大多数的加锁操作
     * 执行效率提高的目的也就达到了
     * @return
     */
    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    // new对象并非原子操作，new创建对象分为三步：
                    // 1、内存中分配空间
                    // 2、初始化该空间
                    // 3、将instance指向该空间
                    // 此处并非为原子操作 可能会发生指令重排序，因此需要使用volatile关键字修饰instance
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
