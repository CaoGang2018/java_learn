package huawei_0812;

/**
 * @author admin_cg
 * @date 2020/8/25 17:26
 */
public class JumpBox {
    public static void main(String[] args) {
        int[][] nums = {{1,0,1,0,0,0,1}, {0,0,0,0,0,0,0},{1,0,1,0,1,0,0}, {0,0,0,0,0,0,0},{1,0,1,0,1,0,1}};
        System.out.println(jump(nums));
    }
    public static boolean jump(int[][] nums){
        return dfs(nums, 0, 0);
    }
    private static boolean dfs(int[][] nums, int m, int n){
        if( m >= nums.length || n >= nums[0].length || m < 0 || n < 0 || nums[m][n] != 1) return false;
        if( m == nums.length-1 && n == nums[0].length-1)
            return true;
        nums[m][n] = 2;
        return dfs(nums, m+2, n) || dfs(nums, m-2, n)
                || dfs(nums, m, n+2) || dfs(nums, m, n-2);
    }
}
