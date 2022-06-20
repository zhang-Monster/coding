package learn.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/12/23 下午4:28
 */
public class TestWait {
    public static final Object lock = new Object();

    public static void testWait() throws InterruptedException{
        synchronized (lock) {
            System.out.println("mmm");
            lock.wait();
            System.out.println("aaa");
        }
    }

    public static void testNotify() throws InterruptedException{
        synchronized (lock) {
            System.out.println("bbb");
            lock.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {


//        ExecutorService service = Executors.newFixedThreadPool(2);

        new Thread(() ->{
            try {
                testWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->{
            try {
                testNotify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
