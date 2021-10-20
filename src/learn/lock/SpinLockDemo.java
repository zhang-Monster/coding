package learn.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 自定义自旋锁的实现
 *
 * @date Created in 2021/10/17 下午2:50
 */
public class SpinLockDemo {

    /**
     * 引用对象Thread 没有的话默认赋值为null
     */
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    /**
     * 加锁
     */
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> myLock" );

        // 这里实现自旋
        while (!atomicReference.compareAndSet(null,thread)){

        }

    }

    /**
     * 解锁
     */
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==> myUnlock");
        atomicReference.compareAndSet(thread,null);
    }
}
