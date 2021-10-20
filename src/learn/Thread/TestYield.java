package learn.Thread;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/9/20 下午10:39
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }

}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        // 礼让 让当前线程重新进入就绪状态 争抢cpu资源
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
