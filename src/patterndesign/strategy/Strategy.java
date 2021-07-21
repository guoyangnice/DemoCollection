package patterndesign.strategy;

/**
 * @author yangjie
 * @date 2021/7/21 10:40 下午
 * @desc
 *
 * 策略模式主要的应用场景：去掉if、else
 * 工厂模式应用场景：怎样更好的加载一个类
 *
 */
public interface Strategy {
    /**
     * 查询是否符合条件
     */
    String queryConditionResult();
}
