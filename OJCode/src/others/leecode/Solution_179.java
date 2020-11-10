package others.leecode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @data 2020/10/12 19:39
 */
public class Solution_179 {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, ((o2, o1) -> (o1 + o2).compareTo(o2 + o1)));
        if (str[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }
}
