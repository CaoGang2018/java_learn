package SynThread;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author admin_cg
 * @date 2020/8/10 18:17
 */
// 测试GUC安全
public class TestGUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() ->{
                list.add(Thread.currentThread().getName());
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
