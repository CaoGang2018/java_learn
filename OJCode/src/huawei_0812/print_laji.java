package huawei_0812;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/25 16:31
 */
public class print_laji {
    public static void main(String[] args) {
         //  abcdefghijklmnopqrstuvwxyz 3
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        System.out.println(laji_print(input[0], Integer.parseInt(input[1])));
        sc.close();
    }

    private static String laji_print(String nextLine, int n) {
        List<StringBuilder> ansTmp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ansTmp.add(new StringBuilder());
        }
        int i = 0;
        int len = nextLine.length();
        while(i < len){
            for(int j = 0; j < n/2 && i < len; j++){
                ansTmp.get(j).append(nextLine.charAt(i++));
                if(i < len)
                    ansTmp.get(n-1-j).append(nextLine.charAt(i++));
            }
            if(i < len){
                ansTmp.get(n/2).append(nextLine.charAt(i++));
            }

            for(int j = n/2-1; j > 0 && i < len; j--){
                ansTmp.get(j).append(nextLine.charAt(i++));
                if(i < len)
                    ansTmp.get(n-1-j).append(nextLine.charAt(i++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder s : ansTmp){
            sb.append(s.toString());
            System.out.println(s.toString());
        }

        return sb.toString();
    }
}
