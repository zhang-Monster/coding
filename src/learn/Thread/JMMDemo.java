package learn.Thread;

import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: volatile可见性验证
 * @date Created in 2021/10/11 下午10:54
 */
public class JMMDemo {

    // 不加volatile 程序就会死循环
    // 加了volatile保证可见性
    private volatile static int num = 0;

    public static void main(String[] args) {


        new Thread(() ->{
            while (num == 0) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        System.out.println(num);
    }
}
