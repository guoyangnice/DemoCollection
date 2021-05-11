package map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author yangjie
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        System.out.println("初始化后，TreeMap元素个数为：" + treeMap.size());

        treeMap.put("hello", 1);
        treeMap.put("world", 2);
        treeMap.put("my", 3);
        treeMap.put("name", 4);
        treeMap.put("is", 5);
        treeMap.put("jiaboyan", 6);
        treeMap.put("i", 6);
        treeMap.put("am", 6);
        treeMap.put("a", 6);
        treeMap.put("developer", 6);

        System.out.println("添加元素后,TreeMap元素个数为：" + treeMap.size());

        Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("TreeMap元素的key:" + key + ",value:" + value);
        }
    }
}
