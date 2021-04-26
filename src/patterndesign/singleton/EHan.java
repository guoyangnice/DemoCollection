package patterndesign.singleton;
//饿汗模式-不管使用不使用，都会生成实例
public class EHan {
    public static EHan eHan = new EHan();

    private EHan(){}

    public static EHan getInstance(){
        return eHan;
    }
}
