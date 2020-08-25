package SynThread;



/**
 * @author admin_cg
 * @date 2020/8/10 17:23
 */
//不安全取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000, "xxoo");
        Drawing you = new Drawing(account, 50, "you");
        Drawing gf = new Drawing(account, 100, "gf");

        you.start();
        gf.start();

    }

}

// 账户
class Account{
    int money; //余额
    String name; // 卡号

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行
class Drawing extends Thread{
    Account account; //账户
    //取了多少钱
    int drawingMoney;
    // 现在还有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized(account){
            if(account.money - drawingMoney <0){
                System.out.println(Thread.currentThread().getName() + "没钱了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            nowMoney += drawingMoney;
            System.out.println(account.name + "余额" + account.money);
            System.out.println(this.getName() + "手里的钱" + nowMoney);
        }
        //判断有没有钱

    }
}