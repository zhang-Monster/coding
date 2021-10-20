package learn.Thread;

import java.util.Collections;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/9/17 上午10:37
 */
public class UnsafeThread {

    private int value = 1;

    public synchronized int incrementAndGet() {
        return value++;
    }

    public static void main(String[] args) {
        UnsafeThread unsafeThread = new UnsafeThread();
        new Thread(() -> {
            while (true) {
                System.out.println("用户" + Thread.currentThread().getName() + "买了第" + unsafeThread.incrementAndGet() + "张票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"张三").start();

        new Thread(() -> {
            while (true) {
                System.out.println("用户" + Thread.currentThread().getName() + "买了第" + unsafeThread.incrementAndGet() + "张票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"李四").start();

        new Thread(() -> {
            while (true) {
                System.out.println("用户" + Thread.currentThread().getName() + "买了第" + unsafeThread.incrementAndGet() + "张票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"王五").start();
    }

}
