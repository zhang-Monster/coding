package learn.Thread;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 推导lambda表达式
 *
 * @date Created in 2021/9/20 下午4:24
 */
public class TestLambda {

    /**
     * 静态内部类
     *
     */
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();


        /**
         * 局部内部类
         */
        class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        like = new Like3();
        like.lambda();

        //匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        //lambda简化
        like = () -> {
            System.out.println("i like lambda5");
        };
        like.lambda();
    }
}


/**
 * 定义函数式接口
 */
interface ILike{
    void lambda();
}

class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
