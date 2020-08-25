package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/21 14:31
 */
public class Solution_33 {
    public static void main(String[] args) {
        Solution_33 ss = new Solution_33();
        int[] t = {4,5,6,7,0,1,2};
        int[] t1 = {4,5,6,7,0,1,2};
        int[] t2 = {5,1,3};
        System.out.println(ss.search(t, 0));
        System.out.println(ss.search(t1, 3));
        System.out.println(ss.search(t2, 3));
    }
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = i + (j-i) / 2;
            if(nums[mid] == target) return mid;
            if(nums[i] <= nums[mid]){
                if(nums[i] <= target && target < nums[mid]){
                    j = mid - 1;
                }
                else{
                    i = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[j]){
                    i = mid +1;
                }
                else{
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}
