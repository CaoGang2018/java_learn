import java.util.*;

/**
 * @author admin_cg
 * @date 2020/8/6 16:53
 */
class ErrorInfo{
    String name;
    int line;
    int count = 1;
}
public class ErroeRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ErrorInfo> list = new ArrayList<>();
        while (sc.hasNext()){
            ErrorInfo record = new ErrorInfo();
            String[] lines = sc.nextLine().split(" ");
            String name = lines[0];
            int ind = name.lastIndexOf('\\');
            record.name = (ind < 0)?name:name.substring(ind+1);
            record.line = Integer.parseInt(lines[1]);
            boolean flag = true;
            for(ErrorInfo er : list) {
                if (er.name.equals(record.name) && er.line == record.line) {
                    er.count++;
                    flag = false;
                    break;
                }
            }
            if(flag)
                list.add(record);
        }
        sc.close();
        Collections.sort(list, (p1, p2) -> (p1.count-p2.count)*(-1));
        for(int i = 0; i < ((list.size()<8)?list.size():8); i++){
            ErrorInfo er = list.get(i);
            String name = (er.name.length() < 16)?er.name : er.name.substring(er.name.length()-16);
            System.out.println(name + " " + er.line + " " + er.count);
        }
    }
}
