package others.leecode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/26 17:37
 */
public class Solution_75 {

    public static void main(String[] args) {
        int[] mums = {2,0,2,1,1,0};
        sortColors(mums);
        System.out.println(Arrays.toString(mums));
    }
    public static void sortColors(int[] nums) {
        int p0 = 0, cur = 0, p2 = nums.length-1;
        int temp = 0;
        while (cur <= p2){
            if(nums[cur] == 0){
                temp = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = temp;
                p0++;
                cur++;
            }
            else if(nums[cur] == 2){
                temp = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = temp;
                p2--;
            }
            else cur++;
        }
    }
}
