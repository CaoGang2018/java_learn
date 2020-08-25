package SynThread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/10 17:50
 */
public class UnsafeList {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}
