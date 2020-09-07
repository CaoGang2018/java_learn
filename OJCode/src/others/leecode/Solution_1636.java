package others.leecode;

import java.util.logging.Level;

/**
 * @author admin_cg
 * @date 2020/8/31 13:14
 */
public class Solution_1636 {
    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        Solution_1636 ss = new Solution_1636();
        System.out.println(ss.reversePairs(nums));

    }
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len < 2)
            return 0;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len-1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if(left == right)
            return 0;
        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(nums, left, mid, temp);
        int rightCount = reversePairs(nums, mid+1, right, temp);
        if(nums[mid] <= nums[mid+1])
            return leftCount + rightCount;
        int crossCount = mergeCount(nums, left, mid, right, temp);
        return leftCount + rightCount + crossCount;

    }

    private int mergeCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if(i == mid + 1){
                nums[k] = temp[j];
                j++;
            }
            else if(j == right + 1){
                nums[k] = temp[i];
                i++;
            }
            else if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }
            else {
                nums[k] = temp[j];
                j++;
                count += (mid-i+1);
            }
        }
        return count;
    }
}
