package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/30 17:33
 */
public class Solution_329 {
    public int longestIncreasingPath(int[][] matrix) {
        int pre = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, 0, 0));
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int m, int n){
        if(m < 0 || n < 0 || m >= matrix.length || n >= matrix[0].length)
            return 0;
        int left = 0, right = 0, up = 0, down = 0;
        if(m > 0 && matrix[m-1][n] > matrix[m][n])
            up = 1 + dfs(matrix,m-1, n);
        if(m < matrix.length-1 && matrix[m+1][n] > matrix[m][n])
            down = 1 + dfs(matrix, m+1, n);
        if(n > 0 && matrix[m][n-1] > matrix[m][n])
            left = 1 + dfs(matrix, m, n-1);
        if(n < matrix[0].length-1 && matrix[m][n+1] > matrix[m][n])
            right = 1 + dfs(matrix, m, n+1);
        return Math.max(Math.max(Math.max(up, down), left), right);

    }
}
