package patterndesign.strategy;

/**
 * @author yangjie
 * @date 2021/7/21 11:15 下午
 * @desc
 */
public class PlaneStrategy implements Strategy{
    @Override
    public String queryConditionResult() {
        return "选择飞机，这里实现自己的逻辑";
    }
}
