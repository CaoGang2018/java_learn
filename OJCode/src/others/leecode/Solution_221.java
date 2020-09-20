package others.leecode;

/**
 * @author admin_cg
 * @data 2020/9/20 12:49
 *
 * 最大正方形
 */
public class Solution_221 {
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return maxArea;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0)
                        dp[i][j] = 1;
                    else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                maxArea = Math.max(maxArea, dp[i][j]);
            }
        }
        return maxArea * maxArea;
    }
}
