package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/18 16:39
 */
public class Solution_10 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int i1 = 1; i1 <= n; i1++) {
                if(p.charAt(i1-1) == '*'){
                    dp[i][i1] = dp[i][i1-2];
                    if(match(s, p, i, i1-1)){
                        dp[i][i1] = dp[i][i1] || dp[i-1][i1];
                    }
                }
                else {
                    if(match(s, p, i, i1)){
                        dp[i][i1] = dp[i-1][i1-1];
                    }
                }
            }
        }
        return dp[m][n];
    }
    public boolean match(String s, String p, int i, int j) {
        if(i == 0)
            return false;
        if(p.charAt(j-1) == '.')
            return true;
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
