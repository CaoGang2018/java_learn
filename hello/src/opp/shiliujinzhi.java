package opp;

import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/5 18:27
 */
public class shiliujinzhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            int sum = 0;
            for(int i = 2; i < s.length(); i++){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                    sum = sum *16 + (s.charAt(i) - '0');
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'F')
                    sum = sum*16 + (s.charAt(i) - 'A' + 10);
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'f')
                    sum = sum*16 + (s.charAt(i) - 'a' + 10);
            }
            System.out.println(sum);
        }
    }
}
