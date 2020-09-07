package others.nowcode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/10 10:32
 */
public class UniqueSplit {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,0};
        int[] index = {0,1,2,3,0};
        for(int x : createTargetArray(nums, index))
            System.out.println(x);

    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] tar = new int[nums.length];
        Arrays.fill(tar, 101);
        for(int i = 0; i< nums.length; i++){
            System.out.println(i);
            if(tar[index[i]] != 101){
                int j = index[i];
                while(tar[j] != 101 && j < nums.length){
                    j++;
                }
                //System.out.println(j);
                for(; j>index[i]; j--){
                    tar[j] = tar[j-1];
                }
                tar[index[i]] = nums[i];
            }
            else{
                tar[index[i]] = nums[i];
            }
        }
        return tar;

    }

}
