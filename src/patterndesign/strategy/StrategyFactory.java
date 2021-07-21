package patterndesign.strategy;

import java.util.Objects;

/**
 * @author yangjie
 * @date 2021/7/21 11:21 下午
 * @desc
 * -https://www.cnblogs.com/chong-zuo3322/p/13724847.html
 */
public class StrategyFactory {
    /**
     * 返回对应的类，也就是加载对应的类
     * @param <T>
     * @return
     */
    public static<T> T getConditionResult(String method) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(Objects.isNull(method) || "".equals(method)){
            return null;
        }
        String className = "";
        for(CodeEnum value : CodeEnum.values()){
            if(value.getMethod().equals(method)){
                className = value.getClassName();
                break;
            }
        }
        return (T) Class.forName(className).newInstance();
    }
}
