import javax.swing.plaf.TableHeaderUI;

/**
 * @author admin_cg
 * @date 2020/8/9 17:40
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Your you = new Your();
        Thread thread = new Thread(god);
        thread.setDaemon(true);

        thread.start();

        new Thread(you).start();
    }
}

class Your implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println(" Happy Alive");
        }
        System.out.println("Goodbye World");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("sssssss");
        }
    }
}
