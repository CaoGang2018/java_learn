import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/6 19:59
 */
public class gongbeishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(a*b / maxNum(a, b));
        }
    }
    public static int maxNum(int a, int b){ // 最大公约数
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int t = max % min;
        if(t == 0) return min;
        while (t != 0){
            max = min;
            min = t;
            t = max % min;
        }
        return min;
    }

}
