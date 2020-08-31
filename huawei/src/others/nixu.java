package others;

/**
 * @author admin_cg
 * @date 2020/8/31 12:49
 */
public class nixu {
    public static void main(String[] args) {
        int[] a = {1,2,4};
        int[] b = {3,5,6};
        int[] temp = new int[6];
        //System.out.println(mergeAndCount(a, 0, 2, 5, b));
        System.out.println(mergeCount(a, b, 3));

    }
    private static int mergeCount(int[] numa, int[] numb, int n){
        int index = 0;
        int count = 0;
        int i = 0, j = 0;
        while(i < n && j < n){
            if(numa[i] < numb[j]){
                i++;
            }
            else{
                if(numa[i] > numb[j]){
                    count += n-i;
                    j++;
                }
            }
        }
        return count;
    }
    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        if (right + 1 - left >= 0) System.arraycopy(nums, left, temp, left, right + 1 - left);

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
