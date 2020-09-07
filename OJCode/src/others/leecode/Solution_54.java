package others.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/23 20:29
 */
public class Solution_54 {
    public static void main(String[] args) {
        Solution_54 ss = new Solution_54();
        int[][] ma = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(ss.spiralOrder(ma).toString());
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return ans;
        int left = 0, right = matrix[0].length-1;
        int top = 0, bottom = matrix.length-1;
        int max = (bottom+1)*(right+1);
        while(max > 0){
            for (int i = left; i <= right && max > 0; i++) {
                ans.add(matrix[top][i]);
                --max;
            }
            top++;
            for (int i = top; i <= bottom && max > 0; i++) {
                ans.add(matrix[i][right]);
                --max;
            }
            right--;
            for (int i = right; i >= left && max > 0; i--) {
                ans.add(matrix[bottom][i]);
                --max;
            }
            bottom--;
            for (int i = bottom; i >= top && max > 0; i--) {
                ans.add(matrix[i][left]);
                --max;
            }
            left++;
        }
        return ans;
    }
}
