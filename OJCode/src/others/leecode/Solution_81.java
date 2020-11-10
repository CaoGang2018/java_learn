package others.leecode;

/**
 * @author admin_cg
 * @data 2020/10/14 15:11
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 */
public class Solution_81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[left]){
                ++left;
                continue;
            } else if (nums[mid] == nums[right]){
                right--;
                continue;
            }
            if (nums[mid] > nums[right]){
                if (nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
