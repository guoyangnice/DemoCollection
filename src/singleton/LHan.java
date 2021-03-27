package singleton;
//懒汉模式-只有使用的时候再实例化
public class LHan {
    public static LHan lHan = null;

    public  LHan(){};

    public LHan getInstance(){
        if(lHan == null){
            return new LHan();
        }
        return lHan;
    }
}
