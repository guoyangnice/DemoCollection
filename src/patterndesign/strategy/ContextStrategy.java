package patterndesign.strategy;

/**
 * @author yangjie
 * @date 2021/7/21 11:55 下午
 * @desc
 */
public class ContextStrategy {
    public static String getChoice(String method) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(null == method || "".equals(method)){
            return "method不能为空";
        }
        Strategy strategy = (Strategy) StrategyFactory.getConditionResult(method);
        if(null == strategy){
            return "没有对应的策略";
        }
        return strategy.queryConditionResult();
    }
}
