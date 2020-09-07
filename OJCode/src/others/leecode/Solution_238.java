package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/31 18:32
 */
public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 1)
            return new int[0];
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i-1] * left[i-1];
        }
        /*int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = nums[i+1] * right[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            left[i] *= right[i];
        }
        */
        int r = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            r *= nums[i+1];
            left[i] *= r;
        }
        return left;
    }
}
