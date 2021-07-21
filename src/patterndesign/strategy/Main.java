package patterndesign.strategy;

/**
 * @author yangjie
 * @date 2021/7/22 12:05 上午
 * @desc
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println(ContextStrategy.getChoice("car"));
    }
}
