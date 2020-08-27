package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/26 15:33
 */
public class Solution_48 {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int[] ints : matrix) {
            revise(ints);
        }

    }
    public void revise(int[] nums){
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }
}
