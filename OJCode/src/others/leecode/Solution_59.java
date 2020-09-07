package others.leecode;

/**
 * @author admin_cg
 * @date 2020/9/3 15:43
 */
public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if(n == 0) return ans;
        int start = 1;
        int left = 0, right = n-1, up = 0, down = n-1;
        while(start < n*n+1){
            for (int i = left; i <= right && start < n*n+1; i++) {
                ans[up][i] = start++;
            }
            up++;
            for (int i = up; i <= down && start < n*n+1; i++) {
                ans[i][right] = start++;
            }
            right--;
            for (int i = right; i >= left && start < n*n+1; i--) {
                ans[down][i] = start ++;
            }
            down--;
            for (int i = down; i >= up && start < n*n+1; i--) {
                ans[i][left] = start++;
            }
            left++;
        }
        return ans;
    }
}
