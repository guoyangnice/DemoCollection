package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串：使用哈希表
 * @author yangjie
 */
public class Lc205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> s2t = new HashMap<>();
        Map<Character,Character> t2s = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char x = s.charAt(i), y = t.charAt(i);
            if((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && s2t.get(y) != x)){
                return false;
            }
            s2t.put(x,y);
            t2s.put(y,x);
        }
        return true;
    }
}
