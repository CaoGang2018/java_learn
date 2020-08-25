package array;

import java.util.StringJoiner;

/**
 * @author admin_cg
 * @date 2020/8/4 22:23
 */
public class DemoArrays06 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 7, 9};
        printArrays(a);
    }
    public static void printArrays(int[] a){
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for(int s : a){
            sj.add(String.valueOf(s));
        }
        System.out.println(sj.toString());
    }
}
