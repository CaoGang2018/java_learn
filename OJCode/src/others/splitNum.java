package others;

/**
 * @author admin_cg
 * @date 2020/8/8 15:17
 */
public class splitNum {
    public static void main(String[] args) {
        int[] tm = new int[1000000000];
        int[] a = {5, 3, 7};
        int count = 0;
        for(int i = 0; i < a.length; i++){
            int n = a[i];
            if(tm[a[i]] != 0){
                count += tm[a[i]];
            }
            else{
                int co = 0;
                while (n > 1){
                    n -= 2;
                    co ++;
                    if(tm[n] != 0){
                        co += tm[n];
                        break;
                    }
                }
                count += co;
                tm[a[i]] = co;
            }
        }
        System.out.println(count);
    }

}
