package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/29 14:54
 */
public class Solution_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++){
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for(int i = 0; i < obstacleGrid[0].length; i++){
            if(obstacleGrid[0][1] == 1) break;
            dp[0][i] = 1;
        }
        System.out.println(dp[0][0]);
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1? 0 : dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
