package struct;

/**
 * @author admin_cg
 * @date 2020/8/4 21:16
 */
public class Detest {
    public static void main(String[] args) {
        for(int i = 1; i <= 4; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 5; j >= i; j--) {
                System.out.print("*");
            }
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 1; i <= 5; i++){
            for(int j = 5; j > i; j--){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int j = 1; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
