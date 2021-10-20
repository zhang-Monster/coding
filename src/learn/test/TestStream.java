package learn.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/9/22 下午2:24
 */
public class TestStream {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("4");

        Set<String> set = new HashSet();
//        set.addAll(list);
//        set.addAll(list2);

        List<String> list3 = new ArrayList<>(set);
//        list3.addAll(set);



        System.out.println(list3);



    }
}
