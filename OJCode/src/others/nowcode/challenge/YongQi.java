package others.nowcode.challenge;

import java.util.Scanner;

/**
 * @author admin_cg
 * @data 2020/9/29 20:21
 */
public class YongQi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            if(n % 2 == 0){
                n = (n - 2) / 2;
                sb.append("G");
            }
            else{
                n = (n - 1) / 2;
                sb.append("N");
            }
        }
        System.out.println(sb.reverse().toString());

    }
}
