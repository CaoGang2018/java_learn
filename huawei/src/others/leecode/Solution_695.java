package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/24 12:27
 */
public class Solution_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxConnected(grid, i, j), maxArea);
            }
        }
        return maxArea;

    }
    public int maxConnected(int[][] grid, int m, int n){
        if(m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] == 0)
            return 0;
        int ans = 1;
        grid[m][n] = 0;
        return ans + maxConnected(grid, m+1, n) +
               maxConnected(grid, m-1, n) +
               maxConnected(grid, m, n-1) +
               maxConnected(grid, m, n+1);
    }
}
