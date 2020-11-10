package others.leecode;

/**
 * @author admin_cg
 * @data 2020/10/12 19:07
 */
public class Solution_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        swap(nums, 0, n - k - 1);
        swap(nums, n-k, n-1);
        swap(nums, 0, n-1);

    }

    private void swap(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }

    private void circleReplace(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int curIndex = start;
            int preNum = nums[start];
            do {
                int next = (curIndex + k) % nums.length;
                int temp = nums[next];
                nums[next] = preNum;
                preNum = temp;
                curIndex = next;
                count++;
            } while (curIndex != start);
        }
    }
}
