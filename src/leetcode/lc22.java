package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc22 {
    List<String> list = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        helper("",0,0);
        return list;
    }
    public void helper(String curr,int left,int right){
        //递归出口
        if(left == n && right == n){
            list.add(curr);
            return;
        }
        //剪枝  的条件
        if(left > n || left < right){
            System.out.println(list);
            return;
        }
        helper(curr + "(" ,left + 1,right);
        helper(curr + ")",left,right + 1);
    }

    public static void main(String[] args) {
        System.out.println(new lc22().generateParenthesis(3));
    }
}
