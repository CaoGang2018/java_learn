package others;

/**
 * @author admin_cg
 * @date 2020/8/10 19:40
 */
public class niniu {
    public static void main(String[] args) {
        int[] a = {0, 1, 1, 6, 2, 2, 3, 5, 5, 8, 9, 7, 7}; // i+1的父亲节点
        int t = 10, b =13, k = 2;
        game(a, t, b, k);
    }
    public static void game(int[] t, int a, int b, int k){
        if(Grandfather(t, a, b)){  // 不移动  判断a
            System.out.println("A");
            return;
        }
        else if(Grandfather(t, b, a)){  // 不移动  判断b
            System.out.println("B");
            return;
        }
        while(k>0){
            a = t[a-1]; // a 走一步
            if(Grandfather(t, a, b)){
                System.out.println(t[a-1]);
                System.out.println("A");
                return;
            }
            b = t[b-1]; // b 走一步
            if(Grandfather(t, b,  a)){
                System.out.println("B");
                return;
            }
            k--;
        }
        System.out.println("A==B");
    }

    public static boolean Grandfather(int[] t, int a, int b){ //k 步 判断a 是b的祖先
        if(b == 1) return false;
        if(a == 1) return true;
        if(a == b) return  true;
        else{
            return Grandfather(t, a, t[b-1]);
        }

    }
}
