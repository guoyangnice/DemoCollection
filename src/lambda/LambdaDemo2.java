package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 尝试使用Java8自带的常用函数式接口-https://mmbiz.qpic.cn/mmbiz_png/eQPyBffYbuflAIHxeAlDrM7xK8JrNAicwEo07y8LxWXMdBEbwsXQIyX0DLuHmbP1RKpKyzU9iavbiaHrwrJdMu5tg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1
 * 1、Predicate
 * 2、ConSumer
 * 3、Function
 * 4、Supplier
 * 5、UnaryOperator
 * 6、BinaryOperate
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        testPredicate();
        testComsumer();
        testFunction();
    }

    /**
     * predicate:返回boolean
     */
    public static void testPredicate() {
        Predicate<Integer> predicate = x -> x > 185;
        Student student = new Student("小明", 23, 175);
        System.out.println("Predicate的输出结果：身高是否大于185:" + predicate.test(student.getHeight()));
    }

    /**
     * consumer:输出一个值
     */
    public static void testComsumer(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("这是consumer输出的值");
    }

    /**
     * function：输出对象的值
     */
    public static void testFunction(){
        Function<Student, String> function = Student::getName;
        Student student = new Student("小明", 23, 175);
        String name = function.apply(student);
        System.out.println("function输出：" + name);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private String name;
    private int age;
    private int height;
}
