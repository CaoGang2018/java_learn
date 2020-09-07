package huawei_0812;

/**
 * @author admin_cg
 * @date 2020/8/25 17:12
 */

class MoneyBox{
    int five;
    int ten;
    int twenty;

    public MoneyBox() {
        this.five = 0;
        this.ten = 0;
        this.twenty = 0;
    }
}

public class coffeeCoin {
    public boolean lemonadeChange(int[] bills) {
        if(bills == null) return true;
        MoneyBox moneyBox = new MoneyBox();
        for(int b : bills){
            if(b == 5)
                moneyBox.five++;
            else if(b == 10){
                moneyBox.ten++;
                if(moneyBox.five == 0)
                    return false;
                else
                    moneyBox.five--;
            }
            else if(b == 20){
                moneyBox.twenty++;
                if(moneyBox.ten != 0 && moneyBox.five !=0){
                    moneyBox.ten--;
                    moneyBox.five--;
                }
                else if(moneyBox.five >= 3){
                    moneyBox.five -= 3;
                }
                else return false;
            }
            else return false;
        }
        return true;
    }
}
