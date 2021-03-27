package singleton;

public class LHan {
    public LHan lHan;

    public  LHan(){};

    public LHan getInstance(){
        if(lHan == null){
            return new LHan();
        }
        return lHan;
    }
}
