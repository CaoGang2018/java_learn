/**
 * @author admin_cg
 * @date 2020/8/4 21:43
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ws = new int[]{8, 0, 6, 10, 2, 3};
        bubbleSort(ws);
        for(int s : ws){
            System.out.print(s + " ");
        }
    }
    private static void bubbleSort(int[] nums){
        int count = 0;
        boolean flag = false;
        for(int i = 0; i < nums.length; i++){
            for(int j = nums.length-1; j >i; j--){
                flag = false;
                if(nums[j] > nums[j-1]) {
                    int t = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = t;
                    flag = true;
                    count = i;
                }
            }
            if(flag == false) {
                System.out.println(count);
                return;
            }
        }
    }
}
