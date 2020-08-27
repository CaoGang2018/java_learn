package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/27 18:03
 */
public class Solution_91 {
    public int numDecodings(String s) {
        int[] ans = new int[s.length()];
        if("0".equals(s)) return 0;
        if(s.length() == 1) return 1;
        return backtrack(s, ans, 0);

    }
    public int backtrack(String s, int[] ans, int start){
        if(start >= s.length()){
            return 1;
        }
        char c = s.charAt(start);
        if(c == '0') return 0;
        if(start == s.length()-1) return 1;
        if(ans[start] != 0) return ans[start];
        if(c >= '3')
            return backtrack(s, ans, start+1);
        char next = s.charAt(start+1);
        if(next == '0'){
            ans[start] = backtrack(s, ans, start+2);
            return ans[start];
        }
        if(next <= '6'){
            ans[start] = backtrack(s, ans, start+1) + backtrack(s, ans, start+2);
            return ans[start];
        }
        if(c == '1'){
            ans[start] = backtrack(s, ans, start+1) + backtrack(s, ans, start+2);
            return ans[start];
        }
        ans[start] = backtrack(s, ans, start+1);
        return ans[start];
    }
}
