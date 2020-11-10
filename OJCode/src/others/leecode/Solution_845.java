package others.leecode;



/**
 * @author admin_cg
 * @data 2020/10/25 14:30
 */
public class Solution_845 {
    public int longestMountain(int[] A) {
        int ans = 0;
        for (int i = 1; i < A.length - 1; i++) {
            ans = Math.max(ans, helper(A, i));
        }
        return ans;
    }
    private int helper(int[] A, int i) {
        int left = i, right = i;
        while (left > 0 && A[left - 1] < A[left]){
            left--;
        }
        while (right < A.length - 1 && A[right + 1] < A[right]){
            right++;
        }
        if (left == i || right == i)
            return 0;
        else return right - left +1;
    }

    private int longestMountain(int[] A, int i) {
        int len = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < len){
            int right = left + 1;
            if (A[left] < A[left + 1]){
                while (right + 1 < len && A[right] < A[right + 1])
                    ++right;
                if (right < len - 1 && A[right] > A[right + 1]){
                    while (right + 1 < len && A[right] > A[right + 1])
                        ++right;
                    ans = Math.max(ans, right - left + 1);
                } else
                    ++right;
            }
            left= right;
        }
        return ans;
    }
}
