package shenxinfu_825;

/**
 * @author admin_cg
 * @date 2020/8/25 18:53
 */
public class first {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abced";
        int len1 = s1.length();
        int len2 = s2.length();
        int ans = (s1.charAt(0)-'a')^(s2.charAt(0)-'a');
        int i = 1;
        for (; i < Math.min(len1, len2); i++) {
            ans ^= s1.charAt(i)-'a';
            ans ^= s2.charAt(i)-'a';
        }
        if(len1 > len2){
            ans ^= s1.charAt(i)-'a';;
        }
        else
            ans ^= s2.charAt(i)-'a';;

        char out = (char)('a' + ans);
        System.out.println(out);
    }
}
