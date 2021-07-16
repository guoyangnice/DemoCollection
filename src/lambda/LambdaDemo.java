package lambda;

import lombok.Data;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * lambda基础
 *
 * @author yangjie
 */
public class LambdaDemo {
    public static void main(String[] args) {
        getArrayListResult();
        wuCan();
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.getList();
        lambdaDemo.useMap();
        lambdaDemo.userFilter();
        lambdaDemo.useLimit();
    }

    private static void getArrayListResult() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("ewq", "ewqw", "qqqq", "wsxedc"));
        list.forEach(str -> {
            if (str.length() > 3) {
                System.out.println(str);
            }
        });
    }

    /**
     * 无参，无返回值
     */
    public static void wuCan() {
        Runnable r1 = () -> System.out.println("Hello World");
        r1.run();
    }

    /**
     * 需要一个参数,demo,小括号可以省略
     */
    public static void needOne() {
        Consumer<String> con = x -> System.out.println(x);
    }

    /**
     * 1、需要两个参数，可以省略return和大括号
     * 2、Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”。
     */
    public static void needTwo() {
        Comparator<Integer> cpm = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };

        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    /**
     * 整体就是对数据进行一些调整处理
     * 具体操作包括了：filter, map, reduce, find, match, sorted
     * java8 ： 双冒号（类名::方法名）
     *
     * @param widgets
     */
    public void handleSteam(List<Widget> widgets) {
        int transactionsIds =
                widgets.stream()
                        .filter(b -> b.getColor().equals("RED"))
//                .sorted((x, y) -> x.getWeight() - y.getWeight())
                        .mapToInt(Widget::getWeight)
                        .sum();
    }

    public void getList() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "");
        List<String> filtered = strings.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        filtered.stream().forEach(System.out::println);
    }

    /**
     * map:用于映射每个元素到对应的结果
     * sorted：排序
     */
    public void useMap() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squareList = numbers.stream()
                .map(i -> i * i)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        squareList.stream().forEach(System.out::println);
    }

    /**
     * 统计数量,统计空格的数量
     * filter：得到的意思，要注意下
     */
    public void userFilter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = strings.stream()
                .filter(string -> string.isEmpty())
                .count();
        System.out.println(count);
    }

    /**
     * limit:用于获取指定数量的流
     */
    public void useLimit(){
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }


}

@Data
class Widget {
    private String color;
    private int weight;
}
