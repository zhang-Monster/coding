package learn.annotation;

import javax.annotation.Resource;
import java.lang.annotation.*;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 测试元注解
 *
 * @date Created in 2021/10/20 下午3:02
 */
@MyAnnotation(name = "mlamp",age = 6)
public class TestAnnotation {

    /**
     * 注解可以显式赋值 如果没有默认值，我们就必须给注解赋值
     */
    @MyAnnotation(age = 2)
    public void test() {

    }
}

/**
 * @author mlamp
 * @Target 表示我们的目标可以用在什么位置
 * @Retention 表示我们的注解在什么地方还有效 runtime > class > sources
 * @Documented 表示是否将我们的注解生成在javadoc中
 * @Inherited 继承父类的注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{

    // 注解的参数：参数类型 + 参数名()；
    String name() default "";
    int age() ;

}
