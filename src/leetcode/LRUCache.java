package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
//这里使用的是最通用的写法，LinkedHashMap的插入模式，也可以使用LinkedHashMap的访问模式，更加简单

public class LRUCache {
    int capacity;
    Map<Integer,Integer> map;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    /**
     * 访问，会把最经常访问的，放在最后一个
     * @param key
     * @return
     */
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        //先删除旧的位置，再放入新的位置
        Integer value = map.remove(key);
        map.put(key,value);
        return value;
    }

    /**
     * 会把新放入的放在最后一个
     * @param key
     * @param value
     */
    public void put(int key,int value){
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        map.put(key,value);
        //超出capacity，删除最久没用的，利用迭代器删除第一个
        if(map.size() > capacity){
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
