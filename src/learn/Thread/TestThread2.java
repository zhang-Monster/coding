package learn.Thread;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 创建线程方式2：实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
 * @date Created in 2021/9/20 下午2:10
 */
public class TestThread2 implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        // 创建runnable接口的实现类对象
        TestThread2 testThread2 = new TestThread2();
        new Thread(testThread2).start();


        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }
}
