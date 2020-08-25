package others.leecode;

import java.util.ArrayList;

/**
 * @author admin_cg
 * @date 2020/8/22 12:46
 */
public class Solution_679 {
    public static void main(String[] args) {
        int[] tmp = {7, 4, 5, 6};
        Solution_679 ss = new Solution_679();
        System.out.println(ss.judgePoint24(tmp));

    }
    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> num = new ArrayList<>();
        for(int x : nums){
            num.add((double)x);
        }
        return backtrack(num);
    }

    public boolean backtrack(ArrayList<Double> nums){
        if(nums.size() == 0) return false;
        if(nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;
        for (int i = 0; i < nums.size(); i++) {
            for (int i1 = 0; i1 < nums.size(); i1++) {
                if(i1 != i){
                    ArrayList<Double> nums2 = new ArrayList<>();
                    for (int i2 = 0; i2 < nums.size(); i2++) {
                        if(i2 != i1 && i2 != i)
                            nums2.add(nums.get(i2));
                    }
                    for(int k = 0; k <4; k++){
                        if(k < 2 && i1 > i) continue;
                        if(k == 0) {
                            nums2.add(nums.get(i) + nums.get(i1));
                        }
                        if(k == 1) {
                            nums2.add(nums.get(i) * nums.get(i1));
                        }
                        if(k == 2) {
                            nums2.add(nums.get(i) - nums.get(i1));
                        }
                        if(k == 3){
                            if(nums.get(i1) != 0){
                                nums2.add(nums.get(i) / nums.get(i1));
                            }
                            else continue;
                        }
                        if(backtrack(nums2)) return true;
                        nums2.remove(nums2.size()-1);
                    }
                }
            }
        }
        return false;
    }
}
