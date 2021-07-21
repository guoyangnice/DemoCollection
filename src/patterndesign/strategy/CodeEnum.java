package patterndesign.strategy;

/**
 * @author yangjie
 * @date 2021/7/21 11:18 下午
 * @desc
 */
public enum CodeEnum {
    PLANE("plane", "patterndesign.strategy.PlaneStrategy"),
    CAR("car", "patterndesign.strategy.CarStrategy");

    private String method;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    private String className;

    public String getMethod() {
        return method;
    }

    public void setValue(String method, String className) {
        this.method = method;
        this.className = className;
    }

    CodeEnum(String method, String className){
        this.setValue(method, className);
    }
}
