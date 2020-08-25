package SynThread;

/**
 * @author admin_cg
 * @date 2020/8/10 17:07
 */
public class UnsafeBuyTicket{
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        Thread t1 = new Thread(station, "小狗");
        Thread t2 = new Thread(station, "小毛");
        Thread t3 = new Thread(station, "小明");
        t1.start();
        t2.start();
        t3.start();
    }
}

class BuyTicket implements Runnable {

    //票
    private int ticketNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag){
            try {
                Thread.sleep(1000);
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //  synchronized 同步
    private synchronized void buy() {
        if(ticketNum <= 0){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNum--);
    }
}
