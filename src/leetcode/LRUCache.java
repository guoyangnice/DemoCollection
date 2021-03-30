package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer,Integer> map;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        //先删除旧的位置，再放入新的位置
        Integer value = map.remove(key);
        map.put(key,value);
        return value;
    }
}
