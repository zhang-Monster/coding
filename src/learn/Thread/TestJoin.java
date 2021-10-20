package learn.Thread;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/9/20 下午10:47
 */
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 启动线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        // 主线程
        for (int i = 0; i < 100; i++) {
            if (i==10) {
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
