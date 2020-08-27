package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/26 18:25
 * 最长连续子序列
 */
public class largest {
    public static void main(String[] args) {
        String s = "abcdddefhhik";
        System.out.println(Largest(s));
    }
    public static String Largest(String s){
        int cur = 1, max = 1, maxP = 0;
        int tmp = 1;
        while(cur < s.length()){
            if(s.charAt(cur) - s.charAt(cur-1) == 1){
                tmp++;
            }
            else{
                if(tmp > max){
                    max = tmp;
                    maxP = cur - max;
                }
                tmp = 1;
            }
            cur++;
        }
        return s.substring(maxP, maxP + max);
    }
}
