package others;

/**
 * @author admin_cg
 * @date 2020/8/6 19:31
 */
public class doubles {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 4, 5, 6, 7, 7, 8, 9};
        int sum = 9;
        int i = 0, j = a.length - 1;
        int count= 0;
        while(i < j){
            if(a[i] + a[j] == sum){
                count ++;
                j--;
            }
            if(a[i] + a[j] > sum){
                j--;
            }
            if(a[i] + a[j] < sum){
                j = a.length - 1;
                i++;
            }
        }
        System.out.println(count);
    }


}
