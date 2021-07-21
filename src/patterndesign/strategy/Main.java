package patterndesign.strategy;

/**
 * @author yangjie
 * @date 2021/7/22 12:05 上午
 * @desc
 * 本次的实现是基于之前的项目来的。
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println(ContextStrategy.getChoice("car"));
    }
}
