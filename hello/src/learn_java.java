import java.io.Console;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/9/3 20:37
 */

public class learn_java {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(numWays(sc.nextInt()));
        sc.close();

    }

    // 递归获取某文件夹下的所有文件
    private static void getFileList(String path){
        File file = new File(path);
        File[] files = file.listFiles();

        if(files == null)
            return;
        for (File file1 : files) {
            if(file1.isFile()) {
                if (file1.getPath().contains(".java")) // 筛选条件
                    System.out.println(file1.getPath());
            }
            else getFileList(file1.getPath());
        }
    }

    public static int numWays(int n){
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
