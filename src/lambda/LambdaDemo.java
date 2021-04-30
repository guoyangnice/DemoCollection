package lambda;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * lambda基础
 * @author yangjie
 */
public class LambdaDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("ewq","ewqw","qqqq","wsxedc"));
        list.forEach(str->{
            if(str.length() > 3){
                System.out.println(str);
            }
        });
    }
}
