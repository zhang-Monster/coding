package learn.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 线程创建方式三：实现callable接口
 * @date Created in 2021/9/20 下午2:42
 */
public class TestCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "=====");
        return true;
    }

    public static void main(String[] args) throws Exception{
        TestCallable t1 = new TestCallable();
//        TestCallable t2 = new TestCallable();
//        TestCallable t3 = new TestCallable();

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t1);
        Future<Boolean> r3 = service.submit(t1);

        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        service.shutdown();


    }
}
