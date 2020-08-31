package others.leecode;


/**
 * @author admin_cg
 * @date 2020/8/29 15:14
 */
public class Solution_64 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
