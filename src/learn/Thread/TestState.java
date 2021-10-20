package learn.Thread;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/9/20 下午11:10
 */
public class TestState {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("///////");
        });

        // 观测线程状态
        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
    }
}
