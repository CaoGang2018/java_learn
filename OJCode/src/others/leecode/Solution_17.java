package others.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/24 18:05
 */
public class Solution_17 {
    public static void main(String[] args) {
        Solution_17 ss = new Solution_17();
        for(String s : ss.letterCombinations("235"))
            System.out.println(s);
        System.out.println(ss.different());
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if(digits.length() == 0) return ans;
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }
    public void backtrack(String digits, int begin, StringBuilder cur, List<String> ans){
        if(begin == digits.length()){
            ans.add(cur.toString());
            return;
        }
        char[] t = getString(digits.charAt(begin));
        for (char c : t) {
            backtrack(digits, begin + 1, cur.append(c), ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public char[] getString(char ch){
        return switch (ch) {
            case '2' -> new char[]{'a', 'b', 'c'};
            case '3' -> new char[]{'d', 'e', 'f'};
            case '4' -> new char[]{'g', 'h', 'i'};
            case '5' -> new char[]{'j', 'k', 'l'};
            case '6' -> new char[]{'m', 'n', 'o'};
            case '7' -> new char[]{'p', 'q', 'r', 's'};
            case '8' -> new char[]{'t', 'u', 'v'};
            case '9' -> new char[]{'w', 'x', 'y', 'z'};
            default -> new char[0];
        };
    }

    public int different(){
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 1, 4};
        int ans = nums1[0] ^ nums2[0];
        int i = 1;
        while(i < Math.min(nums1.length, nums2.length)){
            ans ^= nums2[i];
            ans ^= nums1[i];
            i++;
        }
        while(i < Math.max(nums1.length, nums2.length)){
            if(nums1.length > nums2.length)
                ans ^= nums1[i];
            else{
                ans ^= nums2[i];
            }
            i++;
        }
        return ans;
    }
}
