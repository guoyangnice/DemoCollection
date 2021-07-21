package patterndesign.strategy;

/**
 * @author yangjie
 * @date 2021/7/21 11:16 下午
 * @desc
 */
public class CarStrategy implements Strategy{

    @Override
    public String queryConditionResult() {
        return "选择车，这里实现自己的逻辑";
    }
}
