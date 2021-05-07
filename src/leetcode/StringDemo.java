package leetcode;

public class StringDemo {
    public static void main(String[] args) {
        String str = "abcd";
        char ch = str.charAt(0);
        System.out.println(ch);
        System.out.println(str.charAt(str.length()-1));
        System.out.println(solve(str));
    }

    public static String solve (String str) {
        // write code here
        if(str == null || str == ""){
            return str;
        }
        char[] ch = str.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while(i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }
}
