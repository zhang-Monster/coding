package learn.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/9/21 下午12:36
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable{

    int ticketNums = 10;

    /**
     * 定义lock锁
     */
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticketNums > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
