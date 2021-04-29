package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedDemo {
    public static void main(String[] args) {
        insertSort();
        visitSort();
    }

    /**
     * 插入排序：修改和添加新值，都是按照插入的顺序
     */
    public static void insertSort(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>(4);
        map.put("q1","1");
        map.put("q2","2");
        map.put("q3","3");
        map.put("q4","4");
        map.put("q2","5");
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("Key:" + entry.getKey() + "  value:" + entry.getValue());
        }
    }

    /**
     * 访问排序，修改或者新增、获取的，都会跑到最末尾
     */
    public static void visitSort(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>(4,0.75f,true);
        map.put("q1","1");
        map.put("q2","2");
        map.put("q3","3");
        map.put("q4","4");
        map.put("q2","7");
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("Key:" + entry.getKey() + "  value:" + entry.getValue());
        }
    }
}
