package others.leecode;

/**
 * @author admin_cg
 * @date 2020/9/3 18:59
 */
public class Solution_557 {
    public static void main(String[] args) {
        Solution_557 ss = new Solution_557();
        String s = "Let's take LeetCode contest";
        System.out.println(ss.reverseWords(s));
    }
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1, j = 0;
        while (i >= 0){
            if(s.charAt(i) != ' '){
                sb.insert(j++, s.charAt(i));
            }
            else {
                sb.insert(0, ' ');
                j = 0;
            }
            i--;
        }
        return sb.toString();
    }
}
