package shenxinfu_825;

/**
 * @author admin_cg
 * @date 2020/8/25 19:39
 */
public class maxMin {
    public static void main(String[] args) {
        int[] t = {7,2,5,10,8};
        maxMin mx = new maxMin();
        int k = 2;
        System.out.println(mx.splitArray(t, k));
    }
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for(int num : nums){
            left = Math.max(num, left);
            right += num;
        }
        while(left < right){
            int mid = left +(right - left) / 2;
            int k = check(nums, mid);
            if(k > m){
                left = mid + 1;
            }
            else right = mid;
        }
        return left;
    }

    public int check(int[] nums, int x) {
        int count = 1;
        int sum = 0;
        for(int num : nums){
            if(sum + num > x){
                count++;
                sum = num;
            }
            else sum += num;
        }
        return count;
    }
}
