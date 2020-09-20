import java.io.Console;
import java.io.File;
import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/9/3 20:37
 */
public class learn_java {
    public static void main(String[] args) {
        // String 类 长度 method
        String s = "java学习";
        System.out.println(s.length());
        System.out.println(s.codePointCount(0,4));

        getFileList("E:\\java");

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
}
