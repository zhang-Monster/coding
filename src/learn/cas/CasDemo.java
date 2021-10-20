package learn.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/10/16 下午5:27
 */
public class CasDemo {


    public static void main(String[] args) {

//        AtomicInteger atomicInteger = new AtomicInteger(2021);

        // cas 比较 更新
        // 如果期望值达到了，那么就更新，否则，就不更新
        // 底层 unsafe.compareAndSwapInt()采用do-while 自旋锁实现
//        System.out.println(atomicInteger.compareAndSet(2021, 2022));
//        System.out.println(atomicInteger.get());
//
//        System.out.println(atomicInteger.compareAndSet(2021,2022));
//        System.out.println(atomicInteger.get());


        /**=============CAS ABA 问题验证================ */
        // 注意：如果泛型是一个包装类 注意对象的引用问题
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1,1);

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("a1=>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(1,2,
                    atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);

            System.out.println("a2=>" + atomicStampedReference.getStamp());

            System.out.println(atomicStampedReference.compareAndSet(2, 1,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            System.out.println("a3=>" + atomicStampedReference.getStamp());

        },"a").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("b1=>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference.compareAndSet(1,6,stamp,stamp+1));

            System.out.println("b2=>" + atomicStampedReference.getStamp());
        },"b").start();


    }
}
