package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/19 14:36
 */
public class Solution_647 {
    public static void main(String[] args) {
        Solution_647 ss = new Solution_647();
        String s = "aaa";
        System.out.println(ss.countSubstrings(s));
        System.out.println(ss.dpCountSubstring(s));
    }

    public int dpCountSubstring(String s){
        if(s.length() == 0) return 0;
        int ans = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 <= i; i1++) {
                if(i1 == i){
                    dp[i1][i] = true;
                    ans++;
                }
                else {
                    boolean b = s.charAt(i) == s.charAt(i1);
                    if(i - i1 == 1 && b){
                        dp[i1][i] = true;
                        ans++;
                    }
                    else if(i - i1 > 1 && b && dp[i1+1][i-1]){
                        dp[i1][i] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public int countSubstrings(String s) {
        int ans = 1;
        for (int i = 0; i < s.length()-1; i++) {
            ans += centerExtend(s, i, i);
            ans += centerExtend(s, i, i+1);
        }
        return ans;
    }
    public int centerExtend(String s, int l, int r) {
        int ans = 0;
        while (l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))){
            ans++;
            l--;
            r++;
        }
        return ans;
    }
}
