package learn.Thread;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: volatile 不保证原子性验证
 * @date Created in 2021/10/11 下午11:04
 */
public class JMMDemo2 {
    // 加了volatile不保证原子性
//    private volatile static int num = 0;
    private volatile static AtomicInteger num = new AtomicInteger();


    public static void add() {
//        num ++; //不是一个原子操作
        num.getAndIncrement(); //AtomicInteger + 1 方法 CAS
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

//        while (Thread.activeCount() > 2) { // main gc线程
//            Thread.yield();
//        }

        System.out.println(Thread.currentThread().getName() + num);
    }
}
