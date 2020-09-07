package others.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author admin_cg
 * @date 2020/8/22 19:27
 */
public class test {
    public static void main(String[] args) {
        int[] nums = {1, 2,3, 4};
        int[] mnum = {1, 2, 1};
        test t = new test();
        System.out.println(t.saocaozuo(nums, mnum));
    }
    public String saocaozuo(int[] nums, int[] mnums){
        if(mnums.length == 0) return Arrays.toString(nums);
        int i = 0;
        for (int i1 = 0; i1 < mnums.length - 1; i1++) { // 去除22
            if(mnums[i1] == mnums[i1+1] && mnums[i1] == 2){
                mnums[i1] = 0;
                mnums[i1+1] = 0;
                i++;
            }
        }
        while(i < mnums.length){
            int c = 0;
            if(mnums[i] == 2) {
                move2(nums);
                continue;
            }
            while(i < mnums.length && mnums[i] != 2 ){
                if(mnums[i] == 1) c++;
                i++;
            }

            if(c == nums.length) continue;
            if(c > nums.length) c %= nums.length;
            move(nums, 0, c-1);
            move(nums, c, nums.length - 1);
            move(nums, 0, nums.length - 1);
            i++;
        }
        return Arrays.toString(nums);
    }
    private void move(int[] nums, int i, int j){
        while(i < j){
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
            i++;
            j--;
        }
    }
    private void move2(int[] nums){
        int i = 0;
        while(i < nums.length){
            int t = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = t;
            i += 2;
        }
    }
}
