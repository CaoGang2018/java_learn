package Runableuse;

/**
 * @author admin_cg
 * @date 2020/8/9 14:29
 */
public class TestThread implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while(true){
            if(ticket == 0){
                System.out.println("票已卖完！！");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + ticket-- + "张票！");
        }
    }

    public static void main(String[] args) {
        TestThread t = new TestThread();

        new Thread(t, "小明").start();
        new Thread(t, "小花").start();
        new Thread(t, "阿狗").start();
    }
}
