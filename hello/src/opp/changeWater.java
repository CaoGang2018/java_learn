package opp;

import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/5 17:54
 */
public class changeWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0) return;
            System.out.println(numWater(n));
        }

    }
    public static int numWater(int n){
        if(n < 2) return 0;
        int num = 0;
        while(n >= 2){
            if(n == 2){
                num += 1;
                n = 1;
            }
            num += n / 3;
            int x = n % 3;
            n = n / 3 + x;
        }

        return num;
    }
}
