/**
 * @author admin_cg
 * @date 2020/8/6 17:20
 */
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.Scanner;

public class Poker {

    public static int index(String str) {
        String  poker="345678910JQKA2jokerJOKER";//可能会有比单牌
        return poker.indexOf(str);
    }

    public static int min(String[] str) {
        int min=15;
        for(int i=0; i<str.length; i++) {
            if(index(str[i])<min)
                min=index(str[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);//这种输入要学会
        while(scan.hasNext())//这是要接受多组输入的节奏啊
        {
            String input=scan.nextLine();
            if(input.indexOf("joker")!=-1 &&input.indexOf("JOKER")!=-1)//有大小王
            {
                System.out.println("joker JOKER");
                break;
            }
            String[] pokers=input.split("-");
            String[] poker1=pokers[0].split("\\s+");//左侧的扑克 \\s+表示一个或多个空格
            String[] poker2=pokers[1].split("\\s+");//右侧的扑克
            if(poker1.length==4&&poker2.length!=4)
            {
                System.out.println(pokers[0]);
                break;
            }
            if(poker1.length!=4&&poker2.length==4)
            {
                System.out.println(pokers[1]);
                break;
            }

            //剩余的情况全是按index大小比较了

            if(poker1.length!=poker2.length)
            {
                System.out.println("ERROR");//两边无法比较
                break;
            }
            if(min(poker1)<min(poker2))
                System.out.println(pokers[1]);
            else
                System.out.println(pokers[0]);
        }

    }

}