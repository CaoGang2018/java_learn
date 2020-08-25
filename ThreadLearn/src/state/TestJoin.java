package state;

/**
 * @author admin_cg
 * @date 2020/8/9 17:09
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);



        // 主线程
        for (int i = 0; i < 500; i++) {
            if(i == 200){
                thread.start();
                thread.join(); //插队
            }
            System.out.println("main" + i);
        }
    }
}


