package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/18 16:04
 */
public class Solution_5 {
    public static void main(String[] args) {
        String s = "babad";
        Solution_5 ss = new Solution_5();
        System.out.println(ss.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(centerExplend(s, i, i), centerExplend(s, i, i+1));
            if(len > end - start){
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }

    public int centerExplend(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }
}
