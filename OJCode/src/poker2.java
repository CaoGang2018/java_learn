import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/8/6 18:32
 */
public class poker2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String in = sc.nextLine();
            if(in.contains("joker JOKER")){
                System.out.println("joker JOKER");
                continue;
            }
            String[] sp = in.split("-");
            String[] left = sp[0].split(" ");
            String[] right = sp[1].split(" ");
            if(left.length == 4 && right.length != 4){
                System.out.println(sp[0]);
                continue;
            }
            if(left.length !=4 && right.length == 4){
                System.out.println(sp[1]);
                continue;
            }
            if(left.length == right.length){
                if(max(left[0]) > max(right[0])){
                    System.out.println(sp[0]);
                    continue;
                }else{
                    System.out.println(sp[1]);
                    continue;
                }
            }else{
                System.out.println("ERROR");
                continue;
            }

        }
    }
    public static int max(String str){
        return "345678910JQKA2jokerJOKER".indexOf(str);
    }
}
