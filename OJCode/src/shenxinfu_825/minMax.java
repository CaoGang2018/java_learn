package shenxinfu_825;

/**
 * @author admin_cg
 * @date 2020/8/25 22:04
 */
public class minMax {
    public static void main(String[] args) {
        int[] t = {7,2,5,10,8};
        minMax mx = new minMax();
        int k = 2;
        System.out.println(mx.MinMax(t, k));
    }
    public int MinMax(int[] nums, int k){
        int left = 0, right = 0;
        for(int num : nums){
            right += num;

        }
        while(left < right){
            int mid = left + (right - left) / 2;
            int m = check(nums, mid);
            if(m > k){
                left = mid + 1;
            }
            else right = mid;
        }
        return left;
    }

    public int check(int[] nums, int x) {
        int count = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(sum > x){
                sum = 0;
                count ++;
            }
        }
        return count;
    }
}
