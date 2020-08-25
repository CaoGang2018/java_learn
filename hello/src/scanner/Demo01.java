package scanner;

import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/4 21:04
 */
public class Demo01 {
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++){
            for(int j = 1; j <= i; j++){
                if(i == j){
                    System.out.print(i + " x " + j + " = " + i*j);
                }
                else
                    System.out.print(i + " x " + j + " = " + i*j + " ");
            }
            System.out.print("\n");
        }
    }
}
