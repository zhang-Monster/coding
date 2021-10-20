package learn.Thread;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:模拟 生产者-消费者模式
 * @date Created in 2021/9/21 下午1:22
 */
public class TestPC {

    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();

        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}

/**
 * 生产者
 */
class Productor extends Thread{

    SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread{

    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->" + synContainer.pop().id + "只鸡");
        }
    }
}

/**
 * 产品
 */
class Chicken{

    int id;
    public Chicken(int id) {
        this.id = id;
    }

}

/**
 * 数据缓冲区
 */
class SynContainer{

    /**
     * 创建一个容器
     */
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    /**
     * 生产者放入产品
     * @param chicken
     */
    public synchronized void push(Chicken chicken){

        // 如果容器满了 就需要等待消费者消费
        if (count == chickens.length) {
            // 通知消费者消费 生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果没有满的话，我们就需要丢入产品
        chickens[count] = chicken;
        count++;

        // 可以通知消费者消费
        this.notifyAll();
    }

    /**
     * 消费者消费产品
     * @return
     */
    public synchronized Chicken pop(){

        // 先判断有没有产品去消费
        if (count == 0) {

            // 产品不足 等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //可以消费
        count --;
        Chicken chicken = chickens[count];

        //消费完了 通知生产者生产
        this.notifyAll();


        return chicken;
    }

}