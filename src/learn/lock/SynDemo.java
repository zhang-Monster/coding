package learn.lock;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 验证synchronized的可重入性
 * @date Created in 2021/10/17 下午1:50
 */
public class SynDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() ->{
            phone.sms();
        },"A").start();
        new Thread(() ->{
            phone.sms();
        },"B").start();
    }
}

class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName() + "sms");
        // 注意这里也有一把锁
        call();
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName() + "call");
    }
}
