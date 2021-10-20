package learn.Thread;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 多个线程操作同一个对象（买火车票的例子）
 * @date Created in 2021/9/20 下午2:22
 */
public class TestThread3 implements Runnable{



    private int ticketNums = 10;

    /**
     * 这里会出现问题：当多个线程同时操作一个资源的情况下，线程不安全，数据紊乱
     */
    @Override
    public  void run() {
        while (true && ticketNums > 0 ) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---> 拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();

        new Thread(testThread3,"小明").start();
        new Thread(testThread3,"老师").start();
        new Thread(testThread3,"黄牛党").start();
    }
}
