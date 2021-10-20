package learn.Thread;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/9/20 下午5:18
 */
public class TestLambda2 {

    /**
     * 总结：
     *  1、lambda表达式只能有一行代码的情况下才能简化为一行，如果有多行，那么就只能用代码块包裹
     *  2、前提是接口为函数式接口
     *  3、多个参数也可以去掉参数类型，要去掉就都去掉，必须加上括号
     *
     */


    public static void main(String[] args) {
        ILove love = null;

        // lambda表达式简化
//        love = (int a,int b) -> {
//            System.out.println("i love you -->" + a + "and" + b );
//        };

        // 简化参数类型
//        love = (a,b) -> {
//            System.out.println("i love you -->" + a + "and" + b );
//        };

        // 简化花括号
        love = (a,b) -> System.out.println("i love you -->" + a + "and" + b );
        love.love(1,2);
    }
}

interface ILove {
    void love(int a,int b);
}
