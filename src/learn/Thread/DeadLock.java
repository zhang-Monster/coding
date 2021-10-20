package learn.Thread;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 死锁：多个线程互相拥有对方需要的资源，然后形成僵持
 * @date Created in 2021/9/21 下午12:01
 */
public class DeadLock {

    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"灰姑娘");
        Makeup g2 = new Makeup(1,"白雪公主");

        g1.start();
        g2.start();

    }
}

class Lipstick{

}

class Mirror{

}

class Makeup extends Thread{

    /**
     * 需要的资源只有一份 因此用static进行修饰
     */
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    Makeup(int choice,String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeUp() throws Exception{
        if (choice ==0) {
            // 获得lipstick的锁
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得了口红的锁");
                Thread.sleep(1000);
                // 一秒后获得镜子
                synchronized (mirror) {
                    System.out.println(this.girlName + "获得了镜子的锁");
                }
            }
        }else {
            synchronized (mirror) {
                System.out.println(this.girlName + "获得了镜子的锁");
                Thread.sleep(2000);
                // 两秒后获得镜子
                synchronized (lipstick) {
                    System.out.println(this.girlName + "获得了口红的锁");
                }
            }

            // 解决死锁不要进行锁嵌套即可
        }
    }
}
