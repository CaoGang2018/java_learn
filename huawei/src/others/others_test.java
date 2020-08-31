package others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author admin_cg
 * @date 2020/8/31 14:32
 */
public class others_test {
    public static void main(String[] args) {
        String[] name = {"ab", "ac", "bc", "bd", "dc", "cd"};
        String[] add= "{{'a',\"花园小区\"},{'b',\"长安小区\"},{'d',\"幸福小区\"}}".split("\"},\\{");
        Map<Character, String> map = new HashMap<>();
        List<String> ans = new LinkedList<>();
        for (String s : add) {
            String[] temp = s.split("',\"");
            int n = temp[0].length() - 1;
            map.put(temp[0].charAt(n), temp[1].replaceAll("}", "").replaceAll("\"",""));
        }
        for (String s : name) {
            if (map.containsKey(s.charAt(0)))
                System.out.println(s + " " + map.get(s.charAt(0)));
            else
                System.out.println(s + " not found.");
        }
    }
}
