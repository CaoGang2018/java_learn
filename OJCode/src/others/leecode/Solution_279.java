package others.leecode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/31 19:14
 */
public class Solution_279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int max_square = (int)Math.sqrt(n)+1;
        int[] squre_number = new int[max_square];
        for (int i = 0; i < max_square; i++) {
            squre_number[i] = i*i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < max_square; j++) {
                if(i < squre_number[j])
                    break;
                dp[i] = Math.min(dp[i], dp[i-squre_number[j]]+1);
            }
        }
        return dp[n];
    }
}
