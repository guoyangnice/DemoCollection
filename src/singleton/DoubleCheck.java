package singleton;
//双检锁模式-线程安全，这里注意下volatile和synchronized的作用
public class DoubleCheck {
    public static volatile DoubleCheck doubleCheck = null;

    private DoubleCheck(){}

    public static DoubleCheck getInstance(){
        if(doubleCheck == null){
            synchronized (DoubleCheck.class){
                if(doubleCheck == null){
                    return new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }
}
