package others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/24 14:14
 */
public class Solution_824_360 {
    public static void main(String[] args) {
        //int[][] t = {{1,1},{3,1},{5,1},{2,0},{2,0}};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] t = new int[n][2];
        for (int i = 0; i < n; i++) {
            t[i][0] = sc.nextInt();
            t[i][1] = sc.nextInt();
        }
        sc.close();
        Solution_824_360 ss = new Solution_824_360();
        System.out.println(ss.maxScore(t));
    }
    public int maxScore(int[][] nums){
        Arrays.sort(nums, (o1, o2) -> o1[1] - o2[1] == 0 ? o2[0] - o1[0] : o1[1] - o2[1]);
        int ans = 0;
        for (int[] num : nums) {
            //System.out.println(num[0]);
            //System.out.println(num[1]);
            if (num[1] == 0)
                ans += num[0];
            else {
                ans = Math.max(2 * ans, ans + num[0]);
            }
        }
        return ans;
    }
}
