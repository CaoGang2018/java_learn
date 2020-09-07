package others;

import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/24 20:35
 * 基数排序
 */
public class Radix_sort {
    public static void main(String[] args) {
        Radix_sort rr = new Radix_sort();
        int[] nums = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        rr.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sort(int[] nums){
        int d = maxNum(nums);

        int m = 1;
        int n = 1;
        int[][] tmp = new int[10][nums.length];
        int[] order = new int[10];
        while(m <= d){
            for(int num : nums){
                int ind = (num / n) % 10;
                tmp[ind][order[ind]] = num;
                order[ind] ++;
            }
            int k = 0;
            for (int i = 0; i < 10; i++) {
                if(order[i] != 0)
                    for (int j = 0; j < order[i]; j++) {
                        nums[k++] = tmp[i][j];
                    }
                order[i] = 0;
            }
            ++m;
            n *= 10;
        }
    }
    public int maxNum(int[] nums){
        int max = nums[0];
        for(int num : nums){
            if(num > max)
                max = num;
        }
        int n = 0;
        while (max > 0){
            ++n;
            max /= 10;
        }
        return n;
    }
}
