package learn.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:  验证ReentrantLock可重入性
 * @date Created in 2021/10/17 下午2:00
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();

        new Thread(() ->{
            phone2.sms();
        },"A").start();
        new Thread(() ->{
            phone2.sms();
        },"B").start();
    }
}

class Phone2{
    ReentrantLock lock = new ReentrantLock();

    public void sms(){
        try {
            lock.lock();

            // 这里有个细节问题 锁需要配对
//            lock.lock();
            System.out.println(Thread.currentThread().getName() + "sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void call() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
