package others.nowcode;

import java.util.HashSet;

/**
 * @author admin_cg
 * @date 2020/8/6 20:46
 */
public class A {
    public static void main(String[] args) {

    }
    public static boolean isIsomorphic(int[] nums, int k) {
        HashSet<Integer> ha = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(ha.contains(nums[i])) return true;
            ha.add(nums[i]);
            if(ha.size() > k)
                ha.remove(nums[i-k]);
        }
        return false;
    }
}
