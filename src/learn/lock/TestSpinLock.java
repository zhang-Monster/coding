package learn.lock;

import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/10/17 下午2:59
 */
public class TestSpinLock {

    public static void main(String[] args) {
        SpinLockDemo lock = new SpinLockDemo();

        new Thread(() -> {
            lock.myLock();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.myUnLock();
            }
        },"T1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            lock.myLock();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.myUnLock();
            }
        },"T2").start();
    }


}
