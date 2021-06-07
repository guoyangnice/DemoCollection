package patterndesign.singleton;

/**
 * 枚举模式最安全，反射和序列化都是单例
 * @author yangjie
 */
public class SingleTonEnum {
    private SingleTonEnum(){}

    private enum Singleton{
        INSTANCE;

        private final SingleTonEnum instance;

        Singleton(){
            instance = new SingleTonEnum();
        }

        private SingleTonEnum getInstance(){
            return instance;
        }
    }

    private static SingleTonEnum getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
}
